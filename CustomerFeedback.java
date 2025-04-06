package economypredictor.customer;

import java.util.Scanner;

public class CustomerFeedback {
    private int excellent = 0;
    private int good = 0;
    private int average = 0;
    private int satisfactory = 0;
    private int poor = 0;
    
    public void recordFeedback() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== Customer Feedback ===");
        System.out.println("1. Excellent");
        System.out.println("2. Good");
        System.out.println("3. Average");
        System.out.println("4. Satisfactory");
        System.out.println("5. Poor");
        System.out.print("Enter your rating: ");
        
        int rating = scanner.nextInt();
        
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
}
