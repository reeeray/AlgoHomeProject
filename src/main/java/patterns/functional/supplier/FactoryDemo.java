package patterns.functional.supplier;

import java.awt.*;
import java.util.List;

/**
 * Factory based on Supplier
 * Created by Shein G.A. at 01.08.20
 **/
public class FactoryDemo {

    public static void main(String[] args) {
        //final Supplier<Rectangle> factory = () -> new Rectangle();
        //final Factory<Rectangle> factory = () -> new Rectangle();

        final Factory<Circle> factory = Factory.createFactory(Circle::new, Color.RED);
        final Factory<Circle> factory2 = Factory.createFactory(Circle::new);

        final Circle circle = factory.getInstance();

        System.out.println("Rectangle = " + circle);

        final List<Circle> listOf5Circles = factory.create5();
        System.out.println("List = " + listOf5Circles);

    }
}
