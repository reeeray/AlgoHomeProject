package patterns.functional.visitor;

import java.util.function.Consumer;

/**
 * Created by Shein G.A. at 02.08.20
 **/
public class VisitorDemo {

    public static void main(String[] args) {
        final Car car = new Car();
        final Engine engine = new Engine();
        final Body body = new Body();

        Consumer<VisitorBuilder<String>> consumer = Visitor.<Car, String>forType(Car.class).execute((Car c) -> "Visiting car " + c)
                                                                .forType(Engine.class).execute((Engine e) -> "Visiting engine " + e)
                                                                .forType(Body.class).execute((Body b) -> "Visiting body " + b);

        Visitor<String> visitor = Visitor.of(consumer);

        final String visitedEngine = visitor.visit(engine);
        System.out.println("Engine : " + visitedEngine);

        final String visitedCar = visitor.visit(car);
        System.out.println("Car : " + visitedCar);

        final String visitedBody = visitor.visit(body);
        System.out.println("Body : " + visitedBody);
    }
}
