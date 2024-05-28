package com.dsa.api.dsaprod.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dsa.api.dsaprod.model.Cell;
import com.dsa.api.dsaprod.model.Grid;

@Service
public class graphService {
    // private static List<List<Character>> grid = new ArrayList<>();
    private static int row = 0;
    private static int col = 0;
    private Cell start = new Cell(); 
    private Cell dest = new Cell();
    private Grid grid = new Grid();

    public Grid createGraph(int r, int c) {
        grid.init(r, c);
        return grid;
    }

    // public void initGraph(int r, int c) {
    //     if ((r >= 0) && (r < row) && (c >= 0) && (c < col)) {
    //         List<Character> adjacencyList = grid.get(r);
    //         adjacencyList.set(c, 'S');
    //         start.setX(r);
    //         start.setY(c);
    //         start.setVal('S');
    //     }
    // }

    // public void Dest(int r, int c) {
    //     if ((r >= 0) && (r < row) && (c >= 0) && (c < col) && grid.get(r).get(c) != 'S') {
    //         List<Character> adjacencyList = grid.get(r);
    //         adjacencyList.set(c, 'D');
    //         dest.setX(r);
    //         dest.setY(c);
    //     }
    // }

    // public List<List<Character>> getGrid() {
    //     return grid;
    // }
}