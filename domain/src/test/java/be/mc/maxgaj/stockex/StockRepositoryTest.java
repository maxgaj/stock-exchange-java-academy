package be.mc.maxgaj.stockex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockRepositoryTest {

    @Test
    void givenStockRepository_whenGetInfoForValidKey_getCorrectStock() {
        StockRepository repository = new StockRepository();
        Stock stock = repository.getStockInformation("AAPL");
        Assertions.assertEquals("Apple", stock.getName());
    }

    @Test
    void givenStockRepository_whenGetInfoForInvalidKey_getException() {
        StockRepository repository = new StockRepository();
        Assertions.assertThrows(IllegalArgumentException.class, () -> repository.getStockInformation("TEST"));
    }
}