package com.dsa.api.dsaprod.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cell {
    private int x;
    private int y;
    private char val;

}
