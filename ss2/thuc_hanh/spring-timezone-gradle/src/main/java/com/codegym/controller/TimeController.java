package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TimeController{
    @GetMapping("/world-clock")
public  String getTimeByTimezone(ModelMap modelMap.@RequestParam(name="city",re))
}