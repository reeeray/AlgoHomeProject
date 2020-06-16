package patterns.structural.decorator;

/**
 * Concrete Component on the UML diagram
 * User : Shein G.A.{@reeeray}
 * Date : 27.05.2020
 **/
public class SimpleSandwich implements Sandwich {
    @Override
    public String make() {
        return "Bread";
    }
}
