package cantor.reader;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Objects;

public class Reader {

    public String readApi(String currencyFrom, String currencyTo, double amount) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = "https://api.apilayer.com/exchangerates_data/";
        Request request = new Request.Builder()
                .url(url + "convert?to=" + currencyTo + "&from=" + currencyFrom + "&amount=" + amount)
                .addHeader("apikey", "BnW7ENBiBLBknHJSmAIOb4xax9pdohFL")
                .get()
                .build();
        Response response = client.newCall(request).execute();
        return Objects.requireNonNull(response.body()).string();
    }

}
