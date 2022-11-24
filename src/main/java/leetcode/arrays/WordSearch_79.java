package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.11.2022
 **/
public class WordSearch_79 {

    public static void main(String[] args) {
        final char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        final String word = "ABCB";
        System.out.println(word.substring(1));
        exist(board, word);
    }

    private static boolean exist(final char[][] board, final String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if(board[i][j] == word.charAt(0) && check(i, j, 0, word.substring(1), visited, board))
                    return true;
            }
        }
        return false;
    }

    private static boolean check(final int row, final int col, final int pos, final String word, final boolean[][] visited, final char[][] board) {
        if(word.length() == pos)
            return true;

        visited[row][col] = true;

        if(row + 1 < board.length && board[row+1][col] == word.charAt(0) && !visited[row + 1][col]) {
            if(check(row+1, col, pos + 1, word, visited, board)) {
                return true;
            }
        }

        if(row - 1 >= 0 && board[row-1][col] == word.charAt(0)&& !visited[row - 1][col]) {
            if(check(row-1, col, pos + 1, word, visited, board)) {
                return true;
            }
        }

        if(col + 1 < board[0].length && board[row][col + 1] == word.charAt(0) && !visited[row][col + 1]) {
            if(check(row, col + 1, pos + 1, word, visited, board)) {
                return true;
            }
        }

        if(col - 1 < board[0].length && board[row][col - 1] == word.charAt(0) && !visited[row][col - 1]) {
            if(check(row, col - 1, pos + 1, word, visited, board)) {
                    return true;
            }
        }

        visited[row][col] = false;
        return false;
    }

    private boolean dfs(final int row, final int col, final int i, final boolean[][] visited, final char[][] board, final String word){
        if(i == word.length()){
            return true;
        }
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return false;
        }
        if(word.charAt(i) != board[row][col]){
            return false;
        }
        if(visited[row][col] ){
            return false;
        }
        visited[row][col] = true;
        boolean res = dfs(row + 1, col, i + 1, visited, board, word);
        res = res || dfs(row - 1, col, i + 1, visited, board, word);
        res = res || dfs(row, col + 1, i + 1, visited, board, word);
        res = res || dfs(col, col - 1, i + 1, visited, board, word);

        return res;
    }
//    public boolean exist(char[][] board, String word) {
//        for(int i = 0; i < board.length; i++){
//            for(int j = 0; j < board[0].length; j++){
//                boolean[][] visited = new boolean[board.length][board[0].length];
//                if(dfs(i, j, 0, visited, board, word)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
