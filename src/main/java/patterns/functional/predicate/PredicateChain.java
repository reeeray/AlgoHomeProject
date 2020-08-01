package patterns.functional.predicate;

/**
 * Created by Shein G.A. at 26.07.20
 **/
public class PredicateChain {

    public static void main(String[] args) {
        final Predicate<String> p1 = s -> s!=null;
        final Predicate<String> p2 = s -> s.isEmpty();

        final Predicate<String> p = p1.and(p2.negate());

        assert !p.test(null);
        assert  !p.test("");
        assert p.test("Chain of Predicates");
    }
}
