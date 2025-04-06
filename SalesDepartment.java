package economypredictor.sales;

import economypredictor.production.Product;
import economypredictor.finance.SalaryCalculator;
import java.util.Scanner;

public class SalesDepartment {
    private double totalSalary;
    private int employeeCount;
    private double totalSales;
    private Product[] products;
    
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean back = false;
        
        while (!back) {
            System.out.println("\n--- Sales Department ---");
            System.out.println("1. Add Employees");
            System.out.println("2. Calculate Salaries");
            System.out.println("3. Record Sales");
            System.out.println("4. Generate Sales Report");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter number of employees to add: ");
                    employeeCount = scanner.nextInt();
                    System.out.println(employeeCount + " employees added to Sales.");
                    break;
                case 2:
                    if (employeeCount > 0) {
                        totalSalary = SalaryCalculator.calculateSalesSalary(employeeCount);
                        System.out.println("Total salary calculated: $" + totalSalary);
                    } else {
                        System.out.println("No employees added yet!");
                    }
                    break;
                case 3:
                    recordSales(scanner);
                    break;
                case 4:
                    generateSalesReport();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    public void setProducts(Product[] products) {
        this.products = products;
    }
    
    private void recordSales(Scanner scanner) {
        if (products == null || products[0] == null) {
            System.out.println("No products available for sale. Please add products in Production first.");
            return;
        }
        
        System.out.println("\nAvailable Products:");
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println((i+1) + ". " + products[i].getName() + 
                                 " (Available: " + products[i].getQuantity() + ")");
            }
        }
        
        System.out.print("Select product to sell (1-" + products.length + "): ");
        int productChoice = scanner.nextInt() - 1;
        
        if (productChoice < 0 || productChoice >= products.length || products[productChoice] == null) {
            System.out.println("Invalid product selection!");
            return;
        }
        
        System.out.print("Enter quantity to sell: ");
        int quantity = scanner.nextInt();
        
        if (quantity <= 0 || quantity > products[productChoice].getQuantity()) {
            System.out.println("Invalid quantity!");
            return;
        }
        
        double saleAmount = products[productChoice].sell(quantity);
        totalSales += saleAmount;
        System.out.println("Sold " + quantity + " units of " + products[productChoice].getName() + 
                           " for $" + saleAmount);
    }
    
    private void generateSalesReport() {
        System.out.println("\nSales Report:");
        System.out.println("Total Sales: $" + totalSales);
    }
    
    public double getTotalSalary() {
        return totalSalary;
    }
    
    public double getTotalSales() {
        return totalSales;
    }
}