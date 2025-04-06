package economypredictor.finance;

public interface FinancialEntity {
    double calculateCost();
    double calculateRevenue();
    default double calculateProfit() {
        return calculateRevenue() - calculateCost();
    }
}