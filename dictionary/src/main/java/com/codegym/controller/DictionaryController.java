package com.codegym.controller;
import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;
    @PostMapping("/dictionary")
    public String search(@RequestParam("word") String word, Model model){
        String result=dictionaryService.search(word);
        if (result==null){
            model.addAttribute("result","từ "+result+ "không có trong từ điển");
        }else {
            model.addAttribute("result",word+" có nghĩa là "+result);
        }
        return "formSearch";
    }
     @GetMapping("/showForm")
    public String showForm(){
        return "formSearch";
    }

}
