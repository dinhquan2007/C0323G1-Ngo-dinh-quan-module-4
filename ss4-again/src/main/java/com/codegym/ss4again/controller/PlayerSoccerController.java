package com.codegym.ss4again.controller;

import com.codegym.ss4again.model.PlayerSoccer;
import com.codegym.ss4again.service.IPlayerSoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/soccer")
public class PlayerSoccerController {
    @Autowired
    private IPlayerSoccerService playerSoccerService;

    @ModelAttribute("list")
    public List<PlayerSoccer> getAll() {
        return playerSoccerService.getAll();
    }

    @GetMapping("/list")
    public String getAll(Model model, @ModelAttribute("list") List<PlayerSoccer> list) {
        model.addAttribute("list", list);
        return "/list";
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("/create", "playerSoccer", new PlayerSoccer());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute PlayerSoccer playerSoccer  ,RedirectAttributes redirectAttributes) {
        playerSoccerService.save(playerSoccer);
        redirectAttributes.addFlashAttribute("meg","thêm mới thành công");
        return "redirect:/soccer/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable int id) {
        PlayerSoccer playerSoccer = playerSoccerService.findById(id);
        model.addAttribute("playerSoccer", playerSoccer);
        return "/detail";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(Model model, @PathVariable int id) {
        PlayerSoccer playerSoccer = playerSoccerService.findById(id);
        model.addAttribute("playerSoccer", playerSoccer);
        return "/update";
    }

    @PostMapping("/update/{id}")
    public String update(PlayerSoccer playerSoccer, @RequestParam int id, RedirectAttributes redirectAttributes) {
        boolean success = playerSoccerService.update(playerSoccer, id);
        if (success) {
            redirectAttributes.addFlashAttribute("meg", "chỉnh sửa thành công");
        } else {
            redirectAttributes.addFlashAttribute("meg", "chỉnh sửa không thành công");
        }
        return "redirect:/soccer/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int deleteId, RedirectAttributes redirectAttributes) {
        PlayerSoccer playerSoccer = playerSoccerService.findById(deleteId);
        if (playerSoccer == null) {
            redirectAttributes.addFlashAttribute("meg", "không tìm thấy");
            return "redirect:/soccer/list";
        }
        playerSoccerService.remove(playerSoccer);
        redirectAttributes.addFlashAttribute("meg", "xóa thành công");
        return "redirect:/soccer/list";
    }

}
