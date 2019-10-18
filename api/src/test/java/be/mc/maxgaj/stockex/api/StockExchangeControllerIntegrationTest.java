package be.mc.maxgaj.stockex.api;

import be.mc.maxgaj.stockex.domain.StockRepository;
import be.mc.maxgaj.stockex.interfaces.ExternalStockInformationService;
import be.mc.maxgaj.stockex.service.StockService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {ExternalStockInformationService.class, StockRepository.class, StockService.class, StockExchangeController.class})
@AutoConfigureMockMvc
class StockExchangeControllerIntegrationTest {

    @Autowired
    private StockExchangeController controller;


    @Test
    void getStock_givenValidStockId_thenReturnsCorrectDto() {
        String stockId = "AAPL";
        StockDto stockDto = controller.getStock(stockId);
        Assertions.assertThat(stockDto.getName()).isEqualTo("Apple");
    }

    @Test
    void getStock_givenInvalidStockId_thenReturnsInvalidDto() {
        String stockId = "TEST";
        StockDto stockDto = controller.getStock(stockId);
        Assertions.assertThat(stockDto.getName()).isEqualTo("INVALID_ID");
    }
}