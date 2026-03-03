package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.03.2026
 **/
public class FindKthBitInNthBinaryString_1545 {

    public static void main(String[] args) {

    }

    public static char findKthBitDivideAndConquer(final int n, int k) {
        int length = (1 << n) - 1; // length of Sn is 2^n - 1
        int swap = 0;
        while (k > 1) {
            if(k == (length / 2 - 1)) return swap % 2 == 0 ? '1' : '0';
            if(k > length / 2) {
                swap++;
                k = length - k + 1;
            }
            length/=2;
        }
        return swap % 2 == 0 ? '0' : '1';
    }

    //Time O(n) and Space O(n)
    public static char findKthBitRecursion(final int n, int k) {
        if(n == 1) return '0';
        int length = 1 << n; //analogue of 2^n
        if(k < length / 2) {
            return findKthBitRecursion(n - 1, k);
        } else if (k == length/2) {
            return '1';
        } else {
            return findKthBitRecursion(n - 1, length - k) == '0' ? '1' : '0';
        }
    }
    //Time O(2^n) and Space O(2^n)
    public static char findKthBitBruteForce(final int n, final int k) {
        final StringBuilder sb = new StringBuilder();
        sb.append("0");
        for(int i = 0; i < n; i++) {
            sb.append("1");
            for(int j = sb.length() - 2; j > -1; j--) {
                sb.append(sb.charAt(j) == '0' ? '1' : '0');
            }
        }
        return sb.charAt(k);
    }
}
