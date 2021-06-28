package patterns.functional.function;

import java.util.Objects;

/**
 * Simplified version of Function from functional interface
 * Created by Shein G.A. at 26.07.20
 **/
@FunctionalInterface
public interface Function<T, R> {

    R apply(T t);

    default <V> Function<T, V> andThen(Function<R, V> other) {
        Objects.requireNonNull(other);
        return (T t) -> other.apply(this.apply(t));
    }

    default <V> Function<V, R> compose(Function<V, T> other) {
        Objects.requireNonNull(other);
        return (V v) -> this.apply(other.apply(v));
    }

    static <T> Function<T, T> identity() {
        return t -> t;
    }

}
