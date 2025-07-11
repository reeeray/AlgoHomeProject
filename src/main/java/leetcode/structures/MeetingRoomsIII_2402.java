package leetcode.structures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.07.2025
 **/
public class MeetingRoomsIII_2402 {

    public static void main(String[] args) {

    }

    //Time O(mlogm + m*n + n) and Space O(logm + 2n)
    public static int mostBooked(final int n, final int[][] meetings) {
        final int[] roomMeetingCounter = new int[n];
        final long[] timeAvailability = new long[n];
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        for(final int[] meeting : meetings) {
            boolean foundAvailableRoom = false;
            long closestAvailableTime = Long.MAX_VALUE;
            int closestAvailableRoom = 0;
            for(int i = 0; i < n; i++) {
                if(timeAvailability[i] <= meeting[0]) {
                    timeAvailability[i] = meeting[1];
                    roomMeetingCounter[i]++;
                    foundAvailableRoom = true;
                    break;
                }

                if(timeAvailability[i] < closestAvailableTime) {
                    closestAvailableRoom = i;
                    closestAvailableTime = timeAvailability[i];
                }

            }
            if(!foundAvailableRoom) {
                roomMeetingCounter[closestAvailableRoom]++;
                timeAvailability[closestAvailableRoom] += meeting[1] - meeting[0];
            }
        }

        int maxMeetingNumber = 0, maxRoomNumber = 0;
        for(int i = 0; i < n; i++) {
            if(roomMeetingCounter[i] > maxMeetingNumber) {
                maxMeetingNumber = roomMeetingCounter[i];
                maxRoomNumber = i;
            }
        }
        return maxRoomNumber;
    }

    //Time O(m*logm + mlogn) and Space O(n + logm)
    public int mostBookedOptimized(int n, int[][] meetings) {
        final var meetingCount = new int[n];
        final var usedRooms = new PriorityQueue<long[]>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        final var unusedRooms = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) {
            unusedRooms.offer(i);
        }

        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        for (final int[] meeting : meetings) {
            final int start = meeting[0], end = meeting[1];

            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                int room = (int) usedRooms.poll()[1];
                unusedRooms.offer(room);
            }

            if (!unusedRooms.isEmpty()) {
                int room = unusedRooms.poll();
                usedRooms.offer(new long[]{end, room});
                meetingCount[room]++;
            } else {
                long roomAvailabilityTime = usedRooms.peek()[0];
                int room = (int) usedRooms.poll()[1];
                usedRooms.offer(new long[]{roomAvailabilityTime + end - start, room});
                meetingCount[room]++;
            }
        }

        int maxMeetingCount = 0, maxMeetingCountRoom = 0;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxMeetingCount) {
                maxMeetingCount = meetingCount[i];
                maxMeetingCountRoom = i;
            }
        }

        return maxMeetingCountRoom;
    }
}
