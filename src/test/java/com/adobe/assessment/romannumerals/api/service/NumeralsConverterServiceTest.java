package com.adobe.assessment.romannumerals.api.service;

import com.adobe.assessment.romannumerals.api.config.NumeralsRange;
import com.adobe.assessment.romannumerals.api.model.NumeralsConversion;
import com.adobe.assessment.romannumerals.framework.exception.ServiceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Vimalraj Chandra Sekaran (rajvimalc)
 * Email: rajvimalc@gmail.com
 * Created on: 8/6/2021 6:47 PM
 */
class NumeralsConverterServiceTest {

    private static final Integer RANGE_MIN = 1;

    private static final Integer RANGE_MAX = 3999;

    private final NumeralsRange numeralsRange = new NumeralsRange(RANGE_MIN, RANGE_MAX);

    private final NumeralsConverterService numeralsConverterService = new NumeralsConverterServiceImpl(numeralsRange);

    @Test
    void test_NumeralsRange() {
        Assertions.assertNotNull(numeralsRange, "NumeralsRange should not be null");
    }

    @Test
    void test_NumeralsConverterService() {
        Assertions.assertNotNull(numeralsConverterService, "NumeralsConverterService should not be null");
    }

    @Test
    void test_NumeralsConverterService_WhenInputIsValidInteger() {
        Assertions.assertNotNull(numeralsConverterService.convertNumeralToRoman(5), "Non null result is expected");
    }

    @Test
    void test_NumeralsConverterService_WhenInputIs1() {
        final NumeralsConversion conversion = numeralsConverterService.convertNumeralToRoman(1);
        Assertions.assertEquals(conversion.getInput(), "1", "Input value differs from expected");
        Assertions.assertEquals(conversion.getOutput(), "I", "Output value differs from expected");
    }

    @Test
    void test_NumeralsConverterService_WhenInputIs88() {
        final NumeralsConversion conversion = numeralsConverterService.convertNumeralToRoman(88);
        Assertions.assertEquals(conversion.getInput(), "88", "Input value differs from expected");
        Assertions.assertEquals(conversion.getOutput(), "LXXXVIII", "Output value differs from expected");
    }

    @Test
    void test_NumeralsConverterService_WhenInputIs255() {
        final NumeralsConversion conversion = numeralsConverterService.convertNumeralToRoman(255);
        Assertions.assertEquals(conversion.getInput(), "255", "Input value differs from expected");
        Assertions.assertEquals(conversion.getOutput(), "CCLV", "Output value differs from expected");
    }

    @Test
    void test_NumeralsConverterService_WhenInputIs478() {
        final NumeralsConversion conversion = numeralsConverterService.convertNumeralToRoman(478);
        Assertions.assertEquals(conversion.getInput(), "478", "Input value differs from expected");
        Assertions.assertEquals(conversion.getOutput(), "CDLXXVIII", "Output value differs from expected");
    }

    @Test
    void test_NumeralsConverterService_WhenInputIs3999() {
        final NumeralsConversion conversion = numeralsConverterService.convertNumeralToRoman(3999);
        Assertions.assertEquals(conversion.getInput(), "3999", "Input value differs from expected");
        Assertions.assertEquals(conversion.getOutput(), "MMMCMXCIX", "Output value differs from expected");
    }

    @Test
    void test_NumeralsConverterService_WhenInputIsNull() {
        Assertions.assertThrows(ServiceException.class,
                () -> numeralsConverterService.convertNumeralToRoman(null),
                "Should throw ServiceException when input is null"
        );
    }

    @Test
    void test_NumeralsConverterService_WhenInputIsLessThanMinRange() {
        Assertions.assertThrows(ServiceException.class,
                () -> numeralsConverterService.convertNumeralToRoman(RANGE_MIN - 1),
                "Should throw ServiceException when input is less than Min Range: " + RANGE_MIN
        );
    }

    @Test
    void test_NumeralsConverterService_WhenInputIsGreaterThanMaxRange() {
        Assertions.assertThrows(ServiceException.class,
                () -> numeralsConverterService.convertNumeralToRoman(RANGE_MAX + 1),
                "Should throw ServiceException when input is greater than Max Range: " + RANGE_MAX
        );
    }

}