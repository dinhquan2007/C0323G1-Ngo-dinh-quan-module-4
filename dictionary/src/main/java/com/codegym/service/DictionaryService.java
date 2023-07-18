package com.codegym.service;

import com.codegym.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService{
    @Autowired
    private IDictionaryRepository repository;

    @Override
    public String search(String s) {
        return repository.search(s);
    }
}
