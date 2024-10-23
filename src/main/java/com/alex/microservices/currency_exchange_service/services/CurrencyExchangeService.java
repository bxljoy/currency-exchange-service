package com.alex.microservices.currency_exchange_service.services;

import com.alex.microservices.currency_exchange_service.domain.CurrencyExchange;

public interface CurrencyExchangeService {

    CurrencyExchange createExchangeValue(CurrencyExchange currencyExchange);

}
