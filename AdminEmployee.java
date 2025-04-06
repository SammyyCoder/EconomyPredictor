package economypredictor.administration;

public class AdminEmployee extends Employee {
    private String department;
    
    public AdminEmployee(String name, String employeeId, double baseSalary, String department) {
        super(name, employeeId, baseSalary);
        this.department = department;
    }
    
    @Override
    public double calculateSalary() {
        // Admin employees get 15% bonus
        return baseSalary * 1.15;
    }
    
    public String getDepartment() {
        return department;
    }
    
    @Override
    public String toString() {
        return String.format("Admin Employee - Name: %s, ID: %s, Dept: %s, Salary: $%.2f",
                           name, employeeId, department, calculateSalary());
    }
}