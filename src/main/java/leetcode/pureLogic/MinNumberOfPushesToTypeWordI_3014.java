package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.07.2026
 **/
public class MinNumberOfPushesToTypeWordI_3014 {

    public static void main(String[] args) {

    }

    //TimeO(n) and Sapce O(1). according to requirements, letters are unique
    public int minimumPushesOptimum(String word) {
        int n = word.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += i / 8 + 1;
        }
        return res;
    }

    //This is too generic
    public static int minimumPushes(final String word) {
        final int[] count = new int[26];
        int res = 0;
        for(final char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        int numberOfPushes = 1;
        int seq = 1;
        while(true) {
            int maxIndex = 0;
            for(int i = 0;i < 26; i++) {
                if(count[i] > count[maxIndex]) maxIndex = i;
            }
            if(maxIndex == 0 && count[maxIndex] == 0) break;
            else {
                res += count[maxIndex] * numberOfPushes;
                if(++seq > 8) {
                    seq = 1;
                    numberOfPushes++;
                }
                count[maxIndex] = 0;
            }
        }
        return res;
    }
}
