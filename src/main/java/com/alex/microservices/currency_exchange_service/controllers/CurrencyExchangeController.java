package com.alex.microservices.currency_exchange_service.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.alex.microservices.currency_exchange_service.domain.CurrencyExchange;
import com.alex.microservices.currency_exchange_service.services.CurrencyExchangeService;

import java.math.BigDecimal;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CurrencyExchangeController {

    private final Environment environment;
    private final CurrencyExchangeService CurrencyExchangeService;

    public CurrencyExchangeController(Environment environment, CurrencyExchangeService currencyExchangeService) {
        this.environment = environment;
        this.CurrencyExchangeService = currencyExchangeService;
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

    @PostMapping("/currency-exchange")
    public CurrencyExchange createExchangeValue(@RequestBody CurrencyExchange currencyExchange) {
        return CurrencyExchangeService.createExchangeValue(currencyExchange);
    }

}
