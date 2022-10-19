package leetcode.strings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.10.2022
 **/
public class TopKFrequentWords_692 {

    public static void main(String[] args) {
        final List<String> expected = Arrays.asList("the", "is", "sunny", "day");
        final String[] input = new String[] {"the","day","is","sunny","the","the","the","sunny","is","is"};
        System.out.println(topKFrequentWords(input, 4));
        assert topKFrequentWords(input, 4).containsAll(expected);
    }

    private static List<String> topKFrequentWords(final String[] words, final int k) {
        final Map<String, Integer> countMap = new HashMap<>();
        for(final String str : words) {
            countMap.putIfAbsent(str, 0);
            countMap.put(str, countMap.get(str) + 1);
        }

        final List<String> orderedList = countMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByValue()).thenComparing(Map.Entry.comparingByKey()))
                .map(e -> e.getKey()).collect(Collectors.toList());
        return orderedList.subList(0, k);
    }

    //best memory usage
    public List<String> topKFrequent(String[] words, int k) {
        TreeMap<String, Integer> map = new TreeMap<>(String::compareTo);
        Arrays.stream(words).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
        return map.entrySet().stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }
}
