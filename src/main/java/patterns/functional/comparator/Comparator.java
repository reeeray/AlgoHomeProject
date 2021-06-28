package patterns.functional.comparator;

import patterns.functional.function.Function;

import java.util.Objects;

/**
 * Simplified version of Comparator from JDK
 * Created by Shein G.A. at 26.07.20
 **/
@FunctionalInterface
public interface Comparator <T> {

    int compare(T t1, T t2);

    default <U extends Comparable<U>> Comparator<T> thenComparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        final Comparator<T> other = comparing(keyExtractor);
        return this.thenComparing(other);
    }

    default Comparator<T> thenComparing(Comparator<T> other) {
        Objects.requireNonNull(other);
        return (T t1, T t2) -> {
            final int compRes = this.compare(t1, t2);
            return compRes == 0 ? other.compare(t1, t2) : compRes;
        };
    }
    default Comparator<T> reversed() {
        return (t1, t2) -> this.compare(t2, t1);
    }

    static <T, U extends Comparable<U>> Comparator<T> comparing(Function<T, U> keyExctractor) {
        Objects.requireNonNull(keyExctractor);
        return (p1, p2) -> {
            final U u1 = keyExctractor.apply(p1);
            final U u2 = keyExctractor.apply(p2);
            return u1.compareTo(u2);
            //keyExctractor.apply(p1).compareTo(keyExctractor.apply(p2));
        };
    }
}
