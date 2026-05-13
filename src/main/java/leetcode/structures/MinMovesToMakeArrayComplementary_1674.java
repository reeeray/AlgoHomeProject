package leetcode.structures;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.05.2026
 **/
public class MinMovesToMakeArrayComplementary_1674 {

    public static void main(String[] args) {
        minMoves(new int[] {1, 2, 2, 1}, 2);
    }

    //idea based on fixed number of cases of the situation, there 5 of them.
    public static int minMoves(int[] nums, int limit) {
        final int n = nums.length;
        final int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = Math.min(nums[i], nums[n - 1 - i]);
            int b = Math.max(nums[i], nums[n - 1 - i]);

            diff[2] += 2;
            diff[a + 1] -= 1;
            diff[a + b] -= 1;
            diff[a + b + 1] += 1;
            diff[b + limit + 1] += 1;
        }

        int minOps = n;
        int currentOps = 0;

        for (int c = 2; c <= 2 * limit; c++) {
            currentOps += diff[c];
            minOps = Math.min(minOps, currentOps);
        }

        return minOps;
    }

    //Not correct
//    public static int minMoves(final int[] nums, final int limit) {
//        final Map<Integer, Integer> freqSum = new HashMap<>();
//        int minVal = nums[0];
//        for(int i = 0; i < nums.length/2; i++) {
//            final int sum = nums[i] + nums[nums.length - 1 - i];
//            freqSum.put(sum, freqSum.getOrDefault(sum, 0) + 1);
//            minVal = Math.min(Math.min(minVal, nums[0]), nums[nums.length - i - 1]);
//        }
//        final Map<Integer, Integer> sortedFreq = freqSum.entrySet()
//                .stream()
//                .sorted((c1, c2) -> c2.getKey().compareTo(c1.getKey()))
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (e1, e2) -> e1,
//                        LinkedHashMap::new
//                ));
//        int res = 0;
//        int reference = Integer.MAX_VALUE;
//        for(final int sum : sortedFreq.keySet()) {
//            if(2*limit >= sum || minVal + limit >= sum) {
//                reference = sum;
//                break;
//            }
//        }
//        for(int i = 0; i < nums.length/2; i++) {
//            if(nums[i] + nums[nums.length - 1 - i] == reference) continue;
//            res += Math.max(nums[i], nums[nums.length - 1 - i]) + limit >= reference ? 1 : 2;
//        }
//        return res;
//    }
}
