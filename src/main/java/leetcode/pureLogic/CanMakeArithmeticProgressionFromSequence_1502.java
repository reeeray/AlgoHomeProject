package leetcode.pureLogic;

import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.06.2023
 **/
public class CanMakeArithmeticProgressionFromSequence_1502 {

    public static void main(String[] args) {
        isArethmeticProgression(new int[] {2, 10, 7, 8, 3});
//        isArethmeticProgression(new int[] {0, 0, 0, 0});
    }

    public static boolean isArethmeticProgression(final int[] arr) {
        final int n = arr.length;
        int min = arr[0];
        int max = arr[0];
        int sum = 0;
        final Set<Integer> values = new HashSet<>();
        for(int i=0; i<n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            sum += arr[i];
            values.add(arr[i]);
        }
        final double reference = ((min + max)*n*1.0) / 2;
        if(reference != sum) {
            return false;
        }
        int curr = min;
        final double d = (1.0) * (max - min) / (n-1);
        while (values.size() != 0){
            if(!values.remove(curr)) {
                return false;
            }
            curr += d;
        }
        return true;
    }
}
