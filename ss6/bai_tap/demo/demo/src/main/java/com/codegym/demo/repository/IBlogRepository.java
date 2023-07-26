package com.codegym.demo.repository;

import com.codegym.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface IBlogRepository extends JpaRepository<Blog,Integer>{

    Page<Blog> findAllByNameContaining(Pageable pageable, String searchName);
}
