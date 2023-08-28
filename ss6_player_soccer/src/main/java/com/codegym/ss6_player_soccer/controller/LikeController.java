package com.codegym.ss6_player_soccer.controller;

import com.codegym.ss6_player_soccer.dto.LikeDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/like")
public class LikeController {
    @GetMapping
    public String showListLike(@SessionAttribute(value = "like",required = false)LikeDto likeDto,
                               Model model){
        model.addAttribute("like",likeDto);
        return "/list_like";
    }
}
