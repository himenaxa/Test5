package figures;

import figures.circle.Circle;
import figures.figure.Shape;
import figures.rectangle.Rectangle;
import figures.service.Service;
import figures.square.Square;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Circle c1 = new Circle(10);
        Rectangle r1  = new Rectangle(10,20);
        Square s1 = new Square(100);
        Square s2 = new Square(99);

        List<Shape> shapeList = Arrays.asList(c1,r1,s1,s2);

        Service service = new Service();

        System.out.println(service.getFigureWithBiggestArea(shapeList));
        System.out.println(service.getChosenFigureWithTheBiggestPerimeter(shapeList, Square.class));

        service.writeFiguresToJson(shapeList,"src/main/resources/");
       System.out.println(service.readFiguresFromJson("C:\\Users\\User\\IdeaProjects\\zadanieOdWaldemara\\src\\main\\resources\\Figures.json"));

    }
}
