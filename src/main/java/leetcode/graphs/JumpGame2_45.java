package leetcode.graphs;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.02.2023
 **/
public class JumpGame2_45 {

    public static void main(String[] args) {
        final int[] jumps = {2, 3, 1, 1, 4};
//        System.out.println(jump(jumps));
//        System.out.println(jump(new int[]{1, 2, 3}));
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

    private static int jump(final int[] jumps) {
        int curr = 0;
        int count = 0;

        while(curr <jumps.length-1) {
            if(curr + jumps[curr] >= jumps.length-1) {
                count++;
                break;
            }
            final int dist = jumps[curr];
            final int start = curr;
            final int stop = curr+dist;
            int currMax = stop + jumps[stop];
            curr += dist;
            for(int i=start; i<=stop; i++) {
                if(i + jumps[i] >= currMax) {
                    curr = i;
                    currMax = i + jumps[i];
                }
            }
            count++;
        }
        return count;
    }

    private static int jumpElegantly(final int[] jumps) {
        int steps = 0, farthest = 0;
        int left = 0, right = 0;
        while (right < jumps.length - 1) {
            for (int i = left; i <= right; ++i)
                farthest = Math.max(farthest, i + jumps[i]);
            left = right + 1;
            right = farthest;
            ++steps;
        }
        return steps;
    }


}
