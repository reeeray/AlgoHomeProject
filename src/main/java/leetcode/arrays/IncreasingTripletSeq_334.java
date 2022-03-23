package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.03.2022
 **/
public class IncreasingTripletSeq_334 {

    public static void main(String[] args) {
        final int[] arr = {20, 100, 10, 12, 5, 13};

        assert isIncrTriplet(arr);


    }

    public static boolean isIncrTriplet(final int[] nums) {
        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MIN_VALUE;

        for (int n : nums) {
            if (n <= firstSmallest)
                firstSmallest = n;
            else if (n <= secondSmallest)
                secondSmallest = n;
            else
                return true;
        }
        return false;
    }
}
