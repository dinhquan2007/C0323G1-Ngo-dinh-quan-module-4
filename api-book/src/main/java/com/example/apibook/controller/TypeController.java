package com.example.apibook.controller;

import com.example.apibook.model.Type;
import com.example.apibook.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("type")
@CrossOrigin("*")
public class TypeController {
    @Autowired
    private ITypeService typeService;
    @GetMapping("")
    public List<Type> getAll(){
       return typeService.getAll();
    }
}
