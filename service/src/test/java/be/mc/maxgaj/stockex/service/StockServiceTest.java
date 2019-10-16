package be.mc.maxgaj.stockex.service;

import be.mc.maxgaj.stockex.domain.Stock;
import be.mc.maxgaj.stockex.service.StockService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StockServiceTest {
    @Test
    void givenStockService_whenGetStockWithValidId_thenReturnCorrectStock() {
        StockService service = new StockService();
        Stock stock = service.getStock("AAPL");
        Assertions.assertEquals("Apple", stock.getName());
    }

    @Test
    void givenStockService_whenGetStockWithInvalidId_thenReturnInvalidStock() {
        StockService service = new StockService();
        Stock stock = service.getStock("TEST");
        Assertions.assertEquals("INVALID_ID", stock.getName());
    }
}