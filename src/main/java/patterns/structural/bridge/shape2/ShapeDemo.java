package patterns.structural.bridge.shape2;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.05.2020
 **/
public class ShapeDemo {

    public static void main(String[] args) {

        final Color blue = new Blue();

        final Shape square = new Square(blue);

        final Color red = new Red();

        final Shape circle = new Circle(red);

        square.applyColor();
        circle.applyColor();
    }
}
