package com.mohamed.CurrencyConverterAPP.webservice.resource;

import com.mohamed.CurrencyConverterAPP.cli.ConversionEntry;
import com.mohamed.CurrencyConverterAPP.webservice.service.CurrencyConverter;
import com.mohamed.CurrencyConverterAPP.webservice.entity.ConversionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionCurrencyAPI {

    private CurrencyConverter currencyConverter;

    @Autowired
    public void setCurrencyConverter(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    @GetMapping("/currencyConversion/{value}/{sourceCurrency}/{targetCurrency}")
    public ResponseEntity<ConversionResponse> convertCurrencyByAmountAndTargetCurrency(@PathVariable Double value,
                                                                                       @PathVariable String sourceCurrency,
                                                                                       @PathVariable String targetCurrency) {
        ConversionEntry conversion = new ConversionEntry(value, sourceCurrency);
        try {
            Double resultValue = currencyConverter.convert(conversion, targetCurrency);
            ConversionResponse responseModel = new ConversionResponse(resultValue, targetCurrency);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
