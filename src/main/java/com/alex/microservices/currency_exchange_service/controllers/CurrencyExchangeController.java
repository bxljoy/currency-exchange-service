package com.alex.microservices.currency_exchange_service.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.alex.microservices.currency_exchange_service.domain.CurrencyExchange;

import java.math.BigDecimal;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CurrencyExchangeController {

    private Environment environment;

    public CurrencyExchangeController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
            @PathVariable String to) {

        CurrencyExchange currencyExchange = CurrencyExchange.builder()
                .id(1000L)
                .from(from)
                .to(to)
                .conversionMultiple(BigDecimal.valueOf(50))
                .environment(environment.getProperty("local.server.port"))
                .build();
        return currencyExchange;
    }

}
