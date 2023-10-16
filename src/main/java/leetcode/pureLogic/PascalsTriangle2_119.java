package leetcode.pureLogic;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.10.2023
 **/
public class PascalsTriangle2_119 {

    public static void main(String[] args) {

    }

    public static List<Integer> getRow(final int index) {
        final List<Integer> answ = new ArrayList<>();

        if(index == 0) {
            answ.add(1);
            return answ;
        }
        if(index == 1) {
            answ.add(1);
            answ.add(1);
            return answ;
        }

        final List<Integer> prev = getRow(index - 1);
        answ.add(1);
        for(int i=1; i<index; i++) {
            answ.add(prev.get(i-1) + prev.get(i));
        }
        answ.add(1);
        return answ;
    }

    public List<Integer> getRowWithMath(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        long prev = 1;
        for (int k = 1; k <= rowIndex; k++) {
            long next_val = prev * (rowIndex - k + 1) / k;
            res.add((int) next_val);
            prev = next_val;
        }
        return res;
//        List<Integer> row = new ArrayList<>();
//        long ans = 1;
//
//        for(int i = 0;i<=rowIndex;i++){
//            row.add((int)ans);
//            ans = ans*(rowIndex-i);
//            ans = ans/(i+1);
//        }
//
//        return row;
    }
}
