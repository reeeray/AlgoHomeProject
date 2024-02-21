package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.02.2024
 **/
public class BitwiseANDOfNumbersRange_201 {

    public static void main(String[] args) {
        rangeBitwiseAnd(5, 7);
    }

    //O(1) and O(1)
    public static int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        while(left != right) {
            left = left >> 1;
            right = right >> 1;
            count++;
        }
        return left >> count;
    }

    public static int rangeBitwiseAndOpt(int left, int right) {
        while(left <= right) {
            right = right & (right - 1);
        }
        return right;
    }


}
