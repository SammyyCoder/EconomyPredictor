package economypredictor.administration;

public abstract class Employee {
    protected String name;
    protected String employeeId;
    protected double baseSalary;
    
    public Employee(String name, String employeeId, double baseSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
    }
    
    public abstract double calculateSalary();
    
    // Common methods for all employees
    public String getName() {
        return name;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    
    public double getBaseSalary() {
        return baseSalary;
    }
}
