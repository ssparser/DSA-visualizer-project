package com.dsa.api.dsaprod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsa.api.dsaprod.dto.gridDTO;
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
    private graphService GraphService;

    @GetMapping("/mg")
    public String getMethodName() {
        return "mg";
    }

    @PostMapping("/createGrid")
    public ResponseEntity<List<List<Character>>> createGrid(@RequestBody gridDTO gridRequest) {
        try {
            int x = gridRequest.getX();
            int y = gridRequest.getY();
            List<List<Character>> grid = GraphService.createGraph(x, y);
            return ResponseEntity.ok(grid);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/init")
    public void postMethodName(@RequestBody gridDTO gridRequest) {

            int x = gridRequest.getX();
            int y = gridRequest.getY();
            GraphService.initGraph(x, y);
            
    }
    @GetMapping("/grid")
    public List<List<Character>> getGrid() {
        if (GraphService.getGrid() == null) {
            System.out.println("Grid is null");
        } else {
            System.out.println("Grid is not null, size: " + GraphService.getGrid().size());
        }
        return GraphService.getGrid();
    }    
    
    // mg
}
