package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.03.2025
 **/
public class CountTotalNumberOfColoredCells_2579 {

    public static void main(String[] args) {

    }

    //Time O(1) and Space O(1)
    public static long coloredCells(final int n) {
        if(n == 1) {
            return 1;
        }
        //first we want to calculate arithmetical progression of first n elements S=((a1+an)*n)/2
        final int sum = n*(n-1)/2;
        //and then we apply intuitive formula that each time diff increase by 4 cells : 4*S + 1.
        return 4L*sum + 1;
    }

    //Iterative approach : Time O(n) and Space O(1)
    public long coloredCellsIterative(int n) {
        long numBlueCells = 1;
        int added = 4;

        // Iterate n - 1 times
        while (--n > 0) {
            // Add and update current multiple of 4
            numBlueCells += added;
            added += 4;
        }
        return numBlueCells;
    }
}
