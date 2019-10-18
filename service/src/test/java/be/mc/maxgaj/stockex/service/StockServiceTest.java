package be.mc.maxgaj.stockex.service;

import be.mc.maxgaj.stockex.domain.Stock;
import be.mc.maxgaj.stockex.domain.StockRepository;
import be.mc.maxgaj.stockex.interfaces.ExternalStockInformationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class StockServiceTest {
    @Mock
    private StockRepository stockRepository;
    @Mock
    private ExternalStockInformationService externalStockInformationService;
    @InjectMocks
    private StockService stockService;


    @Test
    void givenStockService_whenGetStockWithValidId_thenReturnCorrectStock() {
        String stockId = "AAPL";
        Mockito.when(stockRepository.getStockInformation(stockId)).thenReturn(new Stock("AAPL", "Apple"));
        Mockito.when(externalStockInformationService.getPriceInEuroForStock(stockId)).thenReturn(BigDecimal.ONE);
        Stock stock = stockService.getStock("AAPL");
        Assertions.assertEquals("Apple", stock.getName());
    }

    @Test
    void givenStockService_whenGetStockWithInvalidId_thenReturnInvalidStock() {
        String stockId = "TEST";
        Mockito.when(stockRepository.getStockInformation(stockId)).thenThrow(IllegalArgumentException.class);
        Stock stock = stockService.getStock(stockId);
        Assertions.assertEquals("INVALID_ID", stock.getName());
    }
}