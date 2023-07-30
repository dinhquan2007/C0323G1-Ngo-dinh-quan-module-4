package com.codegym.history_library.controller;

import com.codegym.history_library.model.Book;
import com.codegym.history_library.model.Card;
import com.codegym.history_library.service.IBookService;
import com.codegym.history_library.service.IBorrowService;
import com.codegym.history_library.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowService borrowService;
    @Autowired
    private ICardService cardService;

    @GetMapping("/list")
    public ModelAndView showList(){
    ModelAndView modelAndView=new ModelAndView("list");
        return modelAndView;
    }
    @GetMapping("/detail")
    public ModelAndView showDetail(@RequestParam int id){
        ModelAndView modelAndView=new ModelAndView("detail");
        Book book=bookService.findById(id);
        modelAndView.addObject("book",book);
        return modelAndView;
    }
    @PostMapping("/getCode")
    public ModelAndView borrow(@RequestParam String code,
                         @RequestParam int bookId){
        ModelAndView modelAndView =new ModelAndView("detail");
        Card card= cardService.findByCode(code);
        Book book=bookService.findById(bookId);
        if (card==null){
            modelAndView.addObject("code",code);
            modelAndView.addObject("book",book);
            modelAndView.addObject("message","don't exit code" );
        return modelAndView;
        }
        return modelAndView;
    }

}
