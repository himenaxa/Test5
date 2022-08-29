package figures.square;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {
    private Square square;

    @Before
    public void init() {
        square = new Square(10);
    }

    @Test
    public void shouldReturnCorrectArea() {
        double area = 10 * 10;
        assertEquals(area, square.getArea(), 0.1);
    }

    @Test
    public void shouldReturnCorrectPerimeter() {
        double area = 10 * 4;
        assertEquals(area, square.getPerimeter(), 0.1);
    }


}