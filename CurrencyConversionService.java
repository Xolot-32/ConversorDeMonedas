public class CurrencyConversionService {
    private ExchangeRateService exchangeRateService;

    public CurrencyConversionService(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    public double convert(double amount, Currency fromCurrency, Currency toCurrency) {
        double fromRate = exchangeRateService.getExchangeRate(fromCurrency);
        double toRate = exchangeRateService.getExchangeRate(toCurrency);
        return amount * (toRate / fromRate);
    }
}