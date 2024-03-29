package com.shoggoth.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@RequiredArgsConstructor
@Data
public class VacationDurationRequestPayload {
    @NotNull(message = "averageSalary must be not null")
    @DecimalMin(value = "0", message = "averageSalary must be not negative")
    @Digits(integer = Integer.MAX_VALUE, fraction = 2 , message = "The number of digits after the period should not be more than two")
    private final BigDecimal averageSalary;
    @NotNull(message = "vacationDaysAmount must be not null")
    @Min(value = 0, message = "vacationDaysAmount must be not negative")
    private final Integer vacationDaysAmount;
}
