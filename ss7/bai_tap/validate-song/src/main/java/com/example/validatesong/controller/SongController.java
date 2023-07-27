package com.example.validatesong.controller;

import com.example.validatesong.dto.SongDto;
import com.example.validatesong.model.Song;
import com.example.validatesong.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/list")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/list");
        List<Song> songs = songService.findAll();
        modelAndView.addObject("songList", songs);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songDto", new SongDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute SongDto songDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("songDto", songDto);
            return "/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        return "redirect:/song/list";
    }
    @GetMapping("update/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/update");
        Song song= songService.findById(id);
        SongDto songDto=new SongDto();
        BeanUtils.copyProperties(song,songDto);
        modelAndView.addObject("songDto",songDto);
        return modelAndView;
    }
    @PostMapping("update")
    public String update(@Valid @ModelAttribute SongDto songDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("songDto", songDto);
            return "/update";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);

        return "redirect:/song/list";
    }
}
