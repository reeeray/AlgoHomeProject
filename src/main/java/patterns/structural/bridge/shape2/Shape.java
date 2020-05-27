package patterns.structural.bridge.shape2;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.05.2020
 **/
public abstract class Shape {

    protected Color color;

    public Shape(final Color color) {
        this.color = color;
    }

    abstract public void applyColor();
}
