package be.mc.maxgaj.stockex.api;

import be.mc.maxgaj.stockex.domain.Stock;
import be.mc.maxgaj.stockex.service.StockService;

public class StockExchangeController {
    public StockDto getStock(String stockId){
        StockService service = new StockService();
        Stock stock = service.getStock(stockId);
        return new StockDto(stock);
    }
}
