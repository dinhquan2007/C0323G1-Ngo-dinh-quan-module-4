package com.codegym.ss6_player_soccer.controller;

import com.codegym.ss6_player_soccer.model.PlayerSoccer;
import com.codegym.ss6_player_soccer.service.IPlayerSoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/list")
    public String getAll(@RequestParam(defaultValue = "0") int page,
                         @RequestParam(defaultValue = "") String searchName,
                         @RequestParam(defaultValue = "5") int size,
                         Model model) {
        Pageable pageable= PageRequest.of(page,size);
        Page<PlayerSoccer> soccerPage= playerSoccerService.getAll(pageable,searchName);
        model.addAttribute("searchName",searchName);
        model.addAttribute("size",size);
        model.addAttribute("page",page);
        model.addAttribute("soccerPage",soccerPage);
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

        return "redirect:/soccer/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int deleteId, RedirectAttributes redirectAttributes) {
        PlayerSoccer playerSoccer = playerSoccerService.findById(deleteId);
        if (playerSoccer == null) {
            redirectAttributes.addFlashAttribute("meg", "không tìm thấy");
            return "redirect:/soccer/list";
        }
        playerSoccerService.remove(deleteId);
        redirectAttributes.addFlashAttribute("meg", "xóa thành công");
        return "redirect:/soccer/list";
    }

}
