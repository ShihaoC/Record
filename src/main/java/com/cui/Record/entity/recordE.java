package com.cui.Record.entity;

import org.springframework.stereotype.Component;

@Component
public class recordE {
    private String date;
    private String name;
    private int work;

    public recordE() {
    }

    public recordE(String date, String name, int work) {
        this.date = date;
        this.name = name;
        this.work = work;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWork() {
        return work;
    }

    public void setWork(int work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", work='" + work + '\'' +
                '}';
    }
}
