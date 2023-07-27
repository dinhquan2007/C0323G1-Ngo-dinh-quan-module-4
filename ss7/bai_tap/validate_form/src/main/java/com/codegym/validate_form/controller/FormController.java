package com.codegym.validate_form.controller;

import com.codegym.validate_form.Dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class FormController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/view";
    }

    @PostMapping("/")
    public ModelAndView create(@Valid @ModelAttribute UserDto userDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        UserDto userDto1 = new UserDto();
        ModelAndView modelAndView = new ModelAndView("view");
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("userDto",userDto);
            return modelAndView;
        }
        BeanUtils.copyProperties(userDto, userDto1);
        return new ModelAndView("result");
    }


}
