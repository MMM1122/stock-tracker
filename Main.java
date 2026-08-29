import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Portfolio portfolio = new Portfolio("My Portfolio");

        portfolio.add(new Position("AAPL", new BigDecimal("10"), new BigDecimal("150")));
        Position merged = portfolio.add(new Position("AAPL", new BigDecimal("10"), new BigDecimal("200")));

        System.out.println(merged.getQuantity() + " @ " + merged.getAverageCost());
        System.out.println("Total cost:  " + portfolio.totalCostBasis());
        System.out.println("Total value: " + portfolio.totalMarketValue(new BigDecimal("196.40")));
    }
}