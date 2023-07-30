package com.codegym.history_library.repository;

import com.codegym.history_library.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICardRepository extends JpaRepository<Card,Integer> {
    Card findByCode(String code);
}
