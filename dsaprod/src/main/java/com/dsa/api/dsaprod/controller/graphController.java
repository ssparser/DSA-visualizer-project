package com.dsa.api.dsaprod.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsa.api.dsaprod.dto.gridDTO;
import com.dsa.api.dsaprod.model.Cell;
import com.dsa.api.dsaprod.model.Grid;
import com.dsa.api.dsaprod.service.graphService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/graph")
public class graphController {

    @Autowired
    private graphService graphService;

    @GetMapping("/mg")
    public String getMethodName() {
        return "mg";
    }

    @PostMapping("/createGrid")
    public ResponseEntity<Grid> createGrid(@RequestBody gridDTO gridRequest) {
        try {
            int x = gridRequest.getX();
            int y = gridRequest.getY();
            Grid grid = graphService.createGraph(x, y);
            return ResponseEntity.ok(grid);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/init")
    public void startInit(@RequestBody gridDTO gridRequest) {

        int x = gridRequest.getX();
        int y = gridRequest.getY();
        graphService.initGraph(x, y);

    }

    @PostMapping("/dest")
    public void dest(@RequestBody gridDTO gridRequest) {

        int x = gridRequest.getX();
        int y = gridRequest.getY();
        graphService.Dest(x, y);

    }

    @GetMapping("/grid")
    public Grid getGrid() {
        return graphService.getGrid();
    }

    @GetMapping("/bfs")
    public Set<Cell> bfsAlgo() {
        return graphService.bfs();
    }
    
    // mg
}
