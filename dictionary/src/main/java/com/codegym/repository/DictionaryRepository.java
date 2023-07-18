package com.codegym.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("dog", "chó");
        dictionary.put("cat", "mèo");
        dictionary.put("fish", "cá");
        dictionary.put("pig", "lợn");
        dictionary.put("mouse", "chuột");
        dictionary.put("horse", "ngựa");
        dictionary.put("tiger", "hổ");
    }
    public String search(String s){
        if (dictionary.containsKey(s)){
            return dictionary.get(s);
        }
        return null;
    }
}
