package leetcode.collections;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 31.01.2023
 **/
public class BestTeamWithNoConflicts_1626 {

    public static void main(String[] args) {
        final int[] scores = {1, 3, 7, 3, 2, 4, 10, 7, 5};
        final int[] ages = {4, 5, 2, 1, 1, 2, 4, 1, 4};

        bestTeamScore(scores, ages);

    }

    private static int bestTeamScoreFailing(final int[] scores, final int[] ages) {
        final Map<Integer, List<Integer>> ageLedder = new HashMap<>();
        for (int i=0; i<scores.length; i++) {
            ageLedder.computeIfAbsent(ages[i], v -> new ArrayList<>()).add(scores[i]);
        }
//            ageLedder = ageLedder.entrySet().stream().sorted(Map.Entry.<Integer, List<Integer>>comparingByKey().reversed())
//                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> v, LinkedHashMap::new));
            final List<Integer> sortedAge = new ArrayList<>(ageLedder.keySet());
            sortedAge.sort(Comparator.reverseOrder());
            int maxScore = 0;

            for(int i=0; i<sortedAge.size(); i++) {
                final int ageLevel = sortedAge.get(i);
                int sumAtThisLevel = ageLedder.get(ageLevel).stream().reduce(0, (a, b) -> a +b);
                for(final int scoreLimit : ageLedder.get(ageLevel)) {
                    int currSum = sumAtThisLevel;
                    for(int j=i+1; j<sortedAge.size(); j++) {
                        currSum += ageLedder.get(sortedAge.get(j)).stream().filter(v -> v <= scoreLimit).reduce(0, (a, b) -> a + b);
                    }
                    sumAtThisLevel-=scoreLimit;
                    maxScore = Math.max(maxScore, currSum);
                }
            }
            return maxScore;

    }

    private static int bestTeamScore(int[] scores, int[] ages) {
        final int n = ages.length;
        int[][] ageScorePair = new int[n][2];

        for (int i = 0; i < n; i++) {
            ageScorePair[i][0] = ages[i];
            ageScorePair[i][1] = scores[i];
        }

        // Sort in ascending order of age and then by score.
        Arrays.sort(ageScorePair, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        // Initially, all states are null, denoting not yet calculated.
        final Integer[][] dp = new Integer[n][n];

        return findMaxScore(dp, ageScorePair, -1, 0);
    }

    //DP: top-down
    private static int findMaxScore(final Integer[][] dp, final int[][] ageScorePair, final int prev, final int index) {
        // Return 0 if we have iterated over all the players.
        if (index >= ageScorePair.length) {
            return 0;
        }

        // We have already calculated the answer, so no need to go into recursion.
        if (dp[prev + 1][index] != null) {
            return dp[prev + 1][index];
        }

        // If we can add this player, return the maximum of two choices we have.
        if (prev == -1 || ageScorePair[index][1] >= ageScorePair[prev][1]) {
            return dp[prev + 1][index] = Math.max(findMaxScore(dp, ageScorePair, prev, index + 1),
                    ageScorePair[index][1] + findMaxScore(dp, ageScorePair, index, index + 1));
        }

        // This player cannot be added; return the corresponding score.
        return dp[prev + 1][index] = findMaxScore(dp, ageScorePair, prev, index + 1);
    }

    //Dynamic programming : Bottom-Up
    public int bestTeamScoreBottomUpDP(int[] scores, int[] ages) {
        int[][] ageScorePair = new int[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            ageScorePair[i][0] = ages[i];
            ageScorePair[i][1] = scores[i];
        }
        Arrays.sort(ageScorePair, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);//asc by age -> score

        final int n = ageScorePair.length;
        int answer = 0;

        int[] dp = new int[n];
        // Initially, the maximum score for each player will be equal to the individual scores.
        for (int i = 0; i < n; i++) {
            dp[i] = ageScorePair[i][1];
            answer = Math.max(answer, dp[i]);
        }


        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // If the players j and i could be in the same team.
                if (ageScorePair[i][1] >= ageScorePair[j][1]) {
                    // Update the maximum score for the ith player.
                    dp[i] = Math.max(dp[i], ageScorePair[i][1] + dp[j]);
                }
            }
            // Maximum score among all the players.
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
