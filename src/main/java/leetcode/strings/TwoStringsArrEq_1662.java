package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.10.2022
 **/
public class TwoStringsArrEq_1662 {

    public static void main(String[] args) {
        final String[] input1 = {"abc", "d", "defg"};
        final String[] input2 = {"abcddefg"};

//        assert areArrayStringsEqual(input1, input2) == true;
        assert areArrayStringEqualsOpt(input1, input2) == true;

    }


//    /**
//     * Solution 1. Runtime optimum but not space.
//     * @param words1
//     * @param words2
//     * @return
//     */
//    private static boolean areArrayStringsEqual(final String[] words1, final String[] words2) {
//        final StringBuilder sb1 = new StringBuilder();
//        final StringBuilder sb2 = new StringBuilder();
//
//        for(final String word : words1) {
//            sb1.append(word);
//        }
//
//        for(final String word : words2) {
//            sb2.append(word);
//        }
//
//        return sb1.compareTo(sb2) == 0;
//    }

    //Space optimum
    private static boolean areArrayStringEqualsOpt(final String[] word1, final String[] word2) {
        int wordIndex1 = 0, wordIndex2 = 0;
        int index1 = 0, index2 = 0;
        while(wordIndex1 < word1.length && wordIndex2 < word2.length) {
            if(word1[wordIndex1].charAt(index1++) != word2[wordIndex2].charAt(index2++)) {
                return false;
            }
            if(word1[wordIndex1].length() == index1) {
                wordIndex1++;
                index1 = 0;
            }
            if(word2[wordIndex2].length() == index2) {
                wordIndex2++;
                index2 = 0;
            }
        }
        return wordIndex1 == word1.length && wordIndex2 == word2.length;
    }
}
