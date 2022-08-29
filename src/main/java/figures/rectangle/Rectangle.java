package figures.rectangle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import figures.figure.Shape;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode (callSuper = false)
@ToString
public class Rectangle extends Shape {
    private double side1;
    private double side2;

    @JsonIgnore
    @Override
    public double getArea() {
        return side1 * side2;
    }

    @JsonIgnore
    @Override
    public double getPerimeter() {
        return 2 * side2 + 2 * side1;
    }


}
