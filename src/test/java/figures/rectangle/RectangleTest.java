package figures.rectangle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {
    private Rectangle rectangle;

    @Before
    public void init() {
        rectangle = new Rectangle(10, 20);
    }

    @Test
    public void shouldReturnCorrectArea() {
        double area = 10 * 20;
        assertEquals(area, rectangle.getArea(), 0.1);
    }

    @Test
    public void shouldReturnCorrectPerimeter() {
        double area = 10 * 2 + 20 * 2;
        assertEquals(area, rectangle.getPerimeter(), 0.1);
    }

//    @Test
//    public void shouldReturnCorrectType() {
//        assertEquals(Type.RECTANGLE, rectangle.getType());
//    }

}