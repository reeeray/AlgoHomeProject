package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.01.2025
 **/
public class MinimizeXOR_2429 {

    public static void main(String[] args) {
        minimizeXor(25, 72);
    }

    //didn't succeed, faild at test case 65, 84
    public static int minimizeXor(final int num1, final int num2) {
        final int bitCount1 = Integer.bitCount(num1);
        int bitCount2 = Integer.bitCount(num2);
        if(bitCount1 == bitCount2) {
            return num1;
        }
        int bitsToFillIn = bitCount2 - bitCount1;
        final String bitRepresentation = Integer.toBinaryString(num1);
        final StringBuilder sb = new StringBuilder();
        if(bitsToFillIn < 0) {
            for(int i=0; i<bitRepresentation.length(); i++) {
                if(bitCount2 > 0 && bitRepresentation.charAt(i) == '1') {
                    sb.append('1');
                    bitCount2--;
                } else {
                    sb.append('0');
                }
            }
            return Integer.parseInt(sb.toString(), 2);
        }
        for(int i=bitRepresentation.length() - 1; i >=0; i--) {
            if(bitRepresentation.charAt(i) == '1') {
                sb.append('1');
            } else if(bitsToFillIn > 0) {
               sb.append('1');
               bitsToFillIn--;
            }
        }
        for(int i=0; i<bitsToFillIn; i++) {
            sb.append('1');
        }
        return Integer.parseInt(sb.reverse().toString(), 2);
    }

    //Space O(1) and Time O(log n)
    public int minimizeXorEditorial(final int num1, final int num2) {
        int result = 0;

        int targetSetBitsCount = Integer.bitCount(num2);
        int setBitsCount = 0;
        int currentBit = 31; // Start from the most significant bit.

        // While x has fewer set bits than num2
        while (setBitsCount < targetSetBitsCount) {
            // If the current bit of num1 is set or we must set all remaining bits in result
            if (
                    isSet(num1, currentBit) ||
                            (targetSetBitsCount - setBitsCount > currentBit)
            ) {
                result = setBit(result, currentBit);
                setBitsCount++;
            }
            currentBit--; // Move to the next bit.
        }

        return result;
    }

    // Helper function to check if the given bit position in x is set (1).
    private boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    // Helper function to set the given bit position in x to 1.
    private int setBit(int x, int bit) {
        return x | (1 << bit);
    }
}
