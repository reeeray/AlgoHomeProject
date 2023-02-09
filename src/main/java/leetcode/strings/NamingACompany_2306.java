package leetcode.strings;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.02.2023
 **/
public class NamingACompany_2306 {

    public static void main(String[] args) {
        final String[] ideas = {"coffee","donuts","time","toffee"};
        System.out.println(distinctNames(ideas));
    }

    public static long distinctNames(final String[] names) {
        long answer = 0;
        final Map<Integer, Set<String>> roots = new HashMap<>();

        for(final String name : names) {
            roots.computeIfAbsent(name.charAt(0) - 'a', v -> new HashSet<>()).add(name.substring(1));
        }

        for(int i=0; i<26; i++) {
            final Set<String> firstWord = roots.get(i);
            if(firstWord == null) {
                continue;
            }
            for(int j=i+1; j<=26; j++) {
                final Set<String> secondWord = roots.get(j);
                if(secondWord == null) {
                    continue;
                }
                int numberOfIndistinct = 0;
                for(final String root : secondWord) {
                    if (firstWord.contains(root)) {
                        numberOfIndistinct++;
                    }
                }
                answer += 2 * (firstWord.size() - numberOfIndistinct) * (secondWord.size() - numberOfIndistinct);
            }
        }

        // Group idea by their initials.
        final HashSet<String>[] initialGroup = new HashSet[26];
        for (int i = 0; i < 26; ++i) {
            initialGroup[i] = new HashSet<>();
        }
        for (String idea : names) {
            initialGroup[idea.charAt(0) - 'a'].add(idea.substring(1));
        }

        // Calculate number of valid names from every pair of groups.
        for (int i = 0; i < 25; ++i) {
            for (int j = i + 1; j < 26; ++j) {
                // Get the number of mutual suffixes.
                long numOfMutual = 0;
                for (String ideaA : initialGroup[i]) {
                    if (initialGroup[j].contains(ideaA)) {
                        numOfMutual++;
                    }
                }
                // Valid names are only from distinct suffixes in both groups.
                // Since we can swap a with b and swap b with a to create two valid names, multiple answer by 2.
                answer += 2 * (initialGroup[i].size() - numOfMutual) * (initialGroup[j].size() - numOfMutual);
            }
        }
        return answer;
    }
}
