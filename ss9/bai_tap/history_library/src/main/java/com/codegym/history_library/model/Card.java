package com.codegym.history_library.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookName;
    private String customer;
    private String code;
    @OneToMany
    private Set<Borrow> borrowSet;
}
