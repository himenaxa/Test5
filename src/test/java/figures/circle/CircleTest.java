package figures.circle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    private Circle circle;

    @Before
    public void init() {
        circle = new Circle(10);
    }

    @Test
    public void shouldReturnCorrectArea() {
        double area = Math.PI * 10 * 10;
        assertEquals(area, circle.getArea(), 0.1);
    }

    @Test
    public void shouldReturnCorrectPerimeter() {
        double area = Math.PI * 10 * 2;
        assertEquals(area, circle.getPerimeter(), 0.1);
    }



}