package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.02.2023
 **/
public class PermutationInStrings_567 {

    public static void main(String[] args) {
        checkInclusion("adc", "dcda");
    }

    private static boolean checkInclusion(final String s1, final String s2) {
        final int[] frequencies = new int[26];
        for(final char c : s1.toCharArray()) {
            frequencies[c - 'a']++;
        }

        for(int i=0; i<s2.length()-s1.length()+1; i++) {
            int counter = 0;
            final int[] currFreq = new int[26];
            for(int j=i; j<s2.length(); j++) {
                final int cNum = s2.charAt(j) - 'a';
                if(frequencies[cNum] != 0) {
                    currFreq[cNum]++;
                    counter++;
                    if(currFreq[cNum] > frequencies[cNum]) {
                        break;
                    }
                    if(counter == s1.length()) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }

        return false;
    }
}
