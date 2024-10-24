package com.alex.microservices.currency_exchange_service.utils;

import com.alex.microservices.currency_exchange_service.domain.CurrencyExchange;
import java.math.BigDecimal;

public class DataUtils {

    public static CurrencyExchange creatCurrencyExchange(String from, String to, BigDecimal conversionMultiple) {
        return CurrencyExchange.builder().from(from).to(to).conversionMultiple(conversionMultiple).build();
    }
}
