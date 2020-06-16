package patterns.structural.decorator;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.05.2020
 **/
public class DecoratorDemo {

    public static void main(String[] args) {
        final Sandwich sandwich = new DressingDecorator(new MeatDecorator(new SimpleSandwich()));

        System.out.println(sandwich.make());
    }
}
