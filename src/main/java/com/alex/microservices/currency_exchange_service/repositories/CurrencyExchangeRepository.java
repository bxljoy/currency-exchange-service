package com.alex.microservices.currency_exchange_service.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alex.microservices.currency_exchange_service.domain.CurrencyExchange;

@Repository
public interface CurrencyExchangeRepository extends CrudRepository<CurrencyExchange, Long> {

}
