package com.dsa.api.dsaprod.service;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

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
    private final int[][] directions = {
            { 0, 1 }, // Right
            { 0, -1 }, // Left
            { 1, 0 }, // Down
            { -1, 0 } // Up
    };

    private boolean isValid(int r, int c) {
        return (r >= 0) && (r < row) && (c >= 0) && (c < col);
    }

    public Grid createGraph(int r, int c) {
        this.row = r;
        this.col = c;
        grid.init(r, c);
        return grid;
    }

    public void initGraph(int r, int c) {
        if (isValid(r, c)) {
            grid.getGrid().get(r).get(c).setVal('S');
        }
    }

    public void Dest(int r, int c) {
        if (isValid(r, c) && grid.getGrid().get(r).get(c).getVal() != 'S') {
            grid.getGrid().get(r).get(c).setVal('D');
        }
    }

    public Grid getGrid() {
        return grid;
    }

    public Set<Cell> bfs() {
        Queue<Cell> q = new LinkedList<>();
        q.add(start);
        Set<Cell> visited = new LinkedHashSet<>();
        visited.add(start);
        while (!q.isEmpty()) {
            Cell temp = q.poll();

            for (int i = 0; i < directions.length; i++) {
                int x = temp.getX() + directions[i][0];
                int y = temp.getY() + directions[i][1];

                if (isValid(x, y)) {
                    Cell cell = this.grid.getGrid().get(x).get(y);
                    if (!visited.contains(cell)) {
                        q.add(cell);
                        visited.add(cell);
                        if (cell.getVal() != 'S' && cell.getVal() != 'D') {
                            cell.setVal('1');
                        }
                    }
                }

            }
        }
        return visited;

    }

    public Set<Cell> dfs() {
        Stack<Cell> stack = new Stack<>();
        stack.push(start);
        Set<Cell> visited = new LinkedHashSet<>();
        visited.add(start);
        while (!stack.isEmpty()) {
            Cell temp = stack.pop();

            for (int i = 0; i < directions.length; i++) {
                int x = temp.getX() + directions[i][0];
                int y = temp.getY() + directions[i][1];

                if (isValid(x, y)) {
                    Cell cell = this.grid.getGrid().get(x).get(y);
                    if (!visited.contains(cell)) {
                        stack.push(cell);
                        visited.add(cell);
                        if (cell.getVal() != 'S' && cell.getVal() != 'D') {
                            cell.setVal('1');
                        }
                    }
                }

            }
        }
        return visited;
    }
}