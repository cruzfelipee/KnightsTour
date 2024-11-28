
public class App {
    public static int solutions;
    public static final boolean CLOSED_LAP = true; 
    public static final int SIZE = 6;
    
    public static void main(String[] args) {
        long st = System.currentTimeMillis();

        int[][] board = new int[SIZE][SIZE];
        solve(0, 0, 1, board);

        System.out.println("Found " + solutions + " geometrically distincts solutions after " + (System.currentTimeMillis() - st)/1000 + "s");
    }

    public static void solve(int x, int y, int last, int[][] board) {
        if (!Utilities.validPosition(x, y, board)) return;
        if (board[x][y] != 0) return;
        if (last == 2 && x == 1 && y == 2) return;

        board[x][y] = last;

        if (last == board.length * board[0].length && (!CLOSED_LAP || Utilities.laps(x, y, board))) {
            Utilities.printBoard(board);

            solutions++;

            board[x][y] = 0;
            return;
        }

        for (int[] move : Utilities.moves) {
            solve(x + move[0], y + move[1], last + 1, board);
        }

        board[x][y] = 0;
    }
}