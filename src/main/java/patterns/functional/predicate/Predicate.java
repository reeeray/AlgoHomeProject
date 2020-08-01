package patterns.functional.predicate;

import java.util.Objects;

/**
 * Simple version of Functional Interface Predicate
 * Created by Shein G.A. at 26.07.20
 **/
@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> and(Predicate<T> other) {
        Objects.requireNonNull(other);
        return (T t) -> this.test(t)&&other.test(t);
    }

    default Predicate<T> negate() {
        return (T t) -> !this.test(t);
    }
}
