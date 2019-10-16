package be.mc.maxgaj.stockex;

public class StockExchangeController {
    public StockDto getStock(String stockId){
        StockService service = new StockService();
        Stock stock = service.getStock(stockId);
        return new StockDto(stock);
    }
}
