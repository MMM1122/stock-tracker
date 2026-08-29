import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Portfolio {
    private String name;
    private Map<String, Position> positions = new LinkedHashMap<>();

    public Portfolio(String name) {
        
        if (name == null || name.isBlank()) {
        throw new IllegalArgumentException("portfolio name must not be blank");
    }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Position add(Position position) {
    if (position == null) {
        throw new IllegalArgumentException("position must not be null");
    }

    Position existing = positions.get(position.getSymbol());

    if (existing == null) {
        // 这只股票还没有持仓，直接放进 map
        positions.put(position.getSymbol(), position);
        return position;
    }

    // 已经有了，合并进去
    existing.addShares(position.getQuantity(), position.getAverageCost());
    return existing;
}
public BigDecimal totalCostBasis() {
        // 把所有持仓的 costBasis() 加起来
        BigDecimal total = BigDecimal.ZERO;
        for (Position position : positions.values()) {
            total = total.add(position.costBasis());
        }
        return total;
    }

    public BigDecimal totalMarketValue(BigDecimal currentPrice) {
        // 把所有持仓的 maraketValue(currentPrice) 加起来
        BigDecimal total = BigDecimal.ZERO;
        for (Position position : positions.values()) {
            total = total.add(position.marketValue(currentPrice));
        }
        return total;
    }
}