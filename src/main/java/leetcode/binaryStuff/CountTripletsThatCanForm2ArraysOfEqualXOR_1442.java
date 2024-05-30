package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.05.2024
 **/
public class CountTripletsThatCanForm2ArraysOfEqualXOR_1442 {

    public static void main(String[] args) {

    }

    //Time O(n^2) and Space O(n)
    public static int countTriplets(final int[] arr) {
        final int[] xorRes = new int[arr.length + 1];
        System.arraycopy(arr, 0, xorRes, 1, arr.length);
        xorRes[0] = 0;
        for(int i=1; i<xorRes.length; i++) {
            xorRes[i] ^= xorRes[i-1];
        }

        int count = 0;
        for(int start = 0; start < xorRes.length; start++) {
            for(int end = start + 1; end < xorRes.length; end++) {
                if(xorRes[start] == xorRes[end]) {
                    count += end - start - 1;
                }
            }
        }
        return count;
    }
}
