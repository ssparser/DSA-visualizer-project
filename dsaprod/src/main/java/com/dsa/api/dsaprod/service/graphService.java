package com.dsa.api.dsaprod.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dsa.api.dsaprod.model.Cell;
import com.dsa.api.dsaprod.model.Grid;

@Service
public class graphService {
    private int row = 0;
    private int col = 0;
    private Cell start = new Cell(); 
    private Cell dest = new Cell();
    private Grid grid = new Grid();

    public Grid createGraph(int r, int c) {
        this.row = r;
        this.col = c;
        grid.init(r, c);
        return grid;
    }

    public void initGraph(int r, int c) {
        if ((r >= 0) && (r < row) && (c >= 0) && (c < col)) {
            grid.getGrid().get(r).get(c).setVal('S');
        }
    }

    public void Dest(int r, int c) {
        if ((r >= 0) && (r < row) && (c >= 0) && (c < col) &&  grid.getGrid().get(r).get(c).getVal() != 'S') {
            grid.getGrid().get(r).get(c).setVal('D');
        }
    }

    public Grid getGrid() {
        return grid;
    }
}