package patterns.structural.bridge.shape2;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.05.2020
 **/
public class Square extends Shape {

    public Square(final Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        color.applyColor();
    }


}
