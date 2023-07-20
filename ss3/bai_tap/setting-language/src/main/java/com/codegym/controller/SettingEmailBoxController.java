package com.codegym.controller;

import com.codegym.model.EmailBox;
import com.codegym.service.IEmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SettingEmailBoxController {
    @Autowired
    IEmailBoxService emailBoxService;
    @GetMapping("/")
    public String showList(Model model) {
        System.out.println(emailBoxService.showSetting());
        model.addAttribute("emailBox",emailBoxService.showSetting());
    return "list";
    }

    @GetMapping("/edit")
    public String showEditForm(@ModelAttribute EmailBox emailBox, Model model) {
        model.addAttribute("emailBox",emailBoxService.showSetting());
        return "index";
    }
    @PostMapping("/edit")
    public String showSetting(@ModelAttribute EmailBox emailBox, Model model) {
        model.addAttribute("emailBox",emailBox);
        return "list";
    }
    @ModelAttribute("language")
    public String[] getLanguage(){
        return new String[]{"english","vietnamese","japanese","tung của"};
    }
    @ModelAttribute("pageSize")
    public int[] getPageSize(){
        return new int[]{5,10,15,25,50,100};
    }

}
