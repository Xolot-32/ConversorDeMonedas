import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConversionRecord {
    private final Currency fromCurrency;
    private final Currency toCurrency;
    private final double amount;
    private final double result;
    private final LocalDateTime timestamp;

    public ConversionRecord(Currency fromCurrency, Currency toCurrency, double amount, double result) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.result = result;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("[%s] %.2f %s = %.2f %s",
                timestamp.format(formatter), amount, fromCurrency, result, toCurrency);
    }
}