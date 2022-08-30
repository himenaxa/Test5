package cantor.service;


import cantor.exception.BadCurrency;
import cantor.reader.Reader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Service {
    private Reader reader;

    public Service(Reader reader) {
        this.reader = reader;
    }

    public double exchange(String currencyFrom, String currencyTo, double amount) throws IOException {
        String response = reader.readApi(currencyTo, currencyFrom, amount);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode read = objectMapper.readTree(response);
        if (read.get("error") != null) {
            throw new BadCurrency(read.get("error").get("message").asText());
        }
        return read.get("result").asDouble();
    }


}
