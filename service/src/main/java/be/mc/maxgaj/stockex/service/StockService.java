package be.mc.maxgaj.stockex.service;

import be.mc.maxgaj.stockex.domain.Stock;
import be.mc.maxgaj.stockex.domain.StockRepository;
import be.mc.maxgaj.stockex.interfaces.ExternalStockInformationService;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class StockService {

    private StockRepository stockRepository;
    private ExternalStockInformationService externalStockInformationService;

    @Inject
    public StockService(StockRepository stockRepository, ExternalStockInformationService externalStockInformationService) {
        this.stockRepository = stockRepository;
        this.externalStockInformationService = externalStockInformationService;
    }

    public Stock getStock(String stockId){
        try {
            Stock stockToReturn = stockRepository.getStockInformation(stockId);
            stockToReturn.setPrice(externalStockInformationService.getPriceInEuroForStock(stockId));
            return stockToReturn;
        } catch (IllegalArgumentException e) {
            Stock stockToReturn = new Stock(stockId, "INVALID_ID");
            stockToReturn.setPrice(BigDecimal.ZERO);
            return stockToReturn;
        }
    }
}
