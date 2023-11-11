import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
        while (!gameOver) {

            Scanner scanner0 = new Scanner(System.in);
            System.out.println("Insert coordinates to place ship, and the end coordinates for the ship.");
            System.out.println("The ship you,re setting needs " + player.playerBoats[i].size + "spaces");
            if(player.setShips(player.playerBoats, scanner0.next(), scanner0.next(), i)){
                i++;


        }

    }
    }
}