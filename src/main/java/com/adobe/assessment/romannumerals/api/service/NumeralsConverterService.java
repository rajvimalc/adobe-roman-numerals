package com.adobe.assessment.romannumerals.api.service;

import com.adobe.assessment.romannumerals.api.model.NumeralsConversion;

/**
 * @author Vimalraj Chandra Sekaran (rajvimalc)
 * Email: rajvimalc@gmail.com
 * Created on: 8/5/2021 10:39 PM
 *
 * Numeral to Roman Conversion Service
 */
public interface NumeralsConverterService {

    /**
     * Numeral to Roman Conversion Service method
     *
     * @param numeral Input for the conversion
     * @return NumeralsConversion with input and output values
     */
    NumeralsConversion convertNumeralToRoman(final Integer numeral);

}
