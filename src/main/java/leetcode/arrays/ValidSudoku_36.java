package leetcode.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.11.2022
 **/
public class ValidSudoku_36 {

    public static void main(String[] args) {
        final char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }

    private static boolean isValidSudoku(final char[][] board) {
        final List<Set<Integer>> rows = new ArrayList<>();
        final List<Set<Integer>> columns = new ArrayList<>();
        final List<Set<Integer>> squares = new ArrayList<>();

        for(int i=0; i<9; i++) {
            rows.add(new HashSet<>());
            columns.add(new HashSet<>());
            squares.add(new HashSet<>());
        }

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    final int num = board[i][j] - '0';
                    if(!rows.get(i).add(num)) {
                        return false;
                    }
                    if(!columns.get(j).add(num)) {
                        return false;
                    }
                    final int sq = (j/3) + (i/3)*3;
                    if(!squares.get(sq).add(num)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
