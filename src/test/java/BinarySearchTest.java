/**
 * Created by Shein G.A. at 28.04.20
 **/

import books.BinarySearchAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BinarySearchTest {

    private static final int[] testArray = new int[] {-13, -1, 3, 4, 5, 6, 7, 7, 13, 17, 24, 27, 33, 95};
    @Test
    public void binarySearchTest() {
        assertEquals(8, BinarySearchAlgorithm.binarySearch(testArray, 13));
    }

    @Test
    public void binarySearchRecursiveTest() {
        assertEquals(8, BinarySearchAlgorithm.binarySearchRecusrsion(testArray, 13, 0, testArray.length - 1));
    }
}
