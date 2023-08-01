package com.codegym.demo.service.categoryService;

import com.codegym.demo.model.Blog;
import com.codegym.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ICategoryService {
    List<Category> getAll();
    Category getBlogs(int id);
}
