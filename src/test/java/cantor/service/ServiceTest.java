package cantor.service;

import cantor.exception.BadCurrency;
import cantor.reader.Reader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.Assert.*;

public class ServiceTest {

    private Service service;

    @Mock
    private Reader readerMock;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        service = new Service(readerMock);
    }

    @Test
    public void shouldReturnCorrectlyAmount() throws IOException {
        String stringFromApi = "{\"result\": 4.73006}";
        Mockito.when(readerMock.readApi(Mockito.anyString(),Mockito.anyString(),Mockito.anyDouble())).thenReturn(stringFromApi);
        double result = service.exchange(Mockito.anyString(),Mockito.anyString(),Mockito.anyDouble());
        assertEquals(4.73006,result,0.00001);
    }


    @Test(expected = BadCurrency.class)
    public void shouldThrowBadCurrencyExceptionWhenNameOfCurrencyIsNotCorrectly() throws IOException {
        String stringFrommApi = "{\"error\": {\"code\": \"invalid_from_currency\",\"message\": \"(....)\"}}";
        Mockito.when(readerMock.readApi(Mockito.anyString(),Mockito.anyString(),Mockito.anyDouble())).thenReturn(stringFrommApi);
        service.exchange(Mockito.anyString(),Mockito.anyString(),Mockito.anyDouble());
    }

}