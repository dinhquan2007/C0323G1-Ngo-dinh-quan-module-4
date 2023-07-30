package com.codegym.history_library.service;

import com.codegym.history_library.model.Card;
import com.codegym.history_library.repository.ICardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CardService implements ICardService {
    @Autowired
    private ICardRepository cardRepository;

    @Override
    public String getCode() {
        return new Random().ints(65, 90).limit(5).collect(
                StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    @Override
    public Card findByCode(String code) {
        return cardRepository.findByCode(code);
    }
}
