package figures.square;

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
public class Square extends Shape {
    private double side;

    @JsonIgnore
    @Override
    public double getArea() {
        return side * side;
    }

    @JsonIgnore
    @Override
    public double getPerimeter() {
        return 4 * side;
    }


}
