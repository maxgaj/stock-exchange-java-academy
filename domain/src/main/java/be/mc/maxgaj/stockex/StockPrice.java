package be.mc.maxgaj.stockex;

import java.math.BigDecimal;

public class StockPrice {
    private BigDecimal price;
    private StockCurrency currency;

    public StockPrice(BigDecimal price, StockCurrency currency) {
        this.price = price;
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public StockCurrency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return price.toString() + " " + currency.getLabel();
    }
}
