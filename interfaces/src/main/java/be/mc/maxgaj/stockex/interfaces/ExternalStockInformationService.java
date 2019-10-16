package be.mc.maxgaj.stockex.interfaces;

import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;

public class ExternalStockInformationService {
    private static final double MIN_VALUE = 10.0;
    private static final double MAX_VALUE = 100.0;

    public BigDecimal getPriceInEuroForStock(String stockId){
        double randomDouble = RandomUtils.nextDouble(MIN_VALUE, MAX_VALUE);
        return BigDecimal.valueOf(randomDouble);
    }
}
