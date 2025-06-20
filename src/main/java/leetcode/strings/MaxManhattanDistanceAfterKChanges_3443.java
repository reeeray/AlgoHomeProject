package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.06.2025
 **/
public class MaxManhattanDistanceAfterKChanges_3443 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public static int maxDistance(final String s, final int k) {
        int ans = 0;
        int north = 0, south = 0, east = 0, west = 0;
        for (char it : s.toCharArray()) {
            switch (it) {
                case 'N':
                    north++;
                    break;
                case 'S':
                    south++;
                    break;
                case 'E':
                    east++;
                    break;
                case 'W':
                    west++;
                    break;
            }
            int times1 = Math.min(Math.min(north, south), k);
            int times2 = Math.min(Math.min(east, west), k - times1);
            ans = Math.max(ans,
                    count(north, south, times1) + count(east, west, times2)
            );
        }
        return ans;
    }

    private static int count(final int dir1, int dir2, int times) {
        return Math.abs(dir1 - dir2) + times * 2;
    }

    //Time O(n) and Space O(1)
    public int maxDistanceOverall(String s, int k) {
        int latitude = 0, longitude = 0, ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'N':
                    latitude++;
                    break;
                case 'S':
                    latitude--;
                    break;
                case 'E':
                    longitude++;
                    break;
                case 'W':
                    longitude--;
                    break;
            }
            ans = Math.max(
                    ans,
                    Math.min(
                            Math.abs(latitude) + Math.abs(longitude) + k * 2,
                            i + 1
                    )
            );
        }
        return ans;
    }
}
