package economypredictor.customer;

import economypredictor.administration.Department;
import economypredictor.finance.SalaryCalculator;
import java.util.Scanner;

public class CustomerService implements Department, FeedbackSystem {
    private double totalSalary;
    private int employeeCount;
    private int excellent = 0;
    private int good = 0;
    private int average = 0;
    private int satisfactory = 0;
    private int poor = 0;
    
    @Override
    public String getDepartmentName() {
        return "Customer Service Department";
    }
    
    @Override
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean back = false;
        
        while (!back) {
            System.out.println("\n--- " + getDepartmentName() + " ---");
            System.out.println("1. Add Employees");
            System.out.println("2. Calculate Salaries");
            System.out.println("3. Record Customer Feedback");
            System.out.println("4. View Feedback Summary");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter number of employees to add: ");
                    employeeCount = scanner.nextInt();
                    System.out.println(employeeCount + " employees added to Customer Service.");
                    break;
                case 2:
                    if (employeeCount > 0) {
                        totalSalary = SalaryCalculator.calculateCustomerServiceSalary(employeeCount);
                        System.out.println("Total salary calculated: $" + totalSalary);
                    } else {
                        System.out.println("No employees added yet!");
                    }
                    break;
                case 3:
                    System.out.print("Enter rating (1-5): ");
                    int rating = scanner.nextInt();
                    recordFeedback(rating);
                    break;
                case 4:
                    displayFeedbackSummary();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    @Override
    public void recordFeedback(int rating) {
        switch (rating) {
            case 1: excellent++; break;
            case 2: good++; break;
            case 3: average++; break;
            case 4: satisfactory++; break;
            case 5: poor++; break;
            default: System.out.println("Invalid rating!");
        }
        System.out.println("Thank you for your feedback!");
    }
    
    @Override
    public void displayFeedbackSummary() {
        int total = excellent + good + average + satisfactory + poor;
        if (total == 0) {
            System.out.println("No feedback recorded yet.");
            return;
        }
        
        System.out.println("\n=== Customer Feedback Summary ===");
        System.out.println("Excellent: " + excellent + " (" + (excellent*100/total) + "%)");
        System.out.println("Good: " + good + " (" + (good*100/total) + "%)");
        System.out.println("Average: " + average + " (" + (average*100/total) + "%)");
        System.out.println("Satisfactory: " + satisfactory + " (" + (satisfactory*100/total) + "%)");
        System.out.println("Poor: " + poor + " (" + (poor*100/total) + "%)");
        System.out.println("Total feedbacks: " + total);
    }
    
    @Override
    public double getTotalSalary() {
        return totalSalary;
    }
}