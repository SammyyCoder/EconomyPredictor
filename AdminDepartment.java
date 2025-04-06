package economypredictor.administration;

import economypredictor.finance.SalaryCalculator;
import java.util.Scanner;

public class AdminDepartment implements Department {
    private double totalSalary;
    private int employeeCount;
    
    @Override
    public String getDepartmentName() {
        return "Administration Department";
    }
    
    @Override
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean back = false;
        
        while (!back) {
            System.out.println("\n--- " + getDepartmentName() + " ---");
            System.out.println("1. Add Employees");
            System.out.println("2. Calculate Salaries");
            System.out.println("3. View Department Summary");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter number of employees to add: ");
                    employeeCount = scanner.nextInt();
                    System.out.println(employeeCount + " employees added to Administration.");
                    break;
                case 2:
                    if (employeeCount > 0) {
                        totalSalary = SalaryCalculator.calculateAdminSalary(employeeCount);
                        System.out.println("Total salary calculated: $" + totalSalary);
                    } else {
                        System.out.println("No employees added yet!");
                    }
                    break;
                case 3:
                    System.out.println("\n" + getDepartmentName() + " Summary:");
                    System.out.println("Number of Employees: " + employeeCount);
                    System.out.println("Total Salary: $" + totalSalary);
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    @Override
    public double getTotalSalary() {
        return totalSalary;
    }
}