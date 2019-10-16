package be.mc.maxgaj.stockex;

public class StockDto {
    private final String name;
    private final String id;
    private final String price;

    public StockDto(Stock stock) {
        this.name = stock.getName();
        this.id = stock.getId();
        this.price = stock.getPrice().toString();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Stock "+name + " ["+id+"] - "+price;
    }
}
