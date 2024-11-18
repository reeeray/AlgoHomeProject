package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.11.2024
 **/
public class DefuseTheBomb_1652 {

    public static void main(String[] args) {
        final int[] input1 = new int[] {5, 7, 1, 4};
        final int[] input2 = new int[] {2, 4, 9, 3};
        //decrypt(input1, 3);
        decrypt(input2, -2);
    }

    //sliding window, Time O(n) and Time O(n)
    public static int[] decrypt(final int[] code, final int k) {
        if(k == 0) {
            return new int[code.length];
        }
        int start, end, sum = 0;
        if(k > 0) {
            start = 1;
            end = k;
        } else {
            start = code.length + k;
            end = code.length - 1;
        }
        for(int i=start; i<=end; i++) {
            sum += code[i];
        }
        final int[] ans = new int[code.length];
        for(int i=0; i<code.length; i++) {
            ans[i] = sum;
            sum -= code[start];
            start++;
            end++;
            if(start == code.length) {
                start = 0;
            }
            if(end == code.length) {
                end = 0;
            }
            sum += code[end];
        }
        return ans;
    }
}
