package patterns.structural.decorator;

/**
 * Concrete Decorator
 * User : Shein G.A.{@reeeray}
 * Date : 27.05.2020
 **/
public class MeatDecorator extends SandwichDecorator {

    public MeatDecorator(final Sandwich customSandwich) {
        super(customSandwich);
    }

    public String make() {
        return customSandwich.make() + addMeat();
    }

    private String addMeat() {
        return " + hamon";
    }
}
