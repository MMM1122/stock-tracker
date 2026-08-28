import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Position p = new Position("AAPL", new BigDecimal("10"), new BigDecimal("150"));
        System.out.println("Cost basis:   " + p.costBasis());
        System.out.println("Market value: " + p.marketValue(new BigDecimal("196.40")));
    }
}