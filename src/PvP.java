import java.util.Scanner;
public class PvP {
    static public void play(){
        char[][] player1Board = new char[10][10];
        char[][] player2Board = new char[10][10];
        initializeBoard(player1Board);
        initializeBoard(player2Board);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1, place your ships.");
        placeShips(player1Board, scanner);

        System.out.println("Player 2, place your ships.");
        placeShips(player2Board, scanner);

        playGame(player1Board, player2Board, scanner);
        scanner.close();
    }

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = '~'; // Represents empty sea
            }
        }
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static void placeShips(char[][] board, Scanner scanner) {
        int numShips = 5; // Assuming 5 ships
        while (numShips > 0) {
            System.out.println("Enter ship coordinates (row and column):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row >= 0 && row < 10 && col >= 0 && col < 10 && board[row][col] == '~') {
                board[row][col] = 'O'; // Represents a ship
                numShips--;
            } else {
                System.out.println("Invalid coordinates or ship already there. Try again.");
            }
        }
        System.out.println("All ships placed!");
        printBoard(board);
    }

    private static void playGame(char[][] player1Board, char[][] player2Board, Scanner scanner) {
        boolean player1Turn = true;
        while (!gameOver(player1Board) && !gameOver(player2Board)) {
            if (player1Turn) {
                System.out.println("Player 1's turn. Enter target coordinates:");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                processShot(row, col, player2Board);
                printBoard(player2Board);
            } else {
                System.out.println("Player 2's turn. Enter target coordinates:");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                processShot(row, col, player1Board);
                printBoard(player1Board);
            }
            player1Turn = !player1Turn;
        }
        if (gameOver(player1Board)) {
            System.out.println("Player 2 wins! Congratulations!");
        } else {
            System.out.println("Player 1 wins! Congratulations!");
        }
    }

    private static void processShot(int row, int col, char[][] board) {
        if (row >= 0 && row < 10 && col >= 0 && col < 10) {
            if (board[row][col] == 'O') {
                System.out.println("Hit!");
                board[row][col] = 'X'; // Mark as hit
            } else {
                System.out.println("Miss!");
            }
        } else {
            System.out.println("Invalid coordinates.");
        }
    }

    private static boolean gameOver(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == 'O') {
                    return false; // Not all ships have been sunk
                }
            }
        }
        return true; // All ships have been sunk
    }


        }

