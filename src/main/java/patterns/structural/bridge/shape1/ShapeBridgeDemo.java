package patterns.structural.bridge.shape1;

/**
 * The problem is that it can't grow with us. Each time when we want to add ne color we need to code it.
 * Even worth if we want to add new Shape. So we need to use composition approach.
 * Orthogonal problem here.
 * User : Shein G.A.{@reeeray}
 * Date : 26.05.2020
 **/
public class ShapeBridgeDemo {

    public static void main(String[] args) {
        Circle circle = new BlueCircle();

        Square square = new RedSquare();

        circle.applyColor();
        square.applyColor();
    }
}
