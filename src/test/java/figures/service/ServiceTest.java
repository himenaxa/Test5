package figures.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import figures.circle.Circle;
import figures.figure.Shape;
import figures.rectangle.Rectangle;
import figures.square.Square;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@JsonTest

public class ServiceTest {

    private Circle circle;
    private Rectangle rectangle;
    private Square square1;
    private Square square2;
    private Service service;

    @Before
    public void init() {
        circle = new Circle(10);
        rectangle = new Rectangle(10, 20);
        square1 = new Square(100);
        square2 = new Square(99);
        service = new Service();
    }

    @Test
    public void shouldReturnFigureWithTheBiggestArea() {
        assertEquals(square1, service.getFigureWithBiggestArea(Arrays.asList(circle, rectangle, square1, square2)));
    }

    @Test
    public void shouldReturnChosenFigureWithTheBiggestArea() {
        assertEquals(square1, service.getChosenFigureWithTheBiggestPerimeter(Arrays.asList(circle, rectangle, square1, square2), Square.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionToGetFigureWithBiggestAreaWhenUseEmptyList() {
        service.getFigureWithBiggestArea(Collections.emptyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionToGetChosenFigureWithTheBiggestPerimeterWhenUseEmptyList() {
        service.getChosenFigureWithTheBiggestPerimeter(Collections.emptyList(), Circle.class);
    }

    @Test
    public void shouldCorrectlyWriteObjectsToJsonFile() throws IOException {
        service.writeFiguresToJson(Arrays.asList(circle, rectangle, square1, square2), "test");
        List<Shape> result = new ObjectMapper().readValue(new File("C:\\Users\\User\\IdeaProjects\\zadanieOdWaldemara\\testFigures.json"), new TypeReference<List<Shape>>() {
        });
        assertEquals(Arrays.asList(circle, rectangle, square1, square2), result);
    }


    @Test
    public void shouldCorrectlyReadObjectFromFile() throws IOException {
        Shape s = service.readFiguresFromJson("C:\\Users\\User\\IdeaProjects\\zadanieOdWaldemara\\testFigures.json").get(0);
        assertEquals(s, circle);
    }


}