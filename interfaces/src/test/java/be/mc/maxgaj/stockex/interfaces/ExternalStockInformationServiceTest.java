package be.mc.maxgaj.stockex.interfaces;

import be.mc.maxgaj.stockex.interfaces.ExternalStockInformationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ExternalStockInformationServiceTest {
    @Test
    void givenExternalStockInformationService_whenGetPriceInEuroForStock_thenReturnValueBetween10And100() {
        ExternalStockInformationService service = new ExternalStockInformationService();
        BigDecimal price = service.getPriceInEuroForStock("Test");
        Assertions.assertTrue(price.compareTo(BigDecimal.valueOf(10.0)) >= 0 );
        Assertions.assertTrue(price.compareTo(BigDecimal.valueOf(100.0)) <= 0 );
    }
}