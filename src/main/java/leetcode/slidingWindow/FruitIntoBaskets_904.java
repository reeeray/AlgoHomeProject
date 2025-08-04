package leetcode.slidingWindow;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.08.2025
 **/
public class FruitIntoBaskets_904 {

    public static void main(String[] args) {
        totalFruit(new int[] {0, 1, 2, 2});
    }

    public static int totalFruit(final int[] fruits) {
        int occ1 = -1, occ2 = -1, freq1 = 0, freq2 = 0;
        int left = 0, right = 0;
        int res = 0;
        while (right < fruits.length) {
            if(occ1 == fruits[right] || occ1 == -1) {
                occ1 = fruits[right++];
                freq1++;
            } else if (occ2 == fruits[right] || occ2 == - 1) {
                occ2 = fruits[right++];
                freq2++;
            } else {
                res = Math.max(res, freq1 + freq2);
                while (occ1 != -1 && occ2 != -1) {
                    if(occ1 == fruits[left++]) {
                        freq1--;
                        if(freq1 == 0) {
                            occ1 = -1;
                        }
                    } else {
                        freq2--;
                        if(freq2 == 0) {
                            occ2 = -1;
                        }
                    }
                }
            }
        }
        return Math.max(res, freq1 + freq2);
    }
}
