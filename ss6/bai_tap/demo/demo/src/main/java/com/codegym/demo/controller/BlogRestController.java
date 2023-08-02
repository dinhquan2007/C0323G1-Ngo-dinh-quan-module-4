package com.codegym.demo.controller;

import com.codegym.demo.dto.BlogDto;
import com.codegym.demo.model.Blog;
import com.codegym.demo.service.blogService.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/blog")
public class BlogRestController{
    @Autowired
    private IBlogService blogService;

//    @GetMapping("/list")
//    public ResponseEntity<List<Blog>> getList() {
//        List<Blog> blogList = blogService.getAll();
//        if (blogList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }
    @GetMapping("/list")
    public ResponseEntity<Page<Blog>> getListByName(@RequestParam String searchName,@RequestParam Integer page
    ) {
        if (searchName==null){
            searchName="";
        }
        Pageable pageable= PageRequest.of(page,3);
        Page<Blog> blogPage=blogService.getByName(pageable,searchName);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
    @GetMapping("/detail")
    public ResponseEntity<Blog> getDetailBlog(@RequestBody int id) {
        Blog blog = blogService.findById(id);
        if (blog==null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

}
