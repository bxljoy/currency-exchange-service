package com.alex.microservices.currency_exchange_service.services;

import com.alex.microservices.currency_exchange_service.domain.CurrencyExchange;
import java.util.Optional;

public interface CurrencyExchangeService {

    CurrencyExchange createExchangeValue(CurrencyExchange currencyExchange);

    Optional<CurrencyExchange> retrieveExchangeValue(String from, String to);

}
