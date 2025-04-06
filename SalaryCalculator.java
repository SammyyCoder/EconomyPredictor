package economypredictor.finance;

public class SalaryCalculator {
    private static final double ADMIN_BASE_SALARY = 18439;
    private static final double CUSTOMER_SERVICE_BASE_SALARY = 11439;
    private static final double PRODUCTION_BASE_SALARY = 8000;
    private static final double SALES_BASE_SALARY = 10000;
    private static final double DA_RATE = 0.4;
    private static final double HRA_RATE = 0.2;
    private static final double TAX_RATE = 0.3;
    private static final int MONTHS = 12;
    
    public static double calculateAdminSalary(int employeeCount) {
        return calculateSalary(ADMIN_BASE_SALARY, employeeCount);
    }
    
    public static double calculateCustomerServiceSalary(int employeeCount) {
        return calculateSalary(CUSTOMER_SERVICE_BASE_SALARY, employeeCount);
    }
    
    public static double calculateProductionSalary(int employeeCount) {
        return calculateSalary(PRODUCTION_BASE_SALARY, employeeCount);
    }
    
    public static double calculateSalesSalary(int employeeCount) {
        return calculateSalary(SALES_BASE_SALARY, employeeCount);
    }
    
    private static double calculateSalary(double baseSalary, int employeeCount) {
        double da = baseSalary * DA_RATE;
        double hra = baseSalary * HRA_RATE;
        double monthlySalary = baseSalary + da + hra;
        double annualSalary = monthlySalary * MONTHS;
        
        if (annualSalary > 250000 && annualSalary < 5000000) {
            double tax = monthlySalary * TAX_RATE;
            double netSalary = monthlySalary - tax;
            System.out.println("\nTax per employee: $" + tax);
            System.out.println("Net monthly salary per employee: $" + netSalary);
            return netSalary * MONTHS * employeeCount;
        } else {
            System.out.println("\nNo tax deducted for these employees");
            return monthlySalary * MONTHS * employeeCount;
        }
    }
}
