package leetcode.pureLogic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.01.2023
 **/
public class MaxPointOnLinearLine_149 {

    public static void main(String[] args) {
        final int[][] input = {{1, 1}, {4, 1}, {3, 2}, {5, 3}, {2, 3}, {1, 4}};

        assert 4 == maxPoints(input);
    }

    private static int maxPoints(int[][] points) {
        final int n = points.length;
        if (n == 1) {
            return 1;
        }
        int result = 2;
        for (int i = 0; i < n; i++) {
            final Map<Double, Integer> cnt = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    //tg(alpha) = (y1-y2)/(x1-x2);
                    cnt.merge(Math.atan2(points[j][1] - points[i][1],
                            points[j][0] - points[i][0]), 1, Integer::sum);
                }
            }
            result = Math.max(result, Collections.max(cnt.values()) + 1);
        }
        return result;
    }
}
