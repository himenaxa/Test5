package cantor.reader;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ReaderTest {
    private Reader reader;

    @Before
    public void init() {
        reader = new Reader();
    }

    @Test
    public void textFromApiShouldNotBeNull() throws IOException {
        assertNotNull(reader.readApi("EUR", "USD", 1.0));
    }

}