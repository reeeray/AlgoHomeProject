package leetcode.arrays;

import leetcode.structures.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.10.2024
 **/
public class DividePlayersIntoTeamsOfEqualSkill_2491 {

    public static void main(String[] args) {
        final int[] input = new int[] {4,2,4,3};
        dividePlayers(input);

    }

    //Space optimized O(1) and Time O(n)
    public static long dividePlayers(int[] skill) {
        final int n = skill.length;
        int totalSkill = 0;
        final int[] skillFrequency = new int[1001];

        // Calculate total skill and skill frequency
        for (int playerSkill : skill) {
            totalSkill += playerSkill;
            skillFrequency[playerSkill]++;
        }

        // Check if total skill can be evenly distributed among teams
        if (totalSkill % (n / 2) != 0) {
            return -1;
        }

        int targetTeamSkill = totalSkill / (n / 2);
        long totalChemistry = 0;

        // Calculate total chemistry while verifying valid team formations
        for (int playerSkill : skill) {
            int partnerSkill = targetTeamSkill - playerSkill;

            // Check if a valid partner exists
            if (skillFrequency[partnerSkill] == 0) {
                return -1;
            }

            totalChemistry += (long) playerSkill * (long) partnerSkill;
            skillFrequency[partnerSkill]--;
        }

        // Return half of totalChemistry as each pair is counted twice
        return totalChemistry / 2;
    }

    //Space O(n) and Time O(n)
    public static long dividePlayersSpaceNotOptimized(final int[] skill) {
        final int n = skill.length;
        final int numberOfTeams = n / 2;
        int totalSum = 0;
        final Map<Integer, Integer> skills = new HashMap<>();
        for(final int s : skill) {
            totalSum += s;
            skills.put(s, skills.getOrDefault(s, 0) + 1);
        }
        if(totalSum % numberOfTeams != 0) {
            return -1;
        }
        final int sumOfEachTeam = totalSum / numberOfTeams;
        long chemistry = 0;
        while(!skills.isEmpty()) {
            int first = skills.entrySet().iterator().next().getKey();
            int second = sumOfEachTeam - first;
            if(!skills.containsKey(second)) {
                return -1;
            }
            chemistry += first * second;
            if(skills.get(first) == 1) {
                skills.remove(first);
            } else {
                skills.put(first, skills.get(first) - 1);
            }
            if(skills.get(second) == 1) {
                skills.remove(second);
            } else {
                skills.put(second, skills.get(second) - 1);
            }
        }
        return chemistry;
    }


    //TLE due to repititieve numbers
    public long dividePlayersTLE(int[] skill) {
        final int n = skill.length;
        final int numberOfTeams = n / 2;
        int totalSum = 0;
        final List<Integer> skills = new ArrayList<>();
        for(final int s : skill) {
            totalSum += s;
            skills.add(s);
        }
        final int sumOfEachTeam = totalSum / numberOfTeams;
        long chemistry = 0;
        while(!skills.isEmpty()) {
            int first = skills.remove(0);
            int second = sumOfEachTeam - first;
            if(!skills.contains(second)) {
                return -1;
            }
            chemistry += first * second;
            skills.remove((Integer)second);
        }
        return chemistry;
    }
}
