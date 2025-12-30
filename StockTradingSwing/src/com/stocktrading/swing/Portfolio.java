package com.stocktrading.swing;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    Map<Stock, Integer> holdings = new HashMap<>();

    public void buyStock(Stock stock, int qty) {
        holdings.put(stock, holdings.getOrDefault(stock, 0) + qty);
    }

    public void sellStock(Stock stock, int qty) {
        int current = holdings.get(stock);
        if (current >= qty) {
            holdings.put(stock, current - qty);
        }
    }

    public double getTotalValue() {
        double total = 0;
        for (Stock s : holdings.keySet()) {
            total += s.price * holdings.get(s);
        }
        return total;
    }

    public String getDetails() {
        StringBuilder sb = new StringBuilder();
        for (Stock s : holdings.keySet()) {
            sb.append(s.symbol)
              .append(" - Qty: ")
              .append(holdings.get(s))
              .append("\n");
        }
        return sb.toString();
    }
}
