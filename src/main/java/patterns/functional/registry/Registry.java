package patterns.functional.registry;

import patterns.functional.supplier.Factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by Shein G.A. at 01.08.20
 **/
public interface Registry {

    Factory<? extends Shape> buildShapeFactory(final String shape);

    //very safety, robust and very performance implementation because map is local variable, nobody can't access it even with reflection
    static Registry createRegistry(final Consumer<Builder<Shape>> consumer, Function<String, Factory<Shape>> errorHandler) {
        final Map<String, Factory<Shape>> storage = new HashMap<>();
        final Builder<Shape> builder = (shape, factory) -> storage.put(shape, factory);
        consumer.accept(builder);
        //return shape -> storage.get(shape);
        //return shape -> storage.getOrDefault(shape, () -> {throw new IllegalArgumentException("Unknown shape " + shape);});
        return shape -> storage.computeIfAbsent(shape, errorHandler);
    }
}
