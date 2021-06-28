package patterns.functional.registry;

import patterns.functional.supplier.Factory;

/**
 * Created by Shein G.A. at 01.08.20
 **/
public class SwitchRegistry {

    public Factory<? extends Shape> buildShapeFactory(final String shape) {

        switch (shape) {
            case "square" : return () -> new Square();
            case "rectangle" : return () -> new Rectangle();
            case "triangle" : return () -> new Triangle();
            default:
                throw new IllegalArgumentException("Unknown shape " + shape);
        }
    }
}
