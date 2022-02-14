package com.mohamed.CurrencyConverterAPP.webservice.entity;

import com.google.gson.annotations.SerializedName;

public class ConversionResponse {

    @SerializedName("conversion_result")
    private Double conversionResult;

    @SerializedName("target_currency")
    private String targetCurrency;

    public ConversionResponse(final Double conversionResult, final String targetCurrency) {
        this.conversionResult = conversionResult;
        this.targetCurrency = targetCurrency;
    }

    public Double getConversionResult() {
        return conversionResult;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }
}
