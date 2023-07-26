package com.codegym.demo.service.blogService;

import com.codegym.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();

    void save(Blog blog);

    Blog findById(int id);

    Page<Blog> getAll(Pageable pageable, String searchName);

    void delete(Blog blog);
}
