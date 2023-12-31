package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @ModelAttribute("productList")
    public List<Product> list(){
        return productService.getAll();
    }
    @GetMapping("/list")
    public String showList(@RequestParam(value = "message",required = false)String message, Model model){
        model.addAttribute("message",message);
        return "list";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
       return "edit";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
    return "detail";
    }
    @PostMapping("/update")
    public String update(Product product,RedirectAttributes redirectAttributes){
        productService.update(product);
        redirectAttributes.addAttribute("message","edit success");
        return "redirect:list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable int id, Model model) {
        Product product=productService.findById(id);
        model.addAttribute("product", product);
        return "delete";
    }

    @PostMapping("/delete")
    public String remove(@RequestParam int id, RedirectAttributes redirectAttributes) {
        productService.remove(productService.findById(id));
        redirectAttributes.addAttribute("message", "delete success");
        return "redirect:list";
    }
    @GetMapping("/search")
    public String findWithName(@RequestParam("searchName") String searchName ,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("productList",productService.findByName(searchName));
        redirectAttributes.addFlashAttribute("searchName",searchName);
        return "redirect:list";
    }
    @PostMapping("/create")
    public String save(Product product, RedirectAttributes redirectAttributes){
    productService.save(product);
    redirectAttributes.addAttribute("message","add success");
    return "redirect:list";
    }

}
