package com.shoggoth.service;

import com.shoggoth.model.VacationDurationRequestPayload;
import com.shoggoth.model.CalculationResult;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class VacationPaymentByVacationDurationCalculationServiceImpl implements VacationPaymentCalculationService {
    @Override
    public CalculationResult calculate(VacationDurationRequestPayload requestPayload) {
        BigDecimal vacationPaymentAmount = requestPayload.getAverageSalary()
                .multiply(BigDecimal.valueOf(requestPayload.getVacationDaysAmount()));
        return new CalculationResult(vacationPaymentAmount);
    }
}
