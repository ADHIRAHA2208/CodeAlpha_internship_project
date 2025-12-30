package com.stocktrading.swing;

import java.util.ArrayList;
import java.util.List;

public class TradingPlatform {
    List<Stock> stocks = new ArrayList<>();

    public TradingPlatform() {
        stocks.add(new Stock("TCS", "Tata Consultancy", 3500));
        stocks.add(new Stock("INFY", "Infosys", 1500));
        stocks.add(new Stock("HDFC", "HDFC Bank", 1600));
    }

    public List<Stock> getStocks() {
        return stocks;
    }
}
