package leetcode.pureLogic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.08.2026
 **/
public class CinemaSeatAllocation_1386 {

    public static void main(String[] args) {

    }

    //Bit mask Time O(r) and Space O(r) where r is size of reservedSeats array
    public int maxNumberOfFamiliesBitMasl(int n, int[][] reservedSeats) {
        final int left = 0b11110000;
        final int middle = 0b11000011;
        final int right = 0b00001111;

        final Map<Integer, Integer> occupied = new HashMap<Integer, Integer>();
        for (final int[] seat : reservedSeats) {
            if (seat[1] >= 2 && seat[1] <= 9) {
                final int origin = occupied.getOrDefault(seat[0], 0);
                final int value = origin | (1 << (seat[1] - 2));
                occupied.put(seat[0], value);
            }
        }

        int res = (n - occupied.size()) * 2;
        for (final Map.Entry<Integer, Integer> entry : occupied.entrySet()) {
            int row = entry.getKey(),
                    bitmask = entry.getValue();
            if ((bitmask | left) == left ||
                            (bitmask | middle) == middle ||
                            (bitmask | right) == right) {
                res++;
            }
        }
        return res;
    }

    public static int maxNumberOfFamiliesOpt(final int n, final int[][] reservedSeats) {
        final int[][] simulation = new int[n][10];
        for(final int[] reservedSeat : reservedSeats) {
            if(simulation[reservedSeat[0]] == null) simulation[reservedSeat[0]] = new int[10];
            simulation[reservedSeat[0]][reservedSeat[1]] = 1;
        }
        int res = 0;

        for(final int[] row : simulation) {
            if (row == null) {
                res += 2;
                continue;
            }
            int count = 0;
            if(row[1] == 0 && row[2] == 0 && row[3] == 0 && row[4] == 0) count++;
            if(row[5] == 0 && row[6] == 0 && row[7] == 0 && row[8] == 0) count++;
            if(count == 0 && row[3] == 0 && row[4] == 0 && row[5] == 0 && row[6] == 0) count++;
            res += count;
        }
        return res;
    }
    //TLE
    public static int maxNumberOfFamilies(final int n, final int[][] reservedSeats) {
        Arrays.sort(reservedSeats, Comparator.comparingInt(a -> a[0]));
        int res = 0;
        int index = 0;
        for(int i = 1; i <= n; i++) {
            boolean leftReserved = false, rightReserved = false, midReserved = false;
            while(index < reservedSeats.length && reservedSeats[index][0] == i) {
                if(reservedSeats[index][1] > 1 && reservedSeats[index][1] < 6) leftReserved = true;
                if(reservedSeats[index][1] > 3 || reservedSeats[index][1] < 8) midReserved = true;
                if(reservedSeats[index][1] > 5 && reservedSeats[index][1] < 10) rightReserved = true;
                index++;
            }
            if(!leftReserved) res++;
            if(!rightReserved) res++;
            if((leftReserved || rightReserved) && !midReserved) res++;
        }
        return res;
    }
}
