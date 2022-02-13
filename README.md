# CurrencyConverterApp
this app is very useful for currency conversions and could be used either through CLI or through Restful API

## 1. Building and running using CLI
* run APP.class with the following parameter.  ie: --file currencies.json --target-currency EUR.
* please note:  if no input file existed then fallback function will be activated and default file (currencies.json) will act as input file 
* please see CLI-CONFIG.jpg



## 2. Building and running using Restful API
* start server : run CurrencyConverterAppApplication.class
* use Postman to comsume the following API: 
   GET `/currencyConversion/{value}/{sourceCurrency}/{targetCurrency}` :return `conversionResult` and `targetCurrency`
* see POSTMAN-CONFIG.jpg

## 3. Resources

  1. [publicly available service for currency exchange](https://www.exchangerate-api.com/docs/pair-conversion-requests)
  2. [ rich command line interface](https://picocli.info/)
  3. [Gson serialization and deserialization](https://github.com/google/gson)
  4. [Spring initializer](https://start.spring.io/)


## answers on  open discussion questions
*  parsing too big input file ( 2 TB) input file consume alot of resources and it could break the app 
* if the input file has one malformed JSON line towards the 
  end of the file: RuntimeException will be thrown with printing message of `file parsing error`
  
*  in case the upstream exchange rate service is down : possible solution is caching values of `baseCurrency` and `amount` . 
   also following Circuit breaker pattern would be a quick solution retrying reaching the failed external service again.
