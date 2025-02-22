package com.example.stockdisplay.controller;

import com.example.stockdisplay.model.StockData;
import com.example.stockdisplay.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/")
    public String showStockData(Model model) {
        StockData stockData = stockService.getStockData();
        model.addAttribute("stockData", stockData != null ? stockData : new StockData());
        return "index";
    }
}
