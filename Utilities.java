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

    public static void printBoard(int[][] board) {
        System.out.println("Solution: ");
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + (" ".repeat(2 - ((int) Math.log10(cell)))));
            }
            System.out.println();
        }
    }

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
}
