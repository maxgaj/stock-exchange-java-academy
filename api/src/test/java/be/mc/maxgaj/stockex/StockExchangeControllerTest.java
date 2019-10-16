package be.mc.maxgaj.stockex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class StockExchangeControllerTest {
    @Test
    void givenController_whenGetStockWithValidId_thenGetCorrectDto() {
        StockExchangeController controller = new StockExchangeController();
        StockDto stockDto = controller.getStock("AAPL");
        Assertions.assertEquals("Apple", stockDto.getName());
    }

    @Test
    void givenController_whenGetStockWithInvalidId_thenGetInvalidDto() {
        StockExchangeController controller = new StockExchangeController();
        StockDto stockDto = controller.getStock("TEST");
        Assertions.assertEquals("INVALID_ID", stockDto.getName());
    }
}