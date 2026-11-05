
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== TIC TAC TOE =====");
        System.out.println("Player 1: X");
        System.out.println("Player 2: O");

        while (true) {

            printBoard();

            System.out.println("Player " + currentPlayer + "'s turn");

            System.out.print("Enter row (1-3): ");
            int row = sc.nextInt() - 1;

            System.out.print("Enter column (1-3): ");
            int col = sc.nextInt() - 1;

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid position! Try again.");
                continue;
            }

            if (board[row][col] != ' ') {
                System.out.println("Position already taken! Try again.");
                continue;
            }

            board[row][col] = currentPlayer;

            if (checkWinner()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " Wins!");
                break;
            }

            if (isDraw()) {
                printBoard();
                System.out.println("Game Draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        sc.close();
    }

    // Print Board with Row and Column Numbers
    public static void printBoard() {

        System.out.println();

        System.out.println("       COLUMN");
        System.out.println("        1   2   3");
        System.out.println("      +---+---+---+");

        for (int i = 0; i < 3; i++) {

            System.out.print("  " + (i + 1) + "   ");

            System.out.print("| " + board[i][0] + " ");
            System.out.print("| " + board[i][1] + " ");
            System.out.println("| " + board[i][2] + " |");

            System.out.println("      +---+---+---+");
        }

        System.out.println("      ROW");
        System.out.println();
    }

    // Check Winner
    public static boolean checkWinner() {

        // Rows
        for (int i = 0; i < 3; i++) {

            if (board[i][0] == currentPlayer &&
                board[i][1] == currentPlayer &&
                board[i][2] == currentPlayer) {

                return true;
            }
        }

        // Columns
        for (int i = 0; i < 3; i++) {

            if (board[0][i] == currentPlayer &&
                board[1][i] == currentPlayer &&
                board[2][i] == currentPlayer) {

                return true;
            }
        }

        // Diagonal 1
        if (board[0][0] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][2] == currentPlayer) {

            return true;
        }

        // Diagonal 2
        if (board[0][2] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][0] == currentPlayer) {

            return true;
        }

        return false;
    }

    // Check Draw
    public static boolean isDraw() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }
}
