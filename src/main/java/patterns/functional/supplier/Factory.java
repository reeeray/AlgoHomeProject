package patterns.functional.supplier;

import java.awt.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Shein G.A. at 01.08.20
 **/
public interface Factory<T> extends Supplier<T> {

    default T getInstance() {
        return get();
    }

    default List<T> create5() {
        return IntStream.range(0, 5).mapToObj(index -> getInstance()).collect(Collectors.toList());
    }

    static <T> Factory<T> createFactory (final Supplier<T> supplier) {
        return () -> supplier.get();
    }

    //simple way to create singleton factory
    //it's very secure because even using reflection you can't access this variable because it's local
    static <T> Factory createSingletonFactory(final Supplier<T> supplier) {
        final T singleton = supplier.get();
        return () -> singleton;
    }

    //Fundamental operation of functional programming which called PowerShell application
    static <P, T> Factory<T> createFactory(final Function<P, T> constructor, final P parameter) {
        return () -> constructor.apply(parameter);
    }
}
