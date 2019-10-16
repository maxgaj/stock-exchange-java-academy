package be.mc.maxgaj.stockex;

import java.math.BigDecimal;

public class Stock {
    private String id;
    private String name;
    private StockPrice price;

    public Stock(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public StockPrice getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = new StockPrice(price, StockCurrency.EUR);
    }
}
