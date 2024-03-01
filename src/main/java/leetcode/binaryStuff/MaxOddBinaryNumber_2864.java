package leetcode.binaryStuff;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.03.2024
 **/
public class MaxOddBinaryNumber_2864 {

    public static void main(String[] args) {

    }

    public String maxOddBinaryNumber(final String s) {
        int count = -1;
        for(char c : s.toCharArray()) {
            if(c == '1') {
                count++;
            }
        }

        int i=0;
        final StringBuilder sb = new StringBuilder();
        while(i++ < s.length()-1) {
            sb.append(count-- > 0 ? '1' : '0');
        }
        return sb.append('1').toString();
    }

    //Memory optimized
    public String maximumOddBinaryNumber(String s) {
        char [] arr = s.toCharArray();
        Arrays.sort(arr);
        int left = 0,right = s.length() - 2;
        //System.out.println(Arrays.toString(arr));
        while(left<=right)
        {
            if(arr[left] =='0' && arr[right] == '1')
            {
                arr[left] = '1';
                arr[right] = '0';
            }
            else
                break;
            left++;
            right--;
        }
        return new String(arr);
    }
}
