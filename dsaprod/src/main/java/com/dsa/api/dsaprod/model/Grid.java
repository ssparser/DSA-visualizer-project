package com.dsa.api.dsaprod.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Grid {
    private ArrayList<List<Cell>> grid = new ArrayList<>();
    
    public void init(int r, int c) {
        for (int i = 0; i < r; i++){
            List<Cell> row = new ArrayList<>();
            for(int j = 0; j < c; j++){
                Cell cell = new Cell(i,j,'0');
                row.add(cell);
            }
            this.grid.add(row);
        }
    }
}
