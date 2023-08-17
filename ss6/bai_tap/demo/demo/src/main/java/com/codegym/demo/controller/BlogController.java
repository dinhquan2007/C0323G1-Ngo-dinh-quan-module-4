package com.codegym.demo.controller;

import com.codegym.demo.model.Blog;
import com.codegym.demo.model.Category;
import com.codegym.demo.service.blogService.IBlogService;
import com.codegym.demo.service.categoryService.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("category")
    public List<Category> listCategory() {
        return categoryService.getAll();
    }

    @GetMapping("/list")
    ModelAndView getAll(@RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "") String searchName) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by("timePost").descending());
        Page<Blog> blogPage = blogService.getAll(pageable, searchName);
        ModelAndView modelAndView = new ModelAndView("list_blog");
        modelAndView.addObject("blogPage", blogPage);
        modelAndView.addObject("searchName", searchName);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    String showDetail(Model model, @PathVariable int id) {
        Blog blog = blogService.findById(id);
        model.addAttribute(blog);
        return "detail_blog";
    }
    @GetMapping("/create")
    String showCreateForm(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        return "create_blog";
    }
    @PostMapping("/create")
    String createBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        LocalDate date;
        date = LocalDate.now();
        blog.setTimePost(String.valueOf(date));
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "save success");
        return "redirect:/blog/list";
    }
    @GetMapping("/edit/{id}")
    String showFormEdit(@PathVariable int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "update_blog";
    }
    @GetMapping("/delete/{id}")
    String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id);
        blogService.delete(blog);
        redirectAttributes.addFlashAttribute("message", "delete success!!!!!!!!!");
        return "redirect:/blog/list";
    }
    @PostMapping("/edit")
    String updateBlog( Blog blog, RedirectAttributes redirectAttributes ) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "save success");
        return "redirect:/blog/list";
    }
    @GetMapping("/test")
    String showTest() {
        return "/test";
    }

}
