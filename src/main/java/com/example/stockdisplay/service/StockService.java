package com.example.stockdisplay.service;

import com.example.stockdisplay.model.StockData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    
    public StockData getStockData() {
        try {
            String jsonData = "{ \"chart\": { \"result\": [ { \"meta\": { \"currency\": \"INR\", \"symbol\": \"^NSEI\", \"regularMarketPrice\": 22819.9, \"previousClose\": 22913.15, \"regularMarketDayHigh\": 22921, \"regularMarketDayLow\": 22733.3 }, \"timestamp\": [1740109500, 1740109800, 1740110100], \"indicators\": { \"quote\": [ { \"low\": [22855.80078125, 22899, 22882.30078125], \"high\": [22909.849609375, 22920.5, 22907.400390625], \"close\": [22906.599609375, 22907.650390625, 22896.94921875], \"open\": [22855.80078125, 22906.69921875, 22906.650390625] } ] } } ], \"error\": null } }";
            
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonData);
            JsonNode result = root.path("chart").path("result").get(0);
            
            StockData data = mapper.treeToValue(result, StockData.class);
            System.out.println("Stock Data: " + data); // Add logging
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}