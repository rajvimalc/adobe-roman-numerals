package com.adobe.assessment.romannumerals.api.controller;

import com.adobe.assessment.romannumerals.api.model.NumeralsConversion;
import com.adobe.assessment.romannumerals.api.service.NumeralsConverterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vimalraj Chandra Sekaran (rajvimalc)
 * Email: rajvimalc@gmail.com
 * Created on: 8/5/2021 10:38 PM
 *
 * Rest controller class for the Numeral to Romam converter Apis
 */
@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class NumeralsConverterController {

    private final NumeralsConverterService numeralsConverterService;

    /**
     * Api to convert a numeral into roman
     *
     * @param query Numeral to be converted into roman
     * @return NumeralsConversion with input and output values
     */
    @GetMapping
    public NumeralsConversion convertNumeralToRoman(@RequestParam("query") Integer query) {
        log.debug("Request received to convert numeral: {}", query);
        return numeralsConverterService.convertNumeralToRoman(query);
    }

}
