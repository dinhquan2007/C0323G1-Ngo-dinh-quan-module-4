package com.codegym.controller;

import com.codegym.service.IServiceConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
@Autowired
    private IServiceConvert serviceConvert;
@PostMapping ("/convert")
    public String showResult(Model model,@RequestParam float usd,@RequestParam float rate){
    double result= serviceConvert.ConvertUSDToVND(usd,rate);
    model.addAttribute("result",result);
    return "result";
}
@GetMapping("/showForm")
    public String showForm(){
    return "index";
}
}
