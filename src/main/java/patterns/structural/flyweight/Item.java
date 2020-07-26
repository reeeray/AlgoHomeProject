package patterns.structural.flyweight;

/**
 * Instance of this class will be the FlyWeights
 * User : Shein G.A.{@reeeray}
 * Date : 19.07.2020
 **/
public class Item {

    private final String name;

    public Item(final String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
