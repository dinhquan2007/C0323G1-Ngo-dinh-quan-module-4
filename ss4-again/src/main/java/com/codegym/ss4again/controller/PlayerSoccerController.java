package com.codegym.ss4again.controller;

import com.codegym.ss4again.model.PlayerSoccer;
import com.codegym.ss4again.service.IPlayerSoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/soccer")
public class PlayerSoccerController {
    @Autowired
    private IPlayerSoccerService playerSoccerService;
    @ModelAttribute("list")
    public List<PlayerSoccer> getAll(){
        return playerSoccerService.getAll();
    }

    @GetMapping("/list")
    public String getAll(Model model,@ModelAttribute("list") List<PlayerSoccer> list) {
        model.addAttribute("list", list);
        return "/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable int id) {
        PlayerSoccer playerSoccer = playerSoccerService.findById(id);
        model.addAttribute("playerSoccer", playerSoccer);
        return "/detail";
    }
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable int id) {
        PlayerSoccer playerSoccer = playerSoccerService.findById(id);
        model.addAttribute("playerSoccer", playerSoccer);
        return "/update";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam int deleteId, RedirectAttributes redirectAttributes){
        PlayerSoccer playerSoccer=playerSoccerService.findById(deleteId);
        if (playerSoccer==null){
        redirectAttributes.addFlashAttribute("meg","không tìm thấy");
        return "redirect:/soccer/list";
        }
        playerSoccerService.remove(playerSoccer);
        return "redirect:/soccer/list";
    }

}
