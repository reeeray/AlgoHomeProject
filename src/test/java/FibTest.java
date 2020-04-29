/**
 * Created by Shein G.A. at 26.04.20
 **/

import books.Fibonacci;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibTest {

    public static final int N = 100;

    @Test
    public void testSlowFib() {
        assertEquals(55, Fibonacci.getSlowFib(10));
        //executed for 50 000 years
        //assertEquals(3736710778780434371L, Fibonacci.getFastFib(N));
    }

    @Test
    public void testMemFib() {
        final long[] storage = new long[N + 1];
        Arrays.fill(storage, -1);

        assertEquals(3736710778780434371L, Fibonacci.getMemFib(N, storage));
    }

    @Test
    public void testFastFin() {
        assertEquals(3736710778780434371L, Fibonacci.getFastFib(N));
    }
}
