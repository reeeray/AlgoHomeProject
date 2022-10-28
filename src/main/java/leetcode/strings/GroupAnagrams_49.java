package leetcode.strings;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.10.2022
 **/
public class GroupAnagrams_49 {

    public static void main(String[] args) {
        final String[] input = {"eat","tea","tan","ate","nat","bat"};
        final List<List<String>> answer = groupAnagrams(input);
        System.out.println(answer);
        assert  answer.size() == 3;

    }


    private static List<List<String>> groupAnagrams(final String[] strs) {
        final Map<String, List<String>> groups = new HashMap<>();
        for(String str : strs) {
            final String key = convertToKey(str);
            if(!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(str);
        }

        return new ArrayList<>(groups.values());
    }

    private static String convertToKey(final String str) {
        final char[] charArr = str.toLowerCase().toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}
