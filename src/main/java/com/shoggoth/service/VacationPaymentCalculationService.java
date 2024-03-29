package com.shoggoth.service;

import com.shoggoth.model.CalculationResult;
import com.shoggoth.model.VacationDurationRequestPayload;

public interface VacationPaymentCalculationService {
    CalculationResult calculate(VacationDurationRequestPayload given);
}
