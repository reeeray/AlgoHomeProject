package patterns.functional.validator;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by Shein G.A. at 02.08.20
 **/
public interface Validator {

    ValidatorSupplier on(Person person);

    default Validator thenValidate(Predicate<Person> predicate, String errorMessage) {
        return p -> {
            try {
                on(p).validate();
                if(predicate.test(p)) {
                    return () -> p;
                } else {
                    return () -> {
                        final ValidationException common = new ValidationException("The object is not valid");
                        common.addSuppressed(new IllegalArgumentException(errorMessage));
                        throw common;
                    };
                }
            } catch (final ValidationException e) {
                if(predicate.test(p))
                    return () -> {throw e;};
                else {
                    e.addSuppressed(new IllegalArgumentException(errorMessage));
                    return () -> {throw e;};
                }
            }
        };
    }

    static Validator validate(Predicate<Person> predicate, String errorMessage) {
        return p -> {
            if(predicate.test(p))
                return () -> p;
            else
                return () -> {
                    final ValidationException common = new ValidationException("The object is not valid");
                    common.addSuppressed(new IllegalArgumentException(errorMessage));
                    throw common;
                };
        };
    }

    interface ValidatorSupplier extends Supplier<Person> {

        default Person validate() {
            return get();
        }
    }

    static class ValidationException extends RuntimeException {
        public ValidationException(final String message) {
            super(message);
        }
    }
}
