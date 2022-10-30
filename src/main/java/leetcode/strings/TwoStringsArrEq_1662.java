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
//     * Solution 1. Not optimal.
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

    private static boolean areArrayStringEqualsOpt(final String[] words1, final String[] words2) {
        int wordPointer1 = 0, wordPointer2 = 0;
        int letterPointer1 = 0, letterPointer2 = 0;

        while(wordPointer1 < words1.length && wordPointer2 <words2.length) {
            if(words1[wordPointer1].charAt(letterPointer1++) != words2[wordPointer2].charAt(letterPointer2++)) {
                return false;
            }

            if(letterPointer1 == words1[wordPointer1].length()) {
                wordPointer1++;
                letterPointer1 = 0;
            }

            if(letterPointer2 == words2[wordPointer2].length()) {
                wordPointer2++;
                letterPointer2 = 0;
            }
        }

        return wordPointer1 == words1.length && wordPointer2 == words2.length;
    }
}
