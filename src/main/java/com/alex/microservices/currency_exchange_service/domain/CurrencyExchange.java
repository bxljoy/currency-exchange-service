package com.alex.microservices.currency_exchange_service.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyExchange {

    private Long id;

    private String from;

    private String to;

    private BigDecimal conversionMultiple;

    private String environment;

}
