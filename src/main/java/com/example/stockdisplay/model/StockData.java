package com.example.stockdisplay.model;

import java.util.List;

public class StockData {
    private Meta meta;
    private List<Long> timestamp;
    private Indicators indicators;

    public static class Meta {
        private String currency;
        private String symbol;
        private double regularMarketPrice;
        private double previousClose;
        private double regularMarketDayHigh;
        private double regularMarketDayLow;

        // Getters and Setters
        public String getCurrency() { return currency; }
        public void setCurrency(String currency) { this.currency = currency; }
        public String getSymbol() { return symbol; }
        public void setSymbol(String symbol) { this.symbol = symbol; }
        public double getRegularMarketPrice() { return regularMarketPrice; }
        public void setRegularMarketPrice(double regularMarketPrice) { this.regularMarketPrice = regularMarketPrice; }
        public double getPreviousClose() { return previousClose; }
        public void setPreviousClose(double previousClose) { this.previousClose = previousClose; }
        public double getRegularMarketDayHigh() { return regularMarketDayHigh; }
        public void setRegularMarketDayHigh(double regularMarketDayHigh) { this.regularMarketDayHigh = regularMarketDayHigh; }
        public double getRegularMarketDayLow() { return regularMarketDayLow; }
        public void setRegularMarketDayLow(double regularMarketDayLow) { this.regularMarketDayLow = regularMarketDayLow; }
    }

    public static class Indicators {
        private List<Quote> quote;

        public List<Quote> getQuote() { return quote; }
        public void setQuote(List<Quote> quote) { this.quote = quote; }
    }

    public static class Quote {
        private List<Double> low;
        private List<Double> high;
        private List<Double> close;
        private List<Double> open;

        // Getters and Setters
        public List<Double> getLow() { return low; }
        public void setLow(List<Double> low) { this.low = low; }
        public List<Double> getHigh() { return high; }
        public void setHigh(List<Double> high) { this.high = high; }
        public List<Double> getClose() { return close; }
        public void setClose(List<Double> close) { this.close = close; }
        public List<Double> getOpen() { return open; }
        public void setOpen(List<Double> open) { this.open = open; }
    }

    // Getters and Setters
    public Meta getMeta() { return meta; }
    public void setMeta(Meta meta) { this.meta = meta; }
    public List<Long> getTimestamp() { return timestamp; }
    public void setTimestamp(List<Long> timestamp) { this.timestamp = timestamp; }
    public Indicators getIndicators() { return indicators; }
    public void setIndicators(Indicators indicators) { this.indicators = indicators; }
}
