package patterns.functional.registry;

import patterns.functional.supplier.Factory;

import java.util.function.Consumer;

/**
 * Created by Shein G.A. at 01.08.20
 **/
public class RegistryDemo {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        final SwitchRegistry switchRegistry = new SwitchRegistry();
        final Factory<Shape> factory = (Factory<Shape>)switchRegistry.buildShapeFactory("rectangle");

        System.out.println(factory.getInstance());


        final Consumer<Builder<Shape>> rectangleConsumer = builder -> builder.register("rectangle", Rectangle::new);
        final Consumer<Builder<Shape>> triangleConsumer = builder -> builder.register("triangle", Triangle::new);
        final Consumer<Builder<Shape>> initializer = rectangleConsumer.andThen(triangleConsumer);
        final Registry registry = Registry.createRegistry(initializer, (s) -> {throw new IllegalArgumentException("Unknown shape " + s);});

        final Factory<Rectangle> buildRectangleFactory = (Factory<Rectangle>)registry.buildShapeFactory("rectangle");
        final Rectangle rectangle = buildRectangleFactory.getInstance();
        System.out.println("Rectangle = " + rectangle);

        final Factory<Triangle> buildTriangleFactory = (Factory<Triangle>)registry.buildShapeFactory("triangle");
        final Triangle triangle = buildTriangleFactory.getInstance();
        System.out.println("Triangle = " + triangle);

    }
}
