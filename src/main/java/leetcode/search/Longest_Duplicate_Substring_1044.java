package leetcode.search;

import java.util.HashMap;
import java.util.Map;

/**
 * Issue 1044. Longest Duplicate Substring [HARD].
 * Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.
 * (The occurrences may overlap.)
 * <p>
 * Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring,
 * the answer is "".)
 * <p>
 * Binary search on the answer
 * Use RabinKarp to find solution with specified length in O(n) time
 * User : Shein G.A.{@reeeray}
 * Date : 19.06.2020
 **/
public class Longest_Duplicate_Substring_1044 {

    public String longestDupSubstring(String S) {
        int left = 0;
        int right = S.length() - 1;

        while (left < right) { //left can't be equal right because we need at least 2 duplications
            int mid = left + ((right - left + 1) >> 1); //it's the same as division on 2
            if (isDuplicatesPresent(S, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return findDuplicates(S, left);
    }

    private boolean isDuplicatesPresent(final String str, final int len) {
        if (len == 0)
            return true;
        return findDuplicates(str, len) != null;
    }

    private String findDuplicates(final String str, final int len) {
        long hash = 0;
        long prime = 29;
        long firstEntryPower = 1;
        for (int i = 0; i < len; i++) {
            firstEntryPower *= prime;
            hash = hash * prime + (str.charAt(i) - 'a');
        }

        Map<Long, Integer> hashIndexMap = new HashMap<>();
        hashIndexMap.put(hash, 0);

        for (int i = len; i < str.length(); i++) {
            hash = hash * prime + (str.charAt(i) - 'a');
            hash -= firstEntryPower * (str.charAt(i - len) - 'a');

            if (hashIndexMap.containsKey(hash)) {
                int index = hashIndexMap.get(hash);
                return str.substring(index, index + len);
            }

            hashIndexMap.put(hash, i - len + 1);
        }
        return null;
    }

//    static String sub = "";
//
//    public String longestDupSubstring(String S) {
//        int left = 0;
//        int right = S.length() - 1;
//
//        while(left<=right) {
//            int mid = (left+right)/2; //left + (left+right)/2
//            final int repeat = searchForSub(S, mid);
//            if(repeat == 2) {
//                if(searchForSub(S, ++mid) == 2)
//                    return sub;
//            }else if (repeat > 2) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return sub;
//    }
//
//    private static int searchForSub(final String str, final int subLen) {
//        for(int i=0; i<str.length() - subLen+1; i++) {
//            String sub = str.substring(i, i+subLen);
//            int num = numberOfSub(str, sub);
//            if( num >= 2) {
//                Longest_Duplicate_Substring_1044.sub = sub;
//                return num;
//            }
//        }
//        return 0;
//    }

    /**
     * Rabin-Karp algorithm for searching substring in string using hash function
     *
     * @param str
     * @param substring
     * @return
     */
    private static int numberOfSub(final String str, final String substring) {
        int counter = 0;
        final int subLen = substring.length();
        int hsub = substring.hashCode();
        for (int i = 0; i < str.length() - subLen + 1; i++) {
            final String st = str.substring(i, i + subLen);
            int hs = st.hashCode();
            if (hs == hsub) {
                if (str.substring(i, i + subLen).equals(substring))
                    counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Longest_Duplicate_Substring_1044 solution = new Longest_Duplicate_Substring_1044();
        System.out.println(solution.longestDupSubstring("banana"));
//        System.out.println(searchForSub("banana", 3) + sub);

//        System.out.println(numberOfSub("banana", "ana"));
    }
}
