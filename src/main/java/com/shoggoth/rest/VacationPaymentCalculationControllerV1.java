package com.shoggoth.rest;

import com.shoggoth.model.CalculationResult;
import com.shoggoth.model.VacationDurationRequestPayload;
import com.shoggoth.service.VacationPaymentCalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class VacationPaymentCalculationControllerV1 {
    private final VacationPaymentCalculationService calculationService;
    @GetMapping(value = "/calculate")
    ResponseEntity<CalculationResult> getVacationPaymentAmount(@Valid @RequestBody VacationDurationRequestPayload requestPayload) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(calculationService.calculate(requestPayload));
    }

}
