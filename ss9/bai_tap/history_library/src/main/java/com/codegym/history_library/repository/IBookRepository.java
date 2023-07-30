package com.codegym.history_library.repository;

import com.codegym.history_library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Integer> {

}
