package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.11.2023
 **/
public class DetermineIfACellIsReacheable_2849 {

    public static void main(String[] args) {

    }

    public static boolean isReachableAtTime(final int sx, final int sy, final int fx, final int fy, final int t) {
        final int width = Math.abs(sx - fx);
        final int height = Math.abs(sy - fy);

        if(width == 0 && height == 0 && t == 1) {
            return false;
        }
        return t >= Math.max(height, width);
    }
}
