package economypredictor.production;

import economypredictor.administration.Employee;

public class ProductionEmployee extends Employee {
    private String shift;
    
    public ProductionEmployee(String name, String employeeId, double baseSalary, String shift) {
        super(name, employeeId, baseSalary);
        this.shift = shift;
    }
    
    @Override
    public double calculateSalary() {
        // Production employees get 10% shift differential for night shift
        if (shift.equalsIgnoreCase("night")) {
            return baseSalary * 1.10;
        }
        return baseSalary;
    }
    
    public String getShift() {
        return shift;
    }
    
    @Override
    public String toString() {
        return String.format("Production Employee - Name: %s, ID: %s, Shift: %s, Salary: $%.2f",
                           name, employeeId, shift, calculateSalary());
    }
}