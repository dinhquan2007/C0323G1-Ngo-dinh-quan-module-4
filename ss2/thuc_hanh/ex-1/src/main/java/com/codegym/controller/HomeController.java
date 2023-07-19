package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {
private static final String EMAIL_REGEX="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
private static Pattern pattern;
private Matcher matcher;

    public HomeController() {
        pattern=Pattern.compile(EMAIL_REGEX);
    }
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @PostMapping(value = "/validate")
    public String user(@RequestParam("email") String email, ModelMap modelMap){
        boolean isValidate=this.validate(email);
        if (!isValidate){
            modelMap.addAttribute("mess","email is invalidate");
            return "home";
        }
        modelMap.addAttribute("email",email);
        return "success";
    }

    private boolean validate(String email) {
        matcher=pattern.matcher(email);
        return matcher.matches();
    }
}
