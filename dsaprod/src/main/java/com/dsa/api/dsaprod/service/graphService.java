package com.dsa.api.dsaprod.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class graphService {

    public static List<List<Integer>> createGraph(int r, int c)
    {
        List<List<Integer>> grid = new ArrayList<>(r);

         for (int i = 0; i < r; i++) {
            List<Integer> adjacencyList = new ArrayList<>(c);
            for (int j = 0; j < c; j++) {
                adjacencyList.add(0);  // Fill each list with '0's
            }
            grid.add(adjacencyList);
        }

        return grid;
    }

}
