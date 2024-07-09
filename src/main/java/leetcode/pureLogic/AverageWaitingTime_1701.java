package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.07.2024
 **/
public class AverageWaitingTime_1701 {

    public static void main(String[] args) {
        final int[][] input = new int[][] {{1, 2}, {2, 5}, {4, 3}};
        averageWaitingTime(input);
    }

    //Space O(1) and Time O(n)
    public static double averageWaitingTime(final int[][] customers) {
        int currTime = 0;
        double sum = 0;
        for(final int [] customer : customers) {
            currTime = currTime < customer[0] ? customer[0] + customer[1] : currTime + customer[1];
            sum += currTime - customer[0];

        }
        return sum / customers.length;
    }
}
