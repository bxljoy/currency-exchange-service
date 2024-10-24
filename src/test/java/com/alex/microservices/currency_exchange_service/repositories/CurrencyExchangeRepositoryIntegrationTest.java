package com.alex.microservices.currency_exchange_service.repositories;

import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.alex.microservices.currency_exchange_service.domain.CurrencyExchange;
import com.alex.microservices.currency_exchange_service.utils.DataUtils;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CurrencyExchangeRepositoryIntegrationTest {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @Test
    public void testThatCurrencyExchangeCanBeCreatedAndRecalled() {
        CurrencyExchange currencyExchange = DataUtils.creatCurrencyExchange("USD", "INR", new BigDecimal(10.8));
        CurrencyExchange saved = currencyExchangeRepository.save(currencyExchange);

        Optional<CurrencyExchange> result = currencyExchangeRepository.findById(saved.getId());

        assertThat(result.get()).isNotNull().isEqualTo(saved);
    }

    @Test
    public void testThatCurrencyExchangeCanBeCreatedAndMultipleRecalled() {
        CurrencyExchange currencyExchange1 = DataUtils.creatCurrencyExchange("USD", "SEK", new BigDecimal(10.5));
        CurrencyExchange saved1 = currencyExchangeRepository.save(currencyExchange1);
        CurrencyExchange currencyExchange2 = DataUtils.creatCurrencyExchange("USD", "CNY", new BigDecimal(7.15));
        CurrencyExchange saved2 = currencyExchangeRepository.save(currencyExchange2);
        CurrencyExchange currencyExchange3 = DataUtils.creatCurrencyExchange("USD", "EUR", new BigDecimal(1.1));
        CurrencyExchange saved3 = currencyExchangeRepository.save(currencyExchange3);

        Iterable<CurrencyExchange> result = currencyExchangeRepository.findAll();

        assertThat(result).isNotNull().hasSize(3).contains(saved1, saved2, saved3);
    }

    @Test
    public void testThatFindByFromAndTo() {

        CurrencyExchange currencyExchange1 = DataUtils.creatCurrencyExchange("USD", "SEK", new BigDecimal(10.5));
        CurrencyExchange saved1 = currencyExchangeRepository.save(currencyExchange1);

        Optional<CurrencyExchange> result = currencyExchangeRepository.findByFromAndTo("USD", "SEK");
        assertThat(result.get()).isNotNull().hasFieldOrProperty("from")
                .hasFieldOrPropertyWithValue("conversionMultiple", new BigDecimal(10.5)).isEqualTo(saved1);
    }
}
