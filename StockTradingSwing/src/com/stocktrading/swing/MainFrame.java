package com.stocktrading.swing;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    TradingPlatform market = new TradingPlatform();
    User user = new User("Rakshada", 50000);

    JComboBox<Stock> stockDropdown;
    JTextField quantityField;
    JTextArea outputArea;
    JLabel balanceLabel;

    public MainFrame() {

        setTitle("Stock Trading Platform");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 🔹 Top Panel
        JPanel topPanel = new JPanel();
        balanceLabel = new JLabel("Balance: ₹" + user.balance);
        topPanel.add(balanceLabel);
        add(topPanel, BorderLayout.NORTH);

        // 🔹 Center Panel
        JPanel centerPanel = new JPanel(new GridLayout(5, 1));

        stockDropdown = new JComboBox<>(market.getStocks().toArray(new Stock[0]));
        quantityField = new JTextField();

        centerPanel.add(new JLabel("Select Stock:"));
        centerPanel.add(stockDropdown);
        centerPanel.add(new JLabel("Quantity:"));
        centerPanel.add(quantityField);

        add(centerPanel, BorderLayout.CENTER);

        // 🔹 Buttons
        JPanel buttonPanel = new JPanel();

        JButton buyBtn = new JButton("Buy");
        JButton sellBtn = new JButton("Sell");
        JButton portfolioBtn = new JButton("View Portfolio");

        buttonPanel.add(buyBtn);
        buttonPanel.add(sellBtn);
        buttonPanel.add(portfolioBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        // 🔹 Output Area
        outputArea = new JTextArea();
        add(new JScrollPane(outputArea), BorderLayout.EAST);

        // 🔹 Button Actions
        buyBtn.addActionListener(e -> buyStock());
        sellBtn.addActionListener(e -> sellStock());
        portfolioBtn.addActionListener(e -> showPortfolio());

        setVisible(true);
    }

    void buyStock() {
        Stock stock = (Stock) stockDropdown.getSelectedItem();
        int qty = Integer.parseInt(quantityField.getText());

        if (user.buy(stock, qty)) {
            outputArea.setText("Stock Purchased Successfully!");
        } else {
            outputArea.setText("Insufficient Balance!");
        }
        updateBalance();
    }

    void sellStock() {
        Stock stock = (Stock) stockDropdown.getSelectedItem();
        int qty = Integer.parseInt(quantityField.getText());
        user.sell(stock, qty);
        outputArea.setText("Stock Sold Successfully!");
        updateBalance();
    }

    void showPortfolio() {
        outputArea.setText(
                "Portfolio:\n" +
                user.portfolio.getDetails() +
                "\nTotal Value: ₹" + user.portfolio.getTotalValue()
        );
    }

    void updateBalance() {
        balanceLabel.setText("Balance: ₹" + user.balance);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
