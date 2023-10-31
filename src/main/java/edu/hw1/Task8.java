package edu.hw1;

import static edu.hw1.Constants.KNIGHT_TURNS;

public class Task8 {
    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < cols; columnIndex++) {
                if (board[rowIndex][columnIndex] == 1) {
                    for (int[] direction : KNIGHT_TURNS) {
                        int row = rowIndex + direction[0];
                        int col = columnIndex + direction[1];
                        if (isValidCell(row, col, rows, cols) && board[row][col] == 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private static boolean isValidCell(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
