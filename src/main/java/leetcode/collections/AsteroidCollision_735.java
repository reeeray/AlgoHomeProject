package leetcode.collections;

import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.07.2023
 **/
public class AsteroidCollision_735 {

    public static void main(String[] args) {

    }

    public static int[] asteroidCollision(final int[] asteroids) {
        final Stack<Integer> rightDir = new Stack<>();

        for(int ast : asteroids) {
            boolean flag = true;
            while(!rightDir.isEmpty() && (rightDir.peek() > 0 && ast < 0)) {
                if(Math.abs(rightDir.peek()) <  Math.abs(ast)) {
                    rightDir.pop();
                    continue;
                } else if (Math.abs(rightDir.peek()) == Math.abs(ast)){
                    rightDir.pop();
                }
                flag = false;
                break;
            }
            if(flag) {
                rightDir.push(ast);
            }
        }

        final int[] remains = new int[rightDir.size()];
        for(int i=remains.length - 1; i >= 0; i--) {
            remains[i] = rightDir.pop();
        }
        return remains;
    }
}
