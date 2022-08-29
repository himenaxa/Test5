package cantor.service;

import cantor.exception.BadCurrency;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class Service {

    public Double exchange(String currencyFrom, String currencyTo, double amount) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = "https://api.apilayer.com/exchangerates_data/";
        Request request = new Request.Builder()
                .url(url + "convert?to=" + currencyTo + "&from=" + currencyFrom + "&amount=" + amount)
                .addHeader("apikey", "BnW7ENBiBLBknHJSmAIOb4xax9pdohFL")
                .get()
                .build();
        Response response = client.newCall(request).execute();
        ObjectMapper om = new ObjectMapper();
        JsonNode read = om.readTree(response.body().string());
        if (read.get("error") != null) {
            throw new BadCurrency("You have entered bad name of currency");
        }
        return read.get("result").asDouble();
    }


}
