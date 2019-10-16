package be.mc.maxgaj.stockex;

import java.math.BigDecimal;

public class StockService {
    public Stock getStock(String stockId){
        StockRepository repository = new StockRepository();
        try {
            Stock stockToReturn = repository.getStockInformation(stockId);
            ExternalStockInformationService service = new ExternalStockInformationService();
            stockToReturn.setPrice(service.getPriceInEuroForStock(stockId));
            return stockToReturn;
        } catch (IllegalArgumentException e) {
            Stock stockToReturn = new Stock(stockId, "INVALID_ID");
            stockToReturn.setPrice(BigDecimal.ZERO);
            return stockToReturn;
        }
    }
}
