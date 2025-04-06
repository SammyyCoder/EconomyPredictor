package economypredictor.production;

import economypredictor.finance.FinancialEntity;

public class Product implements Manufacturable, FinancialEntity {
    private String name;
    private double rawCost;
    private int productionDays;
    private double sellingPrice;
    private int quantity;
    private double totalCost;
    
    private static final int DAILY_PRODUCTION = 1000;
    
    public Product(String name, double rawCost, int productionDays, double sellingPrice) {
        this.name = name;
        this.rawCost = rawCost;
        this.productionDays = productionDays;
        this.sellingPrice = sellingPrice;
        this.quantity = productionDays * DAILY_PRODUCTION;
    }
    
    public void calculateProductionCost() {
        this.totalCost = rawCost * quantity;
    }
    
    public double sell(int quantity) {
        if (quantity > this.quantity) {
            throw new IllegalArgumentException("Not enough stock available");
        }
        this.quantity -= quantity;
        return quantity * sellingPrice;
    }
    
    // Implement Manufacturable interface
    public double getProductionCost() {
        return totalCost;
    }
    
    public String getProductDetails() {
        return String.format("Product: %s, Quantity: %d, Cost: $%.2f", name, quantity, totalCost);
    }
    
    // Implement FinancialEntity interface
    public double calculateCost() {
        return totalCost;
    }
    
    public double calculateRevenue() {
        return quantity * sellingPrice;
    }
    
    // Getters
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getTotalCost() { return totalCost; }
    public double getSellingPrice() { return sellingPrice; }
    
    @Override
    public String toString() {
        return String.format("Product: %s\nQuantity: %d\nRaw Cost: $%.2f\nSelling Price: $%.2f\nTotal Cost: $%.2f",
                           name, quantity, rawCost, sellingPrice, totalCost);
    }
}