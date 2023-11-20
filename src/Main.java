import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        boolean gameOver = false;

        CPU cpu = new CPU();
        cpu.populateBoatCpu();
        System.out.println("What's your username?");
        Player player = new Player(scanner.next());
        player.populateBoatPlayer();


        Playfield playfield = new Playfield();
        playfield.createField();
        playfield.drawField();

        int i = 0;


        Scanner scanner0 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        while (i < 5) {
            System.out.println("\nInsert coordinates to place ship.");
            System.out.println("The ship you,re setting needs " + player.playerBoats[i].size + " spaces");
            int[] coords = player.setShips(player.playerBoats, scanner0.next(), i);
            playfield.placeShip(coords, i, player.playerBoats, '1');
            int[] coords1 = cpu.setShips(cpu.cpuBoats, "Yee", i, playfield);
            playfield.placeShip(coords1, i, cpu.cpuBoats, 'c');
            playfield.drawField();
            i++;
        }
        System.out.println("\nBoats are in position! Hostiles are setting up for attack! Combat positions!");

        while (!gameOver) {
            playfield.countLives(playfield);
            System.out.println("Where should we fire Captain?");
            scanner.reset();
            boolean checkHitPlr;
            boolean checkHitCpu = false;
            int[] a = null;
            do {
                checkHitPlr = player.fireShip(scanner.next(), '1', playfield, a);
                playfield.drawField();
                System.out.println(checkHitPlr? "\nWe hit them! Good job! Next order!?" : "\nGod damn it, it seems We missed, hostile is returning fire, take cover!");
                Thread.sleep(3500);
                if (playfield.checkVictory(playfield) == '1') {
                    System.out.println("Player victory!");
                    gameOver = true;
                }
            } while (checkHitPlr);



            do{

                boolean alreadyFiredIndex = false;
                int[] cpu1 = {0,0};
                 do{
                    cpu1[1] = rnd.nextInt(10);
                    cpu1[0] = rnd.nextInt(10);
                    alreadyFiredIndex = cpu.checkTileCondition(cpu1, playfield);
                }while(!alreadyFiredIndex);
                checkHitCpu = cpu.fireShip("yee",'c',playfield,cpu1);
                playfield.drawField();
                System.out.println(checkHitCpu? "\nWe've been hit! Plug that hole!" : "\nSeems they've missed! Prepare a shell!");
                Thread.sleep(3500);
                if (playfield.checkVictory(playfield) == 'c') {
                    System.out.println("Computer victory! Get good scrub.");
                    gameOver = true;
                }
            }while(checkHitCpu);

        }
    }
}

