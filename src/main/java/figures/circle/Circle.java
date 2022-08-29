package figures.circle;

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
public class Circle extends Shape {
    private double radius;

    @JsonIgnore
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @JsonIgnore
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
