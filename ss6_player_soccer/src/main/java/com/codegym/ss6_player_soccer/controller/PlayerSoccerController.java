package com.codegym.ss6_player_soccer.controller;

import com.codegym.ss6_player_soccer.dto.LikeDto;
import com.codegym.ss6_player_soccer.dto.PlayerSoccerDto;
import com.codegym.ss6_player_soccer.model.PlayerSoccer;
import com.codegym.ss6_player_soccer.model.Position;
import com.codegym.ss6_player_soccer.model.Team;
import com.codegym.ss6_player_soccer.service.play_soccer.IPlayerSoccerService;
import com.codegym.ss6_player_soccer.service.position.IPositionService;
import com.codegym.ss6_player_soccer.service.team.ITeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/soccer")
@SessionAttributes("like")
public class PlayerSoccerController {
    @Autowired
    private IPlayerSoccerService playerSoccerService;
    @Autowired
    private ITeamService teamService;
    @Autowired
    private IPositionService positionService;

    @ModelAttribute("like")
    public LikeDto showListLike() {
        return new LikeDto();
    }

    @ModelAttribute("teams")
    public List<Team> showTeams() {
        return teamService.getAll();
    }

    @ModelAttribute("positions")
    public List<Position> showPosition() {
        return positionService.getAll();
    }

    @GetMapping("/list")
    public String getAll(@RequestParam(defaultValue = "0") int page,
                         @SessionAttribute(value = "like", required = false) LikeDto likeDto,
                         @RequestParam(defaultValue = "") String searchName,
                         @RequestParam(defaultValue = "3") int size,
                         @RequestParam(defaultValue = "1945-01-01", required = false) Date dateStart,
                         @RequestParam(required = false) Date dateEnd,
                         Model model) {
        if (dateEnd==null){
            dateEnd = Date.valueOf(LocalDate.now());
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by("player_name").ascending().and(Sort.by("player_birth").ascending()));
        Page<PlayerSoccer> soccerPage = playerSoccerService.getAll(pageable, searchName, dateStart, dateEnd);
        model.addAttribute("searchName", searchName);
        model.addAttribute("size", size);
        model.addAttribute("page", page);
        model.addAttribute("soccerPage", soccerPage);
        model.addAttribute("dateStart", dateStart);
        model.addAttribute("dateEnd", dateEnd);
        if (likeDto != null) {
            model.addAttribute("like", likeDto);
        }
        return "/list";
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView =new ModelAndView("/create");
        modelAndView.addObject("playerSoccerDto", new PlayerSoccerDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute PlayerSoccerDto playerSoccerDto  ,
            BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        new PlayerSoccerDto().validate(playerSoccerDto,bindingResult);
        if (bindingResult.hasErrors()){
        return "create";
        }
        PlayerSoccer playerSoccer =new PlayerSoccer();
        BeanUtils.copyProperties(playerSoccerDto,playerSoccer);
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
        PlayerSoccerDto playerSoccerDto=new PlayerSoccerDto();
        BeanUtils.copyProperties(playerSoccer,playerSoccerDto);
        model.addAttribute("playerSoccerDto", playerSoccerDto);
        return "/update";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute PlayerSoccerDto playerSoccerDto,BindingResult bindingResult, @RequestParam int id, RedirectAttributes redirectAttributes) {
       new PlayerSoccerDto().validate(playerSoccerDto,bindingResult);
       if (bindingResult.hasErrors()){
           return "update";
       }
       PlayerSoccer playerSoccer=playerSoccerService.findById(id);
        BeanUtils.copyProperties(playerSoccerDto,playerSoccer);
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

    @GetMapping("/ready")
    public String transitionStatusReady(@RequestParam int id, RedirectAttributes redirectAttributes) {
        PlayerSoccer playerSoccer = playerSoccerService.findById(id);
        playerSoccer.setStatus(true);
        playerSoccerService.save(playerSoccer);
        return "redirect:/soccer/list";
    }

    @GetMapping("/un-ready")
    public String transitionStatusReserve(@RequestParam int id, RedirectAttributes redirectAttributes) {
        PlayerSoccer playerSoccer = playerSoccerService.findById(id);
        playerSoccer.setStatus(false);
        playerSoccerService.save(playerSoccer);
        return "redirect:/soccer/list";
    }

    @GetMapping("/like/{id}")
    public String likePlayer(@PathVariable int id,
                             @SessionAttribute(value = "like") LikeDto likeDto, RedirectAttributes redirectAttributes) {
        PlayerSoccer playerSoccer = playerSoccerService.findById(id);
        if (playerSoccer != null) {
            PlayerSoccerDto playerSoccerDto = new PlayerSoccerDto();
            BeanUtils.copyProperties(playerSoccer, playerSoccerDto);
            likeDto.addPlayerLike(playerSoccerDto);
        }
        return "redirect:/like";
    }


}
