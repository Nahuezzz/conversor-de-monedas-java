import com.google.gson.JsonObject;

public class InformacionMoneda {
    private final JsonObject rates;

    public InformacionMoneda(JsonObject rates) {
        this.rates = rates;
    }

    public double getRate(String codigoMoneda) {
        return rates.get(codigoMoneda).getAsDouble();
    }

}