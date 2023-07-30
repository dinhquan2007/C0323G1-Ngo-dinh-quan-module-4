package com.codegym.history_library.service;

import com.codegym.history_library.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(int id);
}
