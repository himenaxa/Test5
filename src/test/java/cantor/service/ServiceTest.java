package cantor.service;

import cantor.exception.BadCurrency;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ServiceTest {

    private Service service;

    @Before
    public void init() {
        service = new Service();
    }

    @Test
    public void shouldNotThrowNullAsAResult() throws IOException {
        assertNotNull(service.exchange("USD", "PLN", 1.0));
    }


    @Test(expected = BadCurrency.class)
    public void shouldThrowBadCurrencyExceptionWhenNameOfCurrencyFromNameIsWrong() throws IOException {
        service.exchange("USDD", "PLN", 10);
    }
    @Test(expected = BadCurrency.class)
    public void shouldThrowBadCurrencyExceptionWhenNameOfCurrencyToNameIsWrong() throws IOException {
        service.exchange("USDD", "PLNN", 10);
    }
}