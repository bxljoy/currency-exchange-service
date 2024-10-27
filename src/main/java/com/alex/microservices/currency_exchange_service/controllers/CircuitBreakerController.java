package com.alex.microservices.currency_exchange_service.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/currency-exchange/sample-api")
    // @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    @CircuitBreaker(name = "backendA", fallbackMethod = "hardcodedResponse")
    @RateLimiter(name = "backendA", fallbackMethod = "exceedRateLimiter")
    public String sampleApi() {
        logger.info("Sample API call received");
        // ResponseEntity<String> repository = new
        // RestTemplate().getForEntity("http://localhost:8080/some-api",
        // String.class);
        // return repository.getBody();
        return "Sample API";
    }

    public String hardcodedResponse(Exception ex) {
        return "fallback response";
    }

    public String exceedRateLimiter(Exception ex) {
        return "Your calling exceeds the ratelimiter, please try again later!";
    }

}
