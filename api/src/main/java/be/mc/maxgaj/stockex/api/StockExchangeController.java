package be.mc.maxgaj.stockex.api;

import be.mc.maxgaj.stockex.domain.Stock;
import be.mc.maxgaj.stockex.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;

@Controller
@ResponseBody
@RequestMapping("/stocks")
public class StockExchangeController {

    private StockService stockService;

    @Autowired
    public StockExchangeController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{stockId}")
    public StockDto getStock(@PathVariable String stockId){
        Stock stock = stockService.getStock(stockId);
        return new StockDto(stock);
    }
}
