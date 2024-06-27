public class CurrencyConverter {
    public static void main(String[] args) {
        ExchangeRateService exchangeRateService = new ExchangeRateService();
        CurrencyConversionService conversionService = new CurrencyConversionService(exchangeRateService);
        UserInterface ui = new UserInterface(conversionService);

        exchangeRateService.fetchExchangeRates();
        ui.start();
    }
}