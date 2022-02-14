package com.mohamed.CurrencyConverterAPP.webservice.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConversionResponseModel {
    @SerializedName("base_code")
    private String baseCode;
    @SerializedName("conversion_rate")
    private Double conversionRate;
    @SerializedName("conversion_result")
    private Double conversionResult;
    @Expose
    private String documentation;
    @Expose
    private String result;
    @SerializedName("target_code")
    private String targetCode;
    @SerializedName("terms_of_use")
    private String termsOfUse;
    @SerializedName("time_last_update_unix")
    private Long timeLastUpdateUnix;
    @SerializedName("time_last_update_utc")
    private String timeLastUpdateUtc;
    @SerializedName("time_next_update_unix")
    private Long timeNextUpdateUnix;
    @SerializedName("time_next_update_utc")
    private String timeNextUpdateUtc;

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Double getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(Double conversionResult) {
        this.conversionResult = conversionResult;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public void setTermsOfUse(String termsOfUse) {
        this.termsOfUse = termsOfUse;
    }

    public Long getTimeLastUpdateUnix() {
        return timeLastUpdateUnix;
    }

    public void setTimeLastUpdateUnix(Long timeLastUpdateUnix) {
        this.timeLastUpdateUnix = timeLastUpdateUnix;
    }

    public String getTimeLastUpdateUtc() {
        return timeLastUpdateUtc;
    }

    public void setTimeLastUpdateUtc(String timeLastUpdateUtc) {
        this.timeLastUpdateUtc = timeLastUpdateUtc;
    }

    public Long getTimeNextUpdateUnix() {
        return timeNextUpdateUnix;
    }

    public void setTimeNextUpdateUnix(Long timeNextUpdateUnix) {
        this.timeNextUpdateUnix = timeNextUpdateUnix;
    }

    public String getTimeNextUpdateUtc() {
        return timeNextUpdateUtc;
    }

    public void setTimeNextUpdateUtc(String timeNextUpdateUtc) {
        this.timeNextUpdateUtc = timeNextUpdateUtc;
    }

}
