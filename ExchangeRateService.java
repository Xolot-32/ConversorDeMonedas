import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ExchangeRateService {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/4ddc193566f7d74e6bc80789/latest/USD";
    private Map<Currency, Double> exchangeRates = new HashMap<>();

    public void fetchExchangeRates() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                parseJsonResponse(response.body());
            } else {
                System.out.println("Error al obtener las tasas de cambio.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseJsonResponse(String jsonResponse) {
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

        for (Currency currency : Currency.values()) {
            if (rates.has(currency.name())) {
                exchangeRates.put(currency, rates.get(currency.name()).getAsDouble());
            }
        }
    }

    public double getExchangeRate(Currency currency) {
        return exchangeRates.getOrDefault(currency, 1.0);
    }
}