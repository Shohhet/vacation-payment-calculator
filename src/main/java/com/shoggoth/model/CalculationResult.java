package com.shoggoth.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;


@RequiredArgsConstructor
@Data
public class CalculationResult {
    @JsonProperty("paymentAmount")
    @JsonSerialize(using = CurrencySerializer.class)
    private final BigDecimal paymentAmount;
}
