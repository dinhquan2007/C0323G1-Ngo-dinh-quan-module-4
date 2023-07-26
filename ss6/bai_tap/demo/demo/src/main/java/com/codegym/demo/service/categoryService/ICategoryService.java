package com.codegym.demo.service.categoryService;

import com.codegym.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryService {
    List<Category> getAll();
}
