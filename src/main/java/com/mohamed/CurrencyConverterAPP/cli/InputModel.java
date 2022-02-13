package com.mohamed.CurrencyConverterAPP.cli;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class InputModel {

    @SerializedName("data")
    public List<ConversionEntry> data;

}
