package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.08.2024
 **/
public class NumberCompliment_476 {

    public static void main(String[] args) {
        findCompliment(5);
    }

    public static int findCompliment(final int num) {
        final char[] representation = Integer.toBinaryString(num).toCharArray();
        for(int i=0; i<representation.length; i++) {
            representation[i] = representation[i] == '0' ? '1' : '0';
        }
        return Integer.parseInt(new String(representation), 2);
    }

    //Time O(1) and Space O(1)
    public int findComplementBitManipulation(int num) {
        if (num == 0) return 1;

        int bitLength = Integer.toBinaryString(num).length();

        int mask = (1 << bitLength) - 1;

        return num ^ mask;
    }
}
