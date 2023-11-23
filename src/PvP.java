import java.util.Scanner;
public class PvP {
    static public void play(){
        char[][] player1Board = new char[10][10];
        char[][] player2Board = new char[10][10];
        fillBoard(player1Board);
        fillBoard(player2Board);

        Boat[] defaultBoats = Moves.addShipTypes();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1, place your ships.");
        placeShips(player1Board, defaultBoats, scanner);

        System.out.println("Player 2, place your ships.");
        placeShips(player2Board, defaultBoats, scanner);

        playGame(player1Board, player2Board, scanner);
        scanner.close();
    }

    private static void fillBoard(char[][] board) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = '~';
            }
        }
    }

    private static void drawField(char[][] player1Board) {
        printBoard(player1Board);
    }

    private static void printBoard(char[][] board) {
        System.out.print("\033[H\033[2J");
        System.out.println("    0   1   2   3   4   5   6   7   8   9");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < board[i].length; j++) {
                char cell = board[i][j];
                String color = "\u001b[0;94m";

                if (cell == 'O') {
                    color = "\u001b[37m";

                } else if (cell == 'X') {
                    color = "\u001b[31m";
                }

                System.out.print(" " + color + cell + "\u001B[0m" + " |" );
            }
            System.out.println();
        }
    }

    private static void placeShips(char[][] board, Boat[] defaultBoats, Scanner scanner) {
        for (Boat boat : defaultBoats) {
            drawField(board);
            System.out.println("Place " + boat.name + " (size " + boat.size + ") on the board. Enter starting coordinates (row and column):");
            int startRow = scanner.nextInt();
            int startCol = scanner.nextInt();

            System.out.println("Enter orientation (H for horizontal, V for vertical):");
            String orientation = scanner.next();

            boolean isValidPlacement = checkValidPlacement(board, startRow, startCol, orientation, boat.size);

            if (!isValidPlacement) {
                System.out.println("Invalid placement or boat already placed there. Try again.");
                placeShips(board, new Boat[]{boat}, scanner);
                return;
            }

            placeBoatOnBoard(board, startRow, startCol, orientation, boat.size, boat.mark);
        }
        System.out.println("All boats placed!");
    }

    private static boolean checkValidPlacement(char[][] board, int startRow, int startCol, String orientation, int size) {
        if (orientation.equalsIgnoreCase("H")) {
            if (startCol + size > 10) {
                return false; // Exceeds board boundary
            }
            for (int i = startCol; i < startCol + size; i++) {
                if (board[startRow][i] != '~') {
                    return false; // Cell already occupied
                }
            }
        } else if (orientation.equalsIgnoreCase("V")) {
            if (startRow + size > 10) {
                return false; // Exceeds board boundary
            }
            for (int i = startRow; i < startRow + size; i++) {
                if (board[i][startCol] != '~') {
                    return false; // Cell already occupied
                }
            }
        } else {
            return false; // Invalid orientation
        }
        return true;
    }

    private static void placeBoatOnBoard(char[][] board, int startRow, int startCol, String orientation, int size, char mark) {
        if (orientation.equalsIgnoreCase("H")) {
            for (int i = startCol; i < startCol + size; i++) {
                board[startRow][i] = mark;
            }
        } else if (orientation.equalsIgnoreCase("V")) {
            for (int i = startRow; i < startRow + size; i++) {
                board[i][startCol] = mark;
            }
        }
    }

    private static void playGame(char[][] player1Board, char[][] player2Board, Scanner scanner) {
        boolean player1Turn = true;
        while (!gameOver(player1Board) && !gameOver(player2Board)) {
            if (player1Turn) {
                System.out.println("Player 1's turn. Enter target coordinates:");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                processShot(row, col, player2Board);
                drawField(player2Board);
            } else {
                System.out.println("Player 2's turn. Enter target coordinates:");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                processShot(row, col, player1Board);
                drawField(player1Board);
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
                board[row][col] = 'X';
            } else {
                System.out.println("Miss!");
                board[row][col] = 'O';
            }
        } else {
            System.out.println("Invalid coordinates.");
        }
    }

    private static boolean gameOver(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == 'S') {
                    return false;
                }
            }
        }
        return true;
    }


        }

