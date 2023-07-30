package com.codegym.history_library.repository;

import com.codegym.history_library.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepository extends JpaRepository<Borrow,Integer> {
}
