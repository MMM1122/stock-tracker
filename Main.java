import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Position p = new Position("AAPL", new BigDecimal("10"), new BigDecimal("150"));
        System.out.println("Cost basis: " + p.costBasis());
    }
}