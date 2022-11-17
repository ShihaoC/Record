package com.cui.Record.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bookkeeping {
    private String date;
    private String name;
    private double work;
    private int id;
}
