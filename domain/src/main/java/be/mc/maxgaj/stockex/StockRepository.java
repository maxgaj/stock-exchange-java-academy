package be.mc.maxgaj.stockex;

import com.google.common.collect.ImmutableMap;

public class StockRepository {
    private ImmutableMap<String, Stock> stockDB;

    public StockRepository() {
        stockDB = new ImmutableMap.Builder<String, Stock>()
                .put("AAPL", new Stock("AAPL", "Apple"))
                .put("GOOGL", new Stock("GOOGL", "Google"))
                .put("MSFT", new Stock("MSFT", "Microsoft"))
                .build();
    }

    public Stock getStockInformation(String stockId){
        if (!stockDB.containsKey(stockId)){
            throw new IllegalArgumentException("Id was not found in the database");
        }
        return stockDB.get(stockId);
    }
}
