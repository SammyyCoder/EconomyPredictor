package economypredictor.finance;

public class FinancialReport {
    public void generateReport(double adminSalary, double customerServiceSalary,
                             double productionSalary, double salesSalary,
                             double productionCost, double totalSales) {
        System.out.println("\n=== Financial Report ===");
        System.out.println("Administration Salary: $" + adminSalary);
        System.out.println("Customer Service Salary: $" + customerServiceSalary);
        System.out.println("Production Salary: $" + productionSalary);
        System.out.println("Sales Salary: $" + salesSalary);
        System.out.println("Production Costs: $" + productionCost);
        System.out.println("Total Sales: $" + totalSales);
        
        double totalExpenses = adminSalary + customerServiceSalary + 
                             productionSalary + salesSalary + productionCost;
        double profitLoss = totalSales - totalExpenses;
        
        System.out.println("\nTotal Expenses: $" + totalExpenses);
        System.out.println("Net " + (profitLoss >= 0 ? "Profit" : "Loss") + 
                          ": $" + Math.abs(profitLoss));
        
        // Additional financial metrics
        System.out.println("\n=== Financial Metrics ===");
        System.out.printf("Profit Margin: %.2f%%\n", (profitLoss / totalSales) * 100);
        System.out.printf("Expense to Revenue Ratio: %.2f\n", (totalExpenses / totalSales));
    }
}