package leetcode.pointers;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.08.2025
 **/
public class FruitsIntoBasketsII_3477 {

    public static void main(String[] args) {
        numOfUnplacedFruits(new int[] {4, 2, 5}, new int[] {3, 5, 4});
    }

    //Time O(n^2) and Space O(1)
    public static int numOfUnplacedFruits(final int[] fruits, final int[] baskets) {
        int res = 0;
        int left = 0;
        for(final int fruit : fruits) {
            if(baskets[left] >= fruit) {
                left++;
                continue;
            }
            boolean isRemain = true;
            for(int i = left + 1; i < baskets.length; i++) {
                if(baskets[i] == 0) {
                    continue;
                }
                if(baskets[i] >= fruit) {
                    baskets[i] = 0;
                    isRemain = false;
                    break;
                }
            }
            if(isRemain) {
                res++;
            }
        }
        return res;
    }
}
