import java.math.BigDecimal;

public class Position {
    private String symbol;
    private BigDecimal quantity;
    private BigDecimal averageCost;

    public Position(String symbol, BigDecimal quantity, BigDecimal averageCost) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.averageCost = averageCost;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getAverageCost() {
        return averageCost;
    }

}

