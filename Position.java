import java.math.BigDecimal;

public class Position {
    private String symbol;
    private BigDecimal quantity;
    private BigDecimal averageCost;

    public Position(String symbol, BigDecimal quantity, BigDecimal averageCost) {
        if (symbol == null || symbol.isBlank()) {
        throw new IllegalArgumentException("symbol must not be blank");
    }
        if (quantity == null || quantity.signum() <= 0) {
    throw new IllegalArgumentException("quantity must be greater than zero");
}
        if (averageCost == null || averageCost.signum() <= 0) {
    throw new IllegalArgumentException("averageCost must be greater than zero");
}
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

    public BigDecimal costBasis() {
    return quantity.multiply(averageCost);
}
    public BigDecimal marketValue(BigDecimal currentPrice) {
    return quantity.multiply(currentPrice);
}

}

