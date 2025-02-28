package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.02.2025
 **/
public class ShortestCommonSupersequence_1092 {

    public static void main(String[] args) {
        shortestCommonSuperequence("bbbaaaba", "bbababbb");
    }

    //DP Time O(nm(n+m)) and Space O(m(n+m)) where n is length of str1 and m is length of str2
    public String shortestCommonSupersequence(String str1, String str2) {
        final int str1Length = str1.length();
        final int str2Length = str2.length();

        // Initialize the first row (when str1 is empty, the supersequence is str2's prefix)
        String[] prevRow = new String[str2Length + 1];
        for (int col = 0; col <= str2Length; col++) {
            prevRow[col] = str2.substring(0, col);
        }

        // Fill the DP table row by row
        for (int row = 1; row <= str1Length; row++) {
            // Initialize the first column (when str2 is empty, the supersequence is str1's prefix)
            final String[] currRow = new String[str2Length + 1];
            currRow[0] = str1.substring(0, row);

            for (int col = 1; col <= str2Length; col++) {
                // If characters match, extend the supersequence from the diagonal value
                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    currRow[col] = prevRow[col - 1] + str1.charAt(row - 1);
                } else {
                    // If characters do not match, choose the shorter supersequence
                    // From previous row (exclude current str1 char)
                    String pickS1 = prevRow[col];
                    // From previous column (exclude current str2 char)
                    String pickS2 = currRow[col - 1];

                    currRow[col] = (pickS1.length() < pickS2.length())
                            ? pickS1 + str1.charAt(row - 1)
                            : pickS2 + str2.charAt(col - 1);
                }
            }
            // Move to the next row (update previous row reference)
            prevRow = currRow;
        }

        // Return the shortest common supersequence from the last cell
        return prevRow[str2Length];
    }

    //Time O(nm) and Space O(nm)
    public String shortestCommonSupersequenceOpt(String str1, String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();

        int[][] dp = new int[str1Length + 1][str2Length + 1];

        // Initialize the base cases
        // When str2 is empty, the supersequence is str1 itself (length = row index)
        for (int row = 0; row <= str1Length; row++) {
            dp[row][0] = row;
        }
        // When str1 is empty, the supersequence is str2 itself (length = col index)
        for (int col = 0; col <= str2Length; col++) {
            dp[0][col] = col;
        }

        // Fill the DP table
        for (int row = 1; row <= str1Length; row++) {
            for (int col = 1; col <= str2Length; col++) {
                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    // If characters match, inherit the length from the diagonal +1
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    // If characters do not match, take the minimum length option +1
                    dp[row][col] =
                            Math.min(dp[row - 1][col], dp[row][col - 1]) + 1;
                }
            }
        }

        StringBuilder supersequence = new StringBuilder();
        int row = str1Length, col = str2Length;

        while (row > 0 && col > 0) {
            if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                // If characters match, take it from diagonal
                supersequence.append(str1.charAt(row - 1));
                row--;
                col--;
            } else if (dp[row - 1][col] < dp[row][col - 1]) {
                // If str1’s character is part of the supersequence, move up
                supersequence.append(str1.charAt(row - 1));
                row--;
            } else {
                // If str2’s character is part of the supersequence, move left
                supersequence.append(str2.charAt(col - 1));
                col--;
            }
        }

        // Append any remaining characters
        // If there are leftover characters in str1
        while (row > 0) {
            supersequence.append(str1.charAt(row - 1));
            row--;
        }
        // If there are leftover characters in str2
        while (col > 0) {
            supersequence.append(str2.charAt(col - 1));
            col--;
        }

        // Reverse the built sequence to get the correct order
        return supersequence.reverse().toString();
    }

    //Misunderstanding of technical requirements, accepting deletion of the characters
    public static String shortestCommonSuperequence(final String str1, final String str2) {
        String shortest = str1.length() > str2.length() ? str2 : str1;
        String longest = str1.length() > str2.length() ? str1 : str2;
        int startIndex = 0;
        int endIndex = str2.length();
        int len = str2.length();
        boolean isAtBegin = true;
        for(int i = 0; i < shortest.length(); i++) {
            if(longest.startsWith(shortest.substring(0, i + 1))) {
                endIndex = i + 1;
                len = i + 1;
                continue;
            }
            if (longest.endsWith(shortest.substring(0, i + 1))) {
                isAtBegin = false;
                endIndex = i + 1;
                len = i + 1;
            }
        }

        for(int i = shortest.length() - 1; i >= 0; i--) {
            if(longest.startsWith(shortest.substring(i))) {
                if(shortest.length() - i > len) {
                    isAtBegin = true;
                    endIndex = shortest.length();
                    startIndex = i;
                    len = shortest.length() - i;
                }
                continue;
            }
            if (longest.endsWith(shortest.substring(i))) {
                if(shortest.length() - i > len) {
                    isAtBegin = false;
                    endIndex = shortest.length();
                    startIndex = i;
                    len = shortest.length() - i;
                }
            }
        }
        String add = "";
        if(startIndex == 0) {
            add = shortest.substring(endIndex);
        } else {
            add = shortest.substring(0, startIndex);
        }
        return isAtBegin ? add + longest : longest + add;
    }
}
