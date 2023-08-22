package com.codegym.ss6_player_soccer.controller;

import com.codegym.ss6_player_soccer.model.PlayerSoccer;
import com.codegym.ss6_player_soccer.model.Team;
import com.codegym.ss6_player_soccer.service.IPlayerSoccerService;
import com.codegym.ss6_player_soccer.service.ITeamService;
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

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/soccer")
public class PlayerSoccerController {
    @Autowired
    private IPlayerSoccerService playerSoccerService;
    @Autowired
    private ITeamService teamService;
    @ModelAttribute("team")
    public List<Team> showTeams(){
        return teamService.getAll();
    }
    @GetMapping("/list")
    public String getAll(@RequestParam(defaultValue = "0") int page,
                         @RequestParam(defaultValue = "") String searchName,
                         @RequestParam(defaultValue = "3") int size,
                         @RequestParam(defaultValue = "1945-01-01",required = false) Date dateStart,
                         @RequestParam(required = false) Date dateEnd,
                         Model model) {
        if (dateEnd==null){
            dateEnd=Date.valueOf(LocalDate.now());
        }
        Pageable pageable= PageRequest.of(page,size,Sort.by("player_name").ascending().and(Sort.by("player_birth").ascending()));
        Page<PlayerSoccer> soccerPage= playerSoccerService.getAll(pageable,searchName,dateStart,dateEnd);
        model.addAttribute("searchName",searchName);
        model.addAttribute("size",size);
        model.addAttribute("page",page);
        model.addAttribute("soccerPage",soccerPage);
        model.addAttribute("dateStart",dateStart);
        model.addAttribute("dateEnd",dateEnd);
        return "/list";
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView =new ModelAndView("/create");
        modelAndView.addObject("playerSoccer", new PlayerSoccer());
        return modelAndView;
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
    public String update(@ModelAttribute PlayerSoccer playerSoccer, @RequestParam int id, RedirectAttributes redirectAttributes) {
        playerSoccerService.save(playerSoccer);
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
