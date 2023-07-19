package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class CondimentsController {
    @GetMapping("/")
    public String show() {
        return "index";
    }
@PostMapping
    public String showSave(String condiment, Model model) {
        String result="";
        if (condiment!=null){
            result+=condiment;
            model.addAttribute("result",result);
        }else {
            model.addAttribute("result","don't condiment");
        }
        return "index";
    }
}
