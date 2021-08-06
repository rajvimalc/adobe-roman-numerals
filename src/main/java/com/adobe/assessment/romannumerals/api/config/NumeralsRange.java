package com.adobe.assessment.romannumerals.api.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Vimalraj Chandra Sekaran (rajvimalc)
 * Email: rajvimalc@gmail.com
 * Created on: 8/6/2021 7:17 PM
 */
@Configuration
@ConfigurationProperties("numeral-to-roman.range")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NumeralsRange {

    private Integer min;

    private Integer max;

}
