package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.06.2023
 **/
public class CheckIfItIsAStraightLine_1232 {

    public static void main(String[] args) {
        isStraightLine(new int[][] {{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}});
    }

    public static boolean isStraightLine(final int[][] coordinates) {
        //x = b
        if(coordinates[0][0] == coordinates[1][0]) {
            final int fixed = coordinates[0][0];
            for(int i=2; i<coordinates.length; i++) {
                if(coordinates[i][0] != fixed) {
                    return false;
                }
            }
            return true;
        }

        //y = b && y = kx + b
        final double k = (coordinates[0][1] - coordinates[1][1]) / (1.0 * coordinates[0][0] - coordinates[1][0]);
        final double b = coordinates[0][1] - k * coordinates[0][0];
        for(int i=2; i<coordinates.length; i++) {
            if(coordinates[i][1] != (k*coordinates[i][0] + b)) {
                return false;
            }
        }
        return true;
    }
}
