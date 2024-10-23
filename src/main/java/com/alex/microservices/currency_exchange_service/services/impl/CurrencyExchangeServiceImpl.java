package com.alex.microservices.currency_exchange_service.services.impl;

import org.springframework.stereotype.Service;
import com.alex.microservices.currency_exchange_service.domain.CurrencyExchange;
import com.alex.microservices.currency_exchange_service.repositories.CurrencyExchangeRepository;
import com.alex.microservices.currency_exchange_service.services.CurrencyExchangeService;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    private final CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeServiceImpl(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    @Override
    public CurrencyExchange createExchangeValue(CurrencyExchange currencyExchange) {
        return currencyExchangeRepository.save(currencyExchange);
    }

}
