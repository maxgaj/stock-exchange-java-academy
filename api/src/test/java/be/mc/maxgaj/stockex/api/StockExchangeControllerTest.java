package be.mc.maxgaj.stockex.api;

import be.mc.maxgaj.stockex.domain.Stock;
import be.mc.maxgaj.stockex.service.StockService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class StockExchangeControllerTest {
    @Mock
    private StockService stockService;
    @InjectMocks
    private StockExchangeController stockExchangeController;

    @Test
    void givenController_whenGetStockWithValidId_thenGetCorrectDto() {
        String stockId = "AAPL";
        Stock stock = new Stock("AAPL", "Apple");
        stock.setPrice(BigDecimal.ONE);
        Mockito.when(stockService.getStock(stockId)).thenReturn(stock);
        StockDto stockDto = stockExchangeController.getStock("AAPL");
        Assertions.assertEquals("Apple", stockDto.getName());
    }

}