
public class App {
    public static int solutions;
    public static final boolean CLOSED_LAP = true; // change this to allow open laps
    public static final int SIZE = 5; // change this to edit the board's size
    
    public static void main(String[] args) {
        long st = System.currentTimeMillis();

        int[][] board = new int[SIZE][SIZE];
        solve(0, 0, 1, board);

        System.out.println("Found " + solutions + " geometrically distincts solutions after " + (System.currentTimeMillis() - st)/1000 + "s");
    }

    public static void solve(int x, int y, int last, int[][] board) {
        if (!Utilities.validPosition(x, y, board)) return; // if current position is out of bounds
        if (board[x][y] != 0) return; // if current position is already visited
        if (last == 2 && x == 1 && y == 2) return; // if current position is the mirror of the first position

        board[x][y] = last; // marks current position with the number it was visited on

        // if this is the last number to put, marks as solution
        if (last == board.length * board[0].length && (!CLOSED_LAP || Utilities.laps(x, y, board))) {
            Utilities.printBoard(board);

            solutions++;

            board[x][y] = 0;
            return;
        }

        //explores all possible moves
        for (int[] move : Utilities.moves) {
            solve(x + move[0], y + move[1], last + 1, board);
        }

        board[x][y] = 0; // unmarks current position
    }
}