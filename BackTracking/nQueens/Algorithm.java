package nQueens;

import java.util.*;

/**
 * Created by vm033450 on 1/16/18.
 */
class Algorithm {
    private Set<Integer> rowPos = new LinkedHashSet<>();
    private Map<Integer, Set<String>> diagonalPos = new HashMap<>();

    private Set<String> findDiagonals(int n, int column, int row) {
        Set<String> diagonals = new HashSet<>();
        int r = row, c = column;
        while (r < n - 1 && c < n - 1) {
            diagonals.add(Integer.toString(++c).concat(Integer.toString(++r)));
        }
        r = row;
        c = column;
        while (r > 0 && c < n - 1) {
            diagonals.add(Integer.toString(++c).concat(Integer.toString(--r)));
        }
        return diagonals;
    }

    void placeNQueens(int n) {
        placeQueenPosition(n, 0, 0);
        printQueens(n, rowPos);
    }

    void printQueens(int n, Set<Integer> rowPos) {
        int[][] positions = new int[n][n];
        int column = 0;
        for (Integer row : rowPos) {
            positions[column++][row] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(positions[i][j] + " | ");
            System.out.println();
            System.out.println();
        }
    }

    private boolean isPositionUnderAttack(int column, int row) {
        if (rowPos.contains(row))
            return true;
        String pos = Integer.toString(column).concat(Integer.toString(row));
        for (Map.Entry<Integer, Set<String>> entry : diagonalPos.entrySet())
            if (entry.getValue().contains(pos))
                return true;
        return false;
    }

    private boolean placeQueenPosition(int n, int column, int row) {
        if (column >= n)
            return true;
        boolean result = false;
        for (int r = row; r < n; r++) {
            if (!isPositionUnderAttack(column, r)) {
                rowPos.add(r);
                diagonalPos.put(column, findDiagonals(n, column, r));
                result = placeQueenPosition(n, (column + 1), 0);
                if (!result) {
                    rowPos.remove(r);
                    diagonalPos.remove(column);
                }
            }
        }
        return result;
    }
}
