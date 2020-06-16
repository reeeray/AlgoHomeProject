package patterns.structural.decorator;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.05.2020
 **/
public class DressingDecorator extends SandwichDecorator {

    public DressingDecorator(final Sandwich customSandwich) {
        super(customSandwich);
    }

    public String make() {
        return customSandwich.make() + addDressing();
    }

    private String addDressing() {
        return " + mustard";
    }
}
