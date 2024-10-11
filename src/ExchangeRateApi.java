import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApi {
    private static final String API_KEY = "017a185d1f610a0b5f7407f3";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public InformacionMoneda getExchangeRates() throws IOException, InterruptedException {
        String url = BASE_URL + API_KEY + "/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
        JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");

        return new InformacionMoneda(conversionRates);
    }
}