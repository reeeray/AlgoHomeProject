package leetcode.dp;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.05.2026
 **/
public class JumpGameVII_1871 {

    public static void main(String[] args) {

    }

    public static boolean canReach(final String s, final int minJump, final int maxJump) {
        final boolean[] isReachable = new boolean[s.length()];
        final int[] prefixOfNumberOfJumps = new int[s.length()];
        isReachable[0] = true;
        Arrays.fill(prefixOfNumberOfJumps, 0, minJump, 1);
        for(int i = minJump; i < s.length(); i++) {
            final int leftBorderOfInterval = i - maxJump;
            final int rightBorderOfInterval = i - minJump;
            if(s.charAt(i) == '0') {
                final int wereJumpsAvailableForThisJump = prefixOfNumberOfJumps[rightBorderOfInterval] - (leftBorderOfInterval > 0 ? prefixOfNumberOfJumps[leftBorderOfInterval - 1] : 0);
                isReachable[i] = wereJumpsAvailableForThisJump > 0;
            }
            prefixOfNumberOfJumps[i] = prefixOfNumberOfJumps[i - 1] + (isReachable[i] ? 1 : 0);
        }
        return isReachable[s.length() - 1];
    }
}
