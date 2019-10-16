package be.mc.maxgaj.stockex.domain;

import be.mc.maxgaj.stockex.domain.Stock;
import be.mc.maxgaj.stockex.domain.StockRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StockRepositoryTest {

    @Test
    void givenStockRepository_whenGetInfoForValidKey_getCorrectStock() {
        StockRepository repository = new StockRepository();
        Stock stock = repository.getStockInformation("AAPL");
        Assertions.assertEquals("Apple2", stock.getName());
    }

    @Test
    void givenStockRepository_whenGetInfoForInvalidKey_getException() {
        StockRepository repository = new StockRepository();
        Assertions.assertThrows(IllegalArgumentException.class, () -> repository.getStockInformation("TEST"));
    }
}