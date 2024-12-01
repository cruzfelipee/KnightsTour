import java.util.Arrays;

public class Utilities {
    public static int[][] moves = {
        {1, 2},
        {-1, 2},
        {1, -2},
        {-1, -2},
        {2, 1},
        {2, -1},
        {-2, 1},
        {-2, -1}
    };

    public static boolean validPosition(int x, int y, int[][] board) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    public static boolean laps(int x, int y, int[][] board) {
        for (int[] move : moves) {
            int newX = x + move[0];
            int newY = y + move[1];

            if (validPosition(newX, newY, board) && board[newX][newY] == 1) {
                return true;
            }
        }

        return false;
    }

    // sorts all moves by the number of possible moves that can be made from that position (Warnsdorf's rule)
    public static int[][] sortBestMoves(int[][] board, int[] pos) {
        int[][] sorted = moves.clone();

        Arrays.sort(sorted, (moveA, moveB) -> {
            int aPoints = getPossibleMovesForPosition(pos[0] + moveA[0], pos[1] + moveA[1], board);
            int bPoints = getPossibleMovesForPosition(pos[0] + moveB[0], pos[1] + moveB[1], board);

            return aPoints - bPoints;
        });

        return sorted;
    }

    public static int getPossibleMovesForPosition(int x, int y, int[][] board) {
        int possibleMoves = 0;

        for (int[] move : moves) {
            int newX = x + move[0];
            int newY = y + move[1];

            if (validPosition(newX, newY, board) && board[newX][newY] == 0) {
                possibleMoves++;
            }
        }

        return possibleMoves;
    }

    public static void printBoard(int[][] board) {
        System.out.println("Solution: ");
        int minSpaces = (int) Math.log10(board.length * board[0].length) + 2;
        for (int[] row : board) {
            for (int cell : row) {
                //System.out.print(cell + " ");
                System.out.print(cell + (" ".repeat(Math.max(0, minSpaces - String.valueOf(cell).length()))));
            }
            System.out.println();
        }
    }

    public static void printIntMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
