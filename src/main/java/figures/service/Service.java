package figures.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import figures.figure.Shape;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Service {
    public Shape getFigureWithBiggestArea(List<Shape> figures) {
        return Optional.ofNullable(figures)
                .orElse(Collections.emptyList())
                .stream()
                .max(Comparator.comparing(Shape::getArea))
                .orElseThrow(() -> new IllegalArgumentException("error"));
    }


    public Shape getChosenFigureWithTheBiggestPerimeter(List<Shape> figures, Class type) {
        return Optional.ofNullable(figures)
                .orElse(Collections.emptyList())
                .stream()
                .filter(f -> f.getClass().equals(type))
                .max(Comparator.comparing(Shape::getPerimeter))
                .orElseThrow(() -> new IllegalArgumentException("error"));
    }

    public void writeFiguresToJson(List<Shape> figureList, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path + "Figures.json"), figureList);
    }

    public List<Shape> readFiguresFromJson(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(path), new TypeReference<List<Shape>>() {
        });
    }


}
