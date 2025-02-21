package com.example.stockdisplay.controller;

import com.example.stockdisplay.model.StockData;
import com.example.stockdisplay.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class StockController {
    
    @Autowired
    private StockService stockService;
    
    @GetMapping("/")
    public StockData getStockData(Model model) {
        return stockService.getStockData();
        
//        return "index";
    }
}