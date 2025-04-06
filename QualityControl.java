package economypredictor.production;

public class QualityControl {
    public void performQualityCheck(Product[] products) {
        System.out.println("\n=== Quality Control Check ===");
        for (Product product : products) {
            if (product != null) {
                System.out.println("Checking quality for " + product.getName());
                
                // Simulate quality check
                boolean passed = Math.random() > 0.1; // 90% pass rate
                
                if (passed) {
                    System.out.println("✅ " + product.getName() + " passed quality check");
                } else {
                    System.out.println("❌ " + product.getName() + " failed quality check");
                    // In a real system, we might remove failed products from inventory
                }
            }
        }
    }
}
