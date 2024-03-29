package com.shoggoth.service;

import com.shoggoth.model.VacationDurationRequestPayload;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class VacationPaymentByVacationDurationCalculationServiceImplTest {
    private static VacationPaymentByVacationDurationCalculationServiceImpl calculationService;

    @BeforeAll
    static void Init() {
        calculationService = new VacationPaymentByVacationDurationCalculationServiceImpl();
    }


    @Test
    void calculate_WhenValidRequest_ThenReturnCalculateResult() {
        VacationDurationRequestPayload requestPayload = new VacationDurationRequestPayload(
                new BigDecimal("2050.34"),
                7
        );
        assertEquals(calculationService.calculate(requestPayload).getPaymentAmount(), new BigDecimal("14352.38"));
    }

    @Test
    void calculate_WhenZeroAverageSalary_ThenReturnZeroResult() {
        VacationDurationRequestPayload requestPayload = new VacationDurationRequestPayload(
                new BigDecimal("0.00"),
                7
        );
        assertEquals(calculationService.calculate(requestPayload).getPaymentAmount(), new BigDecimal("0.00"));
    }

    @Test
    void calculate_WhenZeroVacationDaysAmount_ThenReturnZeroResult() {
        VacationDurationRequestPayload requestPayload = new VacationDurationRequestPayload(
                new BigDecimal("14352.38"),
                0
        );
        assertEquals(calculationService.calculate(requestPayload).getPaymentAmount(), new BigDecimal("0.00"));
    }

}