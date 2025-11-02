package com.itsf.tax.config;

import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;
import java.math.BigDecimal;

@Configuration
@ConfigurationProperties(prefix = "tax")
@Getter
@Setter
@Validated
public class TaxProperties {

    /**
     * Basic sales tax rate applicable on taxable goods
     */
    @DecimalMin("0.00")
    private BigDecimal basicRate;

    /**
     * Import tax rate applicable on all imported goods
     */
    @DecimalMin("0.00")
    private BigDecimal importRate;

    /**
     * Precision on which the taxes will be rounded up to
     */
    @DecimalMin("0.00")
    private BigDecimal roundingPrecision;
}
