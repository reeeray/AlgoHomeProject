package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 31.07.2024
 **/
public class FillingBookcaseShelves_1105 {

    public static void main(String[] args) {
        System.out.println(minHeightShelves(new int[][] {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}}, 4));
    }

    //is not feasible solution, TLE (because don't filter visited)
    public static int minHeightShelves(final int[][] books, final int shelfWidth) {
        final int[][] visited = new int[books.length][shelfWidth + 1];
        return dfs(books, shelfWidth, 0, 0, 0, visited);
    }

    //Space O(n + w) and Time O(n + w)
    private static int dfs(final int[][] books, final int shelfWidth, final int index, final int max, final int remains, final int [][] visited) {
        if(index >= books.length) {
            return max;
        }
        final int[] current = books[index];
        if(visited[index][remains] != 0) {
            return visited[index][remains];
        }
        int opt1 = max + dfs(books, shelfWidth, index + 1, current[1], shelfWidth - current[0], visited);
        int opt2 = Integer.MAX_VALUE;
        if(remains >= current[0]) {
            opt2 = dfs(books, shelfWidth, index + 1, Math.max(max, current[1]), remains - current[0], visited);
        }
        visited[index][remains] = Math.min(opt1, opt2);
        return visited[index][remains];
    }

    //Time O(n*w), w- bookcase width, Space(n)
    public int minHeightShelvesBottomUpDP(int[][] books, int shelfWidth) {
        // dp[i] = minimum height of bookcase containing all books up to and
        // excluding book i
        int[] dp = new int[books.length + 1];

        // base cases
        dp[0] = 0;
        dp[1] = books[0][1];

        for (int i = 2; i <= books.length; i++) {
            // new shelf built to hold current book
            int remainingShelfWidth = shelfWidth - books[i - 1][0];
            int maxHeight = books[i - 1][1];
            dp[i] = books[i - 1][1] + dp[i - 1];

            int j = i - 1;
            // calculate the height when previous books are added onto a new shelf
            while (j > 0 && remainingShelfWidth - books[j - 1][0] >= 0) {
                maxHeight = Math.max(maxHeight, books[j - 1][1]);
                remainingShelfWidth -= books[j - 1][0];
                dp[i] = Math.min(dp[i], maxHeight + dp[j - 1]);
                j--;
            }
        }

        return dp[books.length];
    }

    public int minHeightShelvesTopDownDP(final int[][] books, final int shelfWidth) {
        // Cache to store previous computations
        final int[][] memo = new int[books.length][shelfWidth + 1];
        return dpHelper(books, shelfWidth, memo, 0, shelfWidth, 0);
    }

    private int dpHelper(final int[][] books, final int shelfWidth, final int[][] memo, final int i, final int remainingShelfWidth, final int maxHeight) {
        final int[] currentBook = books[i];
        int maxHeightUpdated = Math.max(maxHeight, currentBook[1]);
        if (i == books.length - 1) {
            if (remainingShelfWidth >= currentBook[0]) return maxHeightUpdated;
            return maxHeight + currentBook[1];
        }
        // Return answer if already computed
        if (memo[i][remainingShelfWidth] != 0) {
            return memo[i][remainingShelfWidth];
        } else {
            // Calculate the height of the bookcase if we put the current book on the new shelf
            int option1Height = maxHeight + dpHelper(books, shelfWidth, memo, i + 1, shelfWidth - currentBook[0], currentBook[1]);
            if (remainingShelfWidth >= currentBook[0]) {
                // Calculate height of the bookcase if we put the current book on the current shelf
                int option2Height = dpHelper(books, shelfWidth, memo, i + 1, remainingShelfWidth - currentBook[0], maxHeightUpdated);
                // Store result in cache
                memo[i][remainingShelfWidth] = Math.min(
                        option1Height,
                        option2Height
                );
                return memo[i][remainingShelfWidth];
            }
            // Store result in cache
            memo[i][remainingShelfWidth] = option1Height;
            return memo[i][remainingShelfWidth];
        }
    }
}
