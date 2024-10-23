package com.alex.microservices.currency_exchange_service.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.alex.microservices.currency_exchange_service.domain.CurrencyExchange;
import com.alex.microservices.currency_exchange_service.services.CurrencyExchangeService;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CurrencyExchangeController {

    private final Environment environment;
    private final CurrencyExchangeService currencyExchangeService;

    public CurrencyExchangeController(Environment environment, CurrencyExchangeService currencyExchangeService) {
        this.environment = environment;
        this.currencyExchangeService = currencyExchangeService;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> retrieveExchangeValue(@PathVariable String from,
            @PathVariable String to) {
        Optional<CurrencyExchange> exchangeValue = currencyExchangeService.retrieveExchangeValue(from, to);
        return exchangeValue.map(currencyExchange -> {
            return new ResponseEntity<>(currencyExchange, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/currency-exchange")
    public ResponseEntity<CurrencyExchange> createExchangeValue(@RequestBody CurrencyExchange currencyExchange) {
        CurrencyExchange savedCurrencyExchange = currencyExchangeService.createExchangeValue(currencyExchange);
        return new ResponseEntity<>(savedCurrencyExchange, HttpStatus.CREATED);
    }

}
