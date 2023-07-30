package com.codegym.history_library.service;

import com.codegym.history_library.model.Card;

public interface ICardService {
    String getCode();
    Card findByCode(String code);
}
