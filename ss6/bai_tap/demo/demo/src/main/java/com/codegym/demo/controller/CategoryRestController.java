package com.codegym.demo.controller;

import com.codegym.demo.model.Blog;
import com.codegym.demo.model.Category;
import com.codegym.demo.service.categoryService.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("api/category")
public class CategoryRestController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<List<Category>> getList(){
        List<Category> categoryList=categoryService.getAll();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(categoryList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
     @GetMapping("/{id}")
    public ResponseEntity<Set<Blog>> getBlogSet(@PathVariable int id){
         Category category=categoryService.getBlogs(id);
         Set<Blog> blogs=category.getBlogSet();
         if (blogs.isEmpty()){
            return new ResponseEntity<>(blogs, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

}
