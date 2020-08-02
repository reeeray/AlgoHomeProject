package patterns.functional.visitor;

import java.util.function.Function;

/**
 * Created by Shein G.A. at 02.08.20
 **/
public interface VisitorBuilder<R> {

    <T> void registry(Class<T> type, Function<T, R> function);
}
