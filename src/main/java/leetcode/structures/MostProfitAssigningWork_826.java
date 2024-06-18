package leetcode.structures;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.06.2024
 **/
public class MostProfitAssigningWork_826 {

    public static void main(String[] args) {
        System.out.println(maxProfitAssignment(new int[]{23, 30, 35, 35, 43, 46, 47, 81, 83, 98}, new int[]{8, 11, 11, 20, 33, 37, 60, 72, 87, 95}, new int[]{95, 46, 47, 97, 11, 35, 99, 56, 41, 92}));
    }

    public static int maxProfitAssignment(final int[] difficulty, final int[] profit, final int[] worker) {
        final TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            sortedMap.put(difficulty[i], Math.max(sortedMap.getOrDefault(difficulty[i], 0), profit[i]));
        }
        int maxProfit = sortedMap.get(sortedMap.firstKey());
        for (final Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            maxProfit = Math.max(maxProfit, entry.getValue());
            sortedMap.put(entry.getKey(), maxProfit);
        }
        int res = 0;
        Arrays.sort(difficulty);
        for (int work : worker) {
            final int index = findProfit(work, difficulty);
            res += index < 0 ? 0 : sortedMap.get(difficulty[index]);
        }
        return res;
    }

    private static int findProfit(final int workLevel, final int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            final int mid = (left + right) / 2;
            if (arr[mid] == workLevel) {
                return mid;
            } else if (arr[mid] > workLevel) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    //Space O(n) and Complexity is O(nLogn + mLogm), m - workes size
    public int maxProfitAssignmentInitialIdea(
            int[] difficulty,
            int[] profit,
            int[] worker
    ) {
        List<int[]> jobProfile = new ArrayList<>();
        jobProfile.add(new int[]{0, 0});
        for (int i = 0; i < difficulty.length; i++) {
            jobProfile.add(new int[]{profit[i], difficulty[i]});
        }

        // Sort in decreasing order of profit.
        jobProfile.sort((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < jobProfile.size() - 1; i++) {
            jobProfile.get(i + 1)[1] = Math.min(
                    jobProfile.get(i)[1],
                    jobProfile.get(i + 1)[1]
            );
        }

        int netProfit = 0;
        for (int i = 0; i < worker.length; i++) {
            int ability = worker[i];
            // Maximize profit using binary search.
            int l = 0, r = jobProfile.size() - 1, jobProfit = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (jobProfile.get(mid)[1] <= ability) {
                    jobProfit = Math.max(jobProfit, jobProfile.get(mid)[0]);
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            // Add profit of each worker to total profit.
            netProfit += jobProfit;
        }
        return netProfit;
    }

    //Space O(maxAbility) and Time (n + m + maxAbility)
    public int maxProfitAssignmentWithMemoization(final int[] difficulty, final int[] profit, final int[] worker) {
        // Find maximum ability in the worker array.
        final int maxAbility = Arrays.stream(worker).max().getAsInt();
        final int[] jobs = new int[maxAbility + 1];

        for (int i = 0; i < difficulty.length; i++) {
            if (difficulty[i] <= maxAbility) {
                jobs[difficulty[i]] = Math.max(jobs[difficulty[i]], profit[i]);
            }
        }

        // Take maxima of prefixes.
        for (int i = 1; i <= maxAbility; i++) {
            jobs[i] = Math.max(jobs[i], jobs[i - 1]);
        }

        int netProfit = 0;
        for (int ability : worker) {
            netProfit += jobs[ability];
        }
        return netProfit;
    }
}
