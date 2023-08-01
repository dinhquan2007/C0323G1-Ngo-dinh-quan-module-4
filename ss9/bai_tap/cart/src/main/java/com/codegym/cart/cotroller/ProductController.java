package com.codegym.cart.cotroller;

import com.codegym.cart.dto.CartDto;
import com.codegym.cart.dto.ProductDto;
import com.codegym.cart.model.Product;
import com.codegym.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }
@Autowired
    private IProductService productService;
    @GetMapping
     public ModelAndView showProductList(@SessionAttribute(value = "cart",required = false) CartDto cartDto,
                                         @CookieValue(value = "productId",required = false,defaultValue = "-1")Long id){
      return new ModelAndView("/product/list","productList",productService.findAll());
    }
    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id, HttpServletResponse response){
        Cookie cookie=new Cookie("productId",id+"");
        cookie.setMaxAge(60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new  ModelAndView("product/detail","product",productService.findById(id));
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id,@SessionAttribute(value = "cart")CartDto cart){
        Product product=productService.findById(id);
        if (product!=null){
            ProductDto productDto=new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }

}
