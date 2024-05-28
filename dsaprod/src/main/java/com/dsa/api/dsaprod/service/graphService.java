package com.dsa.api.dsaprod.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class graphService 
{
    private static List<List<Character>> grid = new ArrayList<>();
    private static int row = 0;
    private static int col = 0;

    public static List<List<Character>> createGraph(int r, int c) {
        grid.clear(); 
        for (int i = 0; i < r; i++) {
            List<Character> adjacencyList = new ArrayList<>(c);
            for (int j = 0; j < c; j++) {
                adjacencyList.add('0');
            }
            grid.add(adjacencyList);
        }
        row = r;
        col = c;
        return grid;
    }

    public void initGraph(int r, int c) {
        if ((r >= 0) && (r < row) && (c >= 0) && (c < col)) {
            List<Character> adjacencyList = grid.get(r);
            adjacencyList.set(c, 'S');
        }
    }

    public void Dest(int r, int c) {
        if ((r >= 0) && (r < row) && (c >= 0) && (c < col) && grid.get(r).get(c) != 'S') {
            List<Character> adjacencyList = grid.get(r);
            adjacencyList.set(c, 'D');
        }
    }

    public List<List<Character>> getGrid() {
        return grid;
    }
}