package com.mohamed.CurrencyConverterAPP.cli;

import com.google.gson.annotations.SerializedName;

public class ConversionEntry {

    public ConversionEntry() {
    }

    public ConversionEntry(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    @SerializedName("value")
    public double value;
    @SerializedName("currency")
    public String currency;
}
