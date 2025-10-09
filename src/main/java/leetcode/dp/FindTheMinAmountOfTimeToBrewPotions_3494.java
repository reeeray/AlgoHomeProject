package leetcode.dp;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.10.2025
 **/
public class FindTheMinAmountOfTimeToBrewPotions_3494 {

    public static void main(String[] args) {

    }

    //Tme O(m*n) and Space O(n)
    public static long minTime(final int[] skill, final int[] mana) {
        final long[] res = new long[skill.length];
        for(int i = 0; i < mana.length; i++) {
            long currTime = 0;
            for(int j = 0; j < skill.length; j++) {
                currTime = Math.max(currTime, res[j]) + (long)(mana[i] * skill[j]);
            }
            res[skill.length - 1] = currTime;
            for(int j = skill.length - 2; j > -1; j--) {
                res[j] = res[j + 1] - (long)(skill[j + 1] * mana[i]);
            }
        }
        return res[skill.length - 1];
    }
}
