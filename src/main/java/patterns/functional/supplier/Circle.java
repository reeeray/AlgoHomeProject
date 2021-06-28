package patterns.functional.supplier;

import java.awt.Color;

/**
 * Created by Shein G.A. at 01.08.20
 **/
public class Circle {

    private Color color;

    public Circle () {
        this.color = Color.CYAN;
    }
    public Circle(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Rectangle[color = " + color + "]";
    }
}
