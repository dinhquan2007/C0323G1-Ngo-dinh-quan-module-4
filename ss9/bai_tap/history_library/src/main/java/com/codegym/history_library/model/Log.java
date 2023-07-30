package com.codegym.history_library.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message;
    @Column(name = "time_borrow")
    private Timestamp timeBorrow;
    private long count;

    public Log() {
    }

    public Log(int id, String message, Timestamp timeBorrow, long count) {
        this.id = id;
        this.message = message;
        this.timeBorrow = timeBorrow;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimeBorrow() {
        return timeBorrow;
    }

    public void setTimeBorrow(Timestamp timeBorrow) {
        this.timeBorrow = timeBorrow;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
