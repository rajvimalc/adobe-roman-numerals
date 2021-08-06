package com.adobe.assessment.romannumerals.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vimalraj Chandra Sekaran (rajvimalc)
 * Email: rajvimalc@gmail.com
 * Created on: 8/5/2021 10:46 PM
 *
 * Response model for numeral to roman conversion Api.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NumeralsConversion {

    /**
     * Input from the request
     */
    private String input;

    /**
     * Output after the conversion
     */
    private String output;

}
