package com.mohamed.CurrencyConverterAPP.cli;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

import com.google.gson.Gson;
import com.mohamed.CurrencyConverterAPP.webservice.service.CurrencyConverter;
import picocli.CommandLine;

@CommandLine.Command(name = "Convert")
public class CLI implements Callable<Integer> {
    public static final String FALLBACK_FILENAME = "currencies.json";

    @CommandLine.Option(names = { "-f", "--file" }, description = "Input file ..")
    private String inputFile = FALLBACK_FILENAME;

    @CommandLine.Option(names = { "-t", "--target-currency" }, description = "Target currency ...")
    private String targetCurrency = "EUR";

    private CurrencyConverter currencyConverter = new CurrencyConverter();

    @Override
    public Integer call() throws Exception {
        convertAndPrint(inputFile, targetCurrency);
        return 0;
    }

    private void convertAndPrint(String inputFileName, String targetCurrency) {
        try {
            //get sourceCurrency and amount from input file
            InputModel inputModel = readJsonFile(inputFileName);
            printExchangeRates(targetCurrency, inputModel);
        } catch (RuntimeException ex) {
            System.out.println("file parsing error");
        }

    }

    private InputModel readJsonFile(String inputFileName) {

        BufferedReader fileBufferReader = null;
        InputModel inputModel = null;
        try {

            String sCurrentLine;

            fileBufferReader = new BufferedReader(new FileReader(inputFileName));

            StringBuffer jsonBuffer = new StringBuffer();

            while ((sCurrentLine = fileBufferReader.readLine()) != null) {

                jsonBuffer.append(sCurrentLine);
            }
            inputModel = new Gson().fromJson(jsonBuffer.toString(), InputModel.class);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileBufferReader != null) {
                    fileBufferReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
        return inputModel;
    }

    private void printExchangeRates(final String targetCurrency, final InputModel inputModel) {
        if (inputModel != null && inputModel.data != null && inputModel.data.size() != 0) {
            for (ConversionEntry entry : inputModel.data) {
                try {
                    double conversionResult = currencyConverter.convert(entry, targetCurrency);

                    ConversionEntry conversionEntry = new ConversionEntry(conversionResult, targetCurrency);
                    String jsonOutput = new Gson().toJson(conversionEntry);
                    System.out.println(jsonOutput);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
