package economypredictor.administration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HRDepartment {
    private List<AdminEmployee> employees = new ArrayList<>();
    
    public void addEmployee(AdminEmployee employee) {
        employees.add(employee);
    }
    
    public void removeEmployee(String name) {
        employees.removeIf(e -> e.getName().equals(name));
    }
    
    public void displayAllEmployees() {
        System.out.println("\n=== HR Department Employees ===");
        for (AdminEmployee employee : employees) {
            System.out.println(employee);
        }
    }
    
    public Stream<AdminEmployee> calculateTotalSalary() {
        return employees.stream();
    }
}
