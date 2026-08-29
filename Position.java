import java.math.BigDecimal;
import java.math.RoundingMode;

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
    public BigDecimal unrealizedGain(BigDecimal currentPrice) {
    // 市值 减去 成本
    return  marketValue(currentPrice).subtract(costBasis());
}
    public BigDecimal unrealizedGainPercent(BigDecimal currentPrice) {
    // 1. 算出盈亏（复用已有方法）
    // 2. 除以成本，保留 4 位小数，HALF_UP
    // 3. 乘以 100
    BigDecimal gain = unrealizedGain(currentPrice);
    BigDecimal ratio = gain.divide(costBasis(), 4, RoundingMode.HALF_UP);
    return ratio.multiply(BigDecimal.valueOf(100)); 
}
    public void addShares(BigDecimal additionalQuantity, BigDecimal pricePaid) {
    // 1. 校验两个参数（不能 null，必须 > 0）
    // 2. 算出合并后的新平均成本
    // 3. 更新 this.quantity 和 this.averageCost
    // 新平均成本 = (原股数×原成本 + 新股数×买入价) / (原股数 + 新股数)
    if (additionalQuantity == null || additionalQuantity.signum()<=0) {
        throw new IllegalArgumentException("additional quantity must be greater than zero");
    }

    if (pricePaid == null || pricePaid.signum()<=0) {
        throw new IllegalArgumentException("price paid must be greater than zero");
    }

    BigDecimal existingCost = quantity.multiply(averageCost);      // 原股数 × 原成本
    BigDecimal newCost = additionalQuantity.multiply(pricePaid);// 新股数 × 买入价
    BigDecimal totalQuantity = quantity.add(additionalQuantity); // 原股数 + 新股数
    BigDecimal newAverage = existingCost.add(newCost).divide(totalQuantity, 4,RoundingMode.HALF_UP);

    this.averageCost = newAverage;
    this.quantity = totalQuantity;



}
}

