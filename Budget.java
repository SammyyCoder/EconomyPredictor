package economypredictor.finance;

import economypredictor.administration.Department;
import java.util.ArrayList;
import java.util.List;

public class Budget implements FinancialEntity {
    private List<Department> departments;
    private double otherExpenses;
    
    public Budget() {
        this.departments = new ArrayList<>();
        this.otherExpenses = 0;
    }
    
    public void addDepartment(Department department) {
        departments.add(department);
    }
    
    public void setOtherExpenses(double expenses) {
        this.otherExpenses = expenses;
    }
    
    @Override
    public double calculateCost() {
        double total = otherExpenses;
        for (Department dept : departments) {
            total += dept.getTotalSalary();
        }
        return total;
    }
    
    @Override
    public double calculateRevenue() {
        // Budget doesn't generate revenue
        return 0;
    }
    
    public void displayBudgetSummary() {
        System.out.println("\n=== Budget Summary ===");
        System.out.println("Department Salaries:");
        for (Department dept : departments) {
            System.out.printf("%s: $%.2f\n", dept.getDepartmentName(), dept.getTotalSalary());
        }
        System.out.printf("Other Expenses: $%.2f\n", otherExpenses);
        System.out.printf("Total Budget: $%.2f\n", calculateCost());
    }
}