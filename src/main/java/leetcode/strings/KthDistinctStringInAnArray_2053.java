package leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.08.2024
 **/
public class KthDistinctStringInAnArray_2053 {

    public static void main(String[] args) {
        kthDistinct(new String[] {"d","b","c","b","c","a"}, 2);
    }

    public static String kthDistinct(final String[] arr, final int k) {
        final Map<String, Integer> unique = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            if(unique.containsKey(arr[i])) {
                arr[unique.get(arr[i])] = null;
                arr[i] = null;
            }
            unique.put(arr[i], i);
        }

        int idx = 0;
        int indexNotNull = 0;
        while (idx < arr.length) {
            if(arr[idx++] != null) {
                if(++indexNotNull == k) {
                    return arr[idx - 1];
                }
            }
        }
        return "";
    }

    //Time O(n) and Space O(n)
    public String kthDistinctMap(String[] arr, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        // First pass: Populate the frequency map
        for (String str : arr) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        // Second pass: Find the k-th distinct string
        for (String str : arr) {
            // Check if the current string is distinct
            if (frequencyMap.get(str) == 1) {
                k--;
            }
            // When k reaches 0, we have found the k-th distinct string
            if (k == 0) {
                return str;
            }
        }

        return "";
    }
}
