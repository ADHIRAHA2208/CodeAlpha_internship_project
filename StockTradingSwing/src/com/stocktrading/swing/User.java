package com.stocktrading.swing;

public class User {
    String name;
    double balance;
    Portfolio portfolio = new Portfolio();

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean buy(Stock stock, int qty) {
        double cost = stock.price * qty;
        if (balance >= cost) {
            balance -= cost;
            portfolio.buyStock(stock, qty);
            return true;
        }
        return false;
    }

    public void sell(Stock stock, int qty) {
        balance += stock.price * qty;
        portfolio.sellStock(stock, qty);
    }
}
