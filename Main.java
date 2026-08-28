import java.math.BigDecimal;


public class Main {
    public static void main(String[] args) {
        // 正常的应该成功
        Position good = new Position("AAPL", new BigDecimal("10"), new BigDecimal("150"));
        System.out.println("Created: " + good.getSymbol() + " x" + good.getQuantity());

        // 这个应该抛异常
        Position bad = new Position("AAPL", new BigDecimal("-50"), new BigDecimal("150"));
        System.out.println("This line should never print");
    }
}