package patterns.structural.decorator;

/**
 * Decorator
 * User : Shein G.A.{@reeeray}
 * Date : 27.05.2020
 **/
public abstract class SandwichDecorator implements Sandwich {

    protected Sandwich customSandwich;

    public SandwichDecorator(final Sandwich customSandwich) {
        this.customSandwich = customSandwich;
    }

    public String make() {
        return customSandwich.make();
    }

}
