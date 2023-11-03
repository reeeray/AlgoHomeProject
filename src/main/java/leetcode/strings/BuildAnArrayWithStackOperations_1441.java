package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.11.2023
 **/
public class BuildAnArrayWithStackOperations_1441 {

    public static void main(String[] args) {
        final int[] input = new int[] {1, 3};
        buildArray(input, 3);
    }

    public static List<String> buildArray(final int[] target, final int n) {
        final List<String> ans = new ArrayList<>();
        final String push = "Push";
        final String pop = "Pop";
        int pointer = 0;
        for(int i =1; i<=n; i++) {
            ans.add(push);
            if(target[pointer] == i) {
                pointer++;
                if(pointer == target.length) {
                    break;
                }
            } else {
                ans.add(pop);
            }
        }
        return ans;
    }
}
