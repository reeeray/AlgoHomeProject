import books.GreedyAlgorithms;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * Created by Shein G.A. at 27.04.20
 **/
public class GreedyAlgosTest {

    @Test
    public void testBiggestNumber() {
        final int [] numbers = {5, 3, 7, 1, 9, 9};

        assertEquals(997531, GreedyAlgorithms.maxNumber(numbers));
    }

    @Test
    public void testMinStops() {

        final int[] stops = {0, 200, 375, 550, 750, 950};

        assertEquals(2, GreedyAlgorithms.minStops(stops, 400));
    }

    @Test
    public void testFractionalKnapsack() {
        final GreedyAlgorithms.Stuff stuff1 = new GreedyAlgorithms.Stuff(4, 20);
        final GreedyAlgorithms.Stuff stuff2 = new GreedyAlgorithms.Stuff(3, 18);
        final GreedyAlgorithms.Stuff stuff3 = new GreedyAlgorithms.Stuff(2, 14);

        final GreedyAlgorithms.Stuff[] stuffs = { stuff1, stuff2, stuff3 };

        assertEquals(42, GreedyAlgorithms.getOPtimalValues(stuffs, 7));
    }
}
