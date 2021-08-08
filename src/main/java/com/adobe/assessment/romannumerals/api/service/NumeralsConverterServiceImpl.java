package com.adobe.assessment.romannumerals.api.service;

import com.adobe.assessment.romannumerals.api.config.NumeralsRange;
import com.adobe.assessment.romannumerals.api.model.NumeralsConversion;
import com.adobe.assessment.romannumerals.framework.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author Vimalraj Chandra Sekaran (rajvimalc)
 * Email: rajvimalc@gmail.com
 * Created on: 8/5/2021 10:40 PM
 *
 * Numeral to Roman Conversion Service Implementation
 */
@Service("numeralsConverterService")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class NumeralsConverterServiceImpl implements NumeralsConverterService {

    private static final Integer[] ROMAN_VALUES = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    private static final String[] ROMAN_LITERALS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    private final NumeralsRange numeralsRange;

    /**
     * {@inheritdoc}
     */
    @Override
    public NumeralsConversion convertNumeralToRoman(final Integer numeral) {

        // Input Validation
        validateRange(numeral);

        // Store Letters used in Roman numerals and the corresponding numerical values in an array.
        // Initialize a string builder, start checking if input number is >= highest roman numeral
        // then add it to the string builder and reduce its corresponding value from the input number.
        // If input number is < highest roman numeral then check with next highest roman numeral
        // and repeat the process above till input number becomes 0.
        // String builder will be the roman representation of input number.

        int number = numeral;
        final StringBuilder roman = new StringBuilder();

        for (int i = 0; i < ROMAN_VALUES.length; i++) {
            while (number >= ROMAN_VALUES[i]) {
                number -= ROMAN_VALUES[i];
                roman.append(ROMAN_LITERALS[i]);
            }
        }

        log.debug("Conversion completed. Numeral: {} => Roman: {}", numeral, roman);

        return new NumeralsConversion(numeral.toString(), roman.toString());
    }

    /**
     * Validates if the numeral provided is non-null and within the range configured
     *
     * @param numeral Input for the conversion
     */
    private void validateRange(final Integer numeral) {
        if(numeral == null) {
            throw new ServiceException(
                    "service.error.001",
                    String.format("Invalid number '%d' given to convert", numeral),
                    HttpStatus.BAD_REQUEST
            );
        } else if (numeral < numeralsRange.getMin() || numeral > numeralsRange.getMax()) {
            throw new ServiceException(
                    "service.error.002",
                    String.format("Given number '%d' is not in range (%d - %d)", numeral, numeralsRange.getMin(), numeralsRange.getMax()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

}
