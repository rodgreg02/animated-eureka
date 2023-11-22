import java.util.Scanner;
public class PvP {
    static public void play(){


                Scanner scanner = new Scanner(System.in);
                boolean gameOver = false;

                Player player1 = new Player("Player 1");
                Player player2 = new Player("Player 2");

                Playfield playfield1 = new Playfield();
                Playfield playfield2 = new Playfield();
                playfield1.createField();
                playfield2.createField();

                int i = 0;

                // Placing ships for both players
                while (i < 5) {
                    System.out.println("\nPlayer 1: Insert coordinates to place ship.");
                    System.out.println("The ship you're setting needs " + player1.playerBoats[i].size + " spaces");
                    int[] coords = player1.setShips(player1.playerBoats, scanner.next(), i);
                    playfield1.placeShip(coords, i, player1.playerBoats, '1');

                    System.out.println("\nPlayer 2: Insert coordinates to place ship.");
                    System.out.println("The ship you're setting needs " + player2.playerBoats[i].size + " spaces");
                    int[] coords2 = player2.setShips(player2.playerBoats, scanner.next(), i);
                    playfield2.placeShip(coords2, i, player2.playerBoats, '2');

                    playfield1.drawField();
                    playfield2.drawField();
                    i++;
                }

                System.out.println("\nBoats are in position! Let the battle begin!");

                while (!gameOver) {
                    System.out.println("\nPlayer 1's turn.");
                    System.out.println("Player 1: Where should we fire?");
                    boolean checkHitPlr1 = player1.fireShip(scanner.next(), '2', playfield2, null);
                    playfield2.drawField();

                    if (playfield2.checkVictory(playfield2) == '1') {
                        System.out.println("Player 1 wins!");
                        gameOver = true;
                        break;
                    }

                    System.out.println("\nPlayer 2's turn.");
                    System.out.println("Player 2: Where should we fire?");
                    boolean checkHitPlr2 = player2.fireShip(scanner.next(), '1', playfield1, null);
                    playfield1.drawField();

                    if (playfield1.checkVictory(playfield1) == '2') {
                        System.out.println("Player 2 wins!");
                        gameOver = true;
                        break;
                    }
                }

                System.out.println("Game over!");
            }
        }

