package patterns.functional.consumer;

import java.util.Objects;

/**
 * Simply version of Consumer Functional Interface which is invoking method with argument
 * Created by Shein G.A. at 26.07.20
 **/
@FunctionalInterface
public interface Consumer <T>{

    void accept(T t);

    default Consumer<T> andThen(Consumer<T> other) {
        Objects.requireNonNull(other);
        return (T t) -> {
            this.accept(t);
            other.accept(t);
        };
    }
}
