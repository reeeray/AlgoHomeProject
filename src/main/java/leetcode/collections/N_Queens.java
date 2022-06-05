package leetcode.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.06.2022
 **/
public class N_Queens {

    public static final List<List<List<String>>> SOLUTIONS = new ArrayList<>();

    public static void main(String[] args) {
        SOLUTIONS.clear();
//        final List<String> list = Arrays.asList("Anton", "Andrew");
//        final List<String> copy = new ArrayList<>(list);
//        copy.set(1, "Artem");
//        System.out.println(list + "-----" + copy);
        final List<List<String>> sol = solveNQueens(1);
        System.out.println(sol);
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(".");
            }
            solution.add(row);
        }
        int pos = 0;
        final List<List<String>> res = new ArrayList<>();

//        while(pos < n) {
////            final List<List<String>> copiedBoard = new ArrayList<>(solution.size());
////            solution.forEach(l -> copiedBoard.add(new ArrayList<>(l)));
//            final List<List<String>> temp = solveBoard(solution, 0, pos);
//            if (temp.isEmpty())
//                return res;
//            final List<String> subRes = new ArrayList<>();
//            pos = temp.get(0).indexOf("Q") + 1;
//            for (int i = 0; i < n; i++) {
//                final List<String> row = temp.get(i);
//                final StringBuilder sb = new StringBuilder();
//                row.forEach(el -> sb.append(el.equals("Q") ? "Q" : "."));
//                subRes.add(sb.toString());
//            }
//            res.add(subRes);
//        }
        solveBoard(solution, 0);
        if (SOLUTIONS.isEmpty())
            return res;

        for (final List<List<String>> sol : SOLUTIONS) {
            final List<String> subRes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                final List<String> row = sol.get(i);
                final StringBuilder sb = new StringBuilder();
                row.forEach(el -> sb.append(el.equals("Q") ? "Q" : "."));
                subRes.add(sb.toString());
            }
            res.add(subRes);
        }
        return res;
    }

    private static List<List<String>> solveBoard(List<List<String>> board, final int level) {
        for (int i = 0; i < board.size(); i++) {
            final List<List<String>> copiedBoard = new ArrayList<>(board.size());
            board.forEach(l -> copiedBoard.add(new ArrayList<>(l)));
            final List<String> row = copiedBoard.get(level);
            if (row.get(i).equals(".")) {
                row.set(i, "Q");
                if (level == board.size() - 1) {
                    SOLUTIONS.add(copiedBoard);
                    return copiedBoard;
                }
            } else {
                continue;
            }
            calcBusiness(copiedBoard, level, i);
            final List<List<String>> subRes = solveBoard(copiedBoard, level + 1);
//            if(subRes.isEmpty()) {
//                continue;
//            } else {
//                return subRes;
//            }
        }
        return Collections.emptyList();
    }

    private static void calcBusiness(List<List<String>> board, final int row, final int col) {
        final int n = board.size();

        for (int i = 0; i < n; i++) {
            final List<String> rowList = board.get(i);
            if (i == row) {
                for (int j = 0; j < n; j++) {
                    if (j == col)
                        continue;
                    rowList.set(j, "B");
                }
            } else {
                int leftD = col - (row - i);
                int rightD = col + (row - i);
                rowList.set(col, "B");
                if (leftD >= 0 && leftD < n)
                    rowList.set(leftD, "B");
                if (rightD >= 0 && rightD < n)
                    rowList.set(rightD, "B");
            }
        }
    }
}
