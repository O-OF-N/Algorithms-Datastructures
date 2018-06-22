package knightsTour;

/**
 * Created by vm033450 on 2/20/18.
 */
class Algorithm {

    final int numRows;
    final int numColumns;
    int rowPos[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    int colPos[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

    Algorithm(final int numRows, final int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
    }

    private boolean isSafe(int row, int col, int[][] moves) {
        if (row >= 0 && col >= 0 && row < numRows && col < numColumns && moves[row][col] == -1)
            return true;
        return false;
    }

    private void print(int[][] moves) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                System.out.print(moves[i][j] + " ");
            }
            System.out.println();
        }
    }

    void startTour(final int row, final int col) {
        int[][] moves = new int[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                moves[i][j] = -1;
            }
        }
        moves[0][0] = 0;
        boolean result = startTour(row, col, moves, 1);
        if (result) {
            print(moves);
        } else {
            System.out.println("Not possible");
        }
    }

    private boolean startTour(final int row, final int col, int[][] moves, int moveCount) {
        if (moveCount == numRows * numColumns)
            return true;
        for (int i = 0; i < rowPos.length; i++) {
            int currRow = row + rowPos[i];
            int currCol = col + colPos[i];
            if (!isSafe(currRow, currCol, moves))
                continue;
            moves[currRow][currCol] = moveCount;
            boolean result = startTour(currRow, currCol, moves, moveCount + 1);
            if (result)
                return result;
            moves[currRow][currCol] = -1;
        }
        return false;
    }

}