package com.example.stockdisplay.service;

import java.time.Instant;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.stockdisplay.model.StockData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StockService {

//    private static final String API_URL = "https://query1.finance.yahoo.com/v8/finance/chart/%5ENSEI?interval=5m&range=1d";
	private static final String API_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=NSEI&interval=5min&apikey=52ZH3HSJ0LI4HVAL.";
	private static final long CACHE_DURATION = 1; // Cache data for 1 minute
    private StockData cachedData = null;
    private long lastFetchTime = 0;

    public StockData getStockData() {
        try {
            long currentTime = Instant.now().getEpochSecond();

            if (cachedData != null && (currentTime - lastFetchTime) < (CACHE_DURATION * 60)) {
                return cachedData;
            }

            RestTemplate restTemplate = new RestTemplate();
            String jsonData = restTemplate.getForObject(API_URL, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonData);
            JsonNode result = root.path("chart").path("result").get(0);

            StockData data = mapper.treeToValue(result, StockData.class);

            // ✅ Cache the response to avoid frequent API calls
            cachedData = data;
            lastFetchTime = currentTime;

            return data;
        } catch (Exception e) {
            System.err.println("⚠️ Error fetching stock data: " + e.getMessage());
            e.printStackTrace();
            return cachedData != null ? cachedData : new StockData(); // Return cached or empty data
        }
    }
}
