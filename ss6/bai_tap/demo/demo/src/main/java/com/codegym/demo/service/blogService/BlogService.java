package com.codegym.demo.service.blogService;

import com.codegym.demo.model.Blog;
import com.codegym.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository repository;

    @Override
    public Page<Blog> getByName(Pageable page,String name) {
        return repository.findAllByNameContaining(page,name);
    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> getAll(Pageable pageable, String searchName) {
        return repository.findAllByNameContaining(pageable, searchName);
    }

    @Override
    public void delete(Blog blog) {
        repository.delete(blog);
    }
}
