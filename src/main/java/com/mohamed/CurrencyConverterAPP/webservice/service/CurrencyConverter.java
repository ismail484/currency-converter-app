package com.mohamed.CurrencyConverterAPP.webservice.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.mohamed.CurrencyConverterAPP.cli.ConversionEntry;
import com.mohamed.CurrencyConverterAPP.webservice.models.ConversionResponseModel;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverter {

    public static final String API_KEY = "8fed297181232ffabd78edc8";

    public double convert(ConversionEntry entry, String targetCurrency) throws Exception {
        String path = "https://v6.exchangerate-api.com/v6/"
                      + API_KEY
                      + "/pair/"
                      + entry.currency
                      + "/"
                      + targetCurrency
                      + "/"
                      + entry.value;

        // Making Request
        URL url = new URL(path);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        int responseStatusCode = request.getResponseCode();

        if (responseStatusCode == HttpURLConnection.HTTP_OK) {
            String inputLine;
            BufferedReader dataInputStream = new BufferedReader((new InputStreamReader(request.getInputStream())));
            StringBuilder response = new StringBuilder();

            while ((inputLine = dataInputStream.readLine()) != null) {
                response.append(inputLine);
            }
            dataInputStream.close();

            ConversionResponseModel responseModel =
                new Gson().fromJson(response.toString(), ConversionResponseModel.class);
            return responseModel.getConversionResult();
        } else {
            throw new IOException("Conversion was not successful");
        }

    }

}
