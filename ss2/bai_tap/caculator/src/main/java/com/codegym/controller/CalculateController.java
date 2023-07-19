package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculateController {
    @GetMapping("/")
    public String showCalculate() {
        return "index";
    }

    @PostMapping
    public ModelAndView view(double operandFirst, double operandSecond, String operator) {
        double result = 0;
        ModelAndView modelAndView = new ModelAndView("index");
        switch (operator) {
            case "+":
                result = operandFirst + operandSecond;
                break;
            case "-":
                result = operandFirst - operandSecond;
                break;
            case "*":
                result = operandFirst * operandSecond;
                break;
            case "/":
                if (operandSecond == 0) {
                    return modelAndView.addObject("mess", "số bị chia không thể là 0");
                } else {
                    result = operandFirst / operandSecond;
                }
                break;
        }
        return modelAndView.addObject("result", result);
    }
}
