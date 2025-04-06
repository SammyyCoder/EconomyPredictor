package economypredictor.main;

import economypredictor.administration.*;
import economypredictor.customer.*;
import economypredictor.finance.*;
import economypredictor.production.*;
import economypredictor.sales.*;
import java.util.Scanner;

public class EconomyPredictorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize departments
        Department adminDept = new AdminDepartment();
        Department customerService = new CustomerService();
        Department productionDept = new ProductionDepartment();
        SalesDepartment salesDept =  new SalesDepartment();
        
        // Set products for sales department
        ((SalesDepartment)salesDept).setProducts(((ProductionDepartment)productionDept).getProducts());
        
        FinancialReport financialReport = new FinancialReport();
        
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\n========== Economy Predictor ==========");
            System.out.println("1. Administration Department");
            System.out.println("2. Customer Service Department");
            System.out.println("3. Production Department");
            System.out.println("4. Sales Department");
            System.out.println("5. Financial Reports");
            System.out.println("6. Employee Management");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        adminDept.showMenu();
                        break;
                    case 2:
                        customerService.showMenu();
                        break;
                    case 3:
                        productionDept.showMenu();
                        break;
                    case 4:
                        salesDept.showMenu();
                        break;
                    case 5:
                        financialReport.generateReport(
                            adminDept.getTotalSalary(),
                            customerService.getTotalSalary(),
                            productionDept.getTotalSalary(),
                            salesDept.getTotalSalary(),
                            ((ProductionDepartment)productionDept).getTotalProductionCost(),
                            ((SalesDepartment)salesDept).getTotalSales()
                        );
                        break;
                    case 6:
                        manageEmployees(scanner);
                        break;
                    case 7:
                        exit = true;
                        System.out.println("Exiting Economy Predictor...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Clear the buffer
            }
        }
        scanner.close();
    }
    
    private static void manageEmployees(Scanner scanner) {
        HRDepartment hr = new HRDepartment();
        boolean back = false;
        
        while (!back) {
            System.out.println("\n--- Employee Management ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. View All Employees");
            System.out.println("4. Calculate Total Salary");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter base salary: ");
                    double salary = scanner.nextDouble();
                    
                    hr.addEmployee(new AdminEmployee(name, position, salary, name));
                    System.out.println("Employee added successfully!");
                    break;
                case 2:
                    System.out.print("Enter employee name to remove: ");
                    String empName = scanner.nextLine();
                    hr.removeEmployee(empName);
                    System.out.println("Employee removed successfully!");
                    break;
                case 3:
                    hr.displayAllEmployees();
                    break;
                case 4:
                    System.out.println("Total salary for all employees: $" + hr.calculateTotalSalary());
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}