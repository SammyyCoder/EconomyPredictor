package economypredictor.production;

import economypredictor.administration.Department;
import economypredictor.finance.SalaryCalculator;
import java.util.Scanner;

public class ProductionDepartment implements Department {
    private double totalSalary;
    private int employeeCount;
    private double totalProductionCost;
    private Product[] products = new Product[2];
    private QualityControl qualityControl;
    
    public ProductionDepartment() {
        qualityControl = new QualityControl();
    }
    
    @Override
    public String getDepartmentName() {
        return "Production Department";
    }
    
    @Override
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean back = false;
        
        while (!back) {
            System.out.println("\n--- " + getDepartmentName() + " ---");
            System.out.println("1. Add Employees");
            System.out.println("2. Calculate Salaries");
            System.out.println("3. Add Products");
            System.out.println("4. Calculate Production Costs");
            System.out.println("5. Perform Quality Check");
            System.out.println("6. View Product Details");
            System.out.println("7. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter number of employees to add: ");
                    employeeCount = scanner.nextInt();
                    System.out.println(employeeCount + " employees added to Production.");
                    break;
                case 2:
                    if (employeeCount > 0) {
                        totalSalary = SalaryCalculator.calculateProductionSalary(employeeCount);
                        System.out.println("Total salary calculated: $" + totalSalary);
                    } else {
                        System.out.println("No employees added yet!");
                    }
                    break;
                case 3:
                    addProducts(scanner);
                    break;
                case 4:
                    calculateProductionCosts();
                    break;
                case 5:
                    if (products[0] != null) {
                        qualityControl.performQualityCheck(products);
                    } else {
                        System.out.println("Please add products first!");
                    }
                    break;
                case 6:
                    displayProductDetails();
                    break;
                case 7:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    private void addProducts(Scanner scanner) {
        System.out.println("\nAdding Products:");
        for (int i = 0; i < 2; i++) {
            System.out.print("Enter product " + (i+1) + " name: ");
            String name = scanner.next();
            System.out.print("Enter raw material cost: ");
            double rawCost = scanner.nextDouble();
            System.out.print("Enter production days: ");
            int days = scanner.nextInt();
            System.out.print("Enter selling price per unit: ");
            double price = scanner.nextDouble();
            
            products[i] = new Product(name, rawCost, days, price);
            System.out.println("Product " + name + " added successfully!\n");
        }
    }
    
    private void calculateProductionCosts() {
        if (products[0] == null) {
            System.out.println("Please add products first!");
            return;
        }
        
        totalProductionCost = 0;
        for (Product product : products) {
            if (product != null) {
                product.calculateProductionCost();
                totalProductionCost += product.getTotalCost();
                System.out.println(product);
            }
        }
        System.out.println("\nTotal Production Cost: $" + totalProductionCost);
    }
    
    private void displayProductDetails() {
        if (products[0] == null) {
            System.out.println("No products added yet!");
            return;
        }
        
        System.out.println("\n=== Product Details ===");
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getProductDetails());
                System.out.printf("Projected Profit: $%.2f\n", product.calculateCost());
                System.out.println();
            }
        }
    }
    
    @Override
    public double getTotalSalary() {
        return totalSalary;
    }
    
    public double getTotalProductionCost() {
        return totalProductionCost;
    }
    
    public Product[] getProducts() {
        return products;
    }
}