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


        Scanner scanner0 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        while (i < 5) {
            System.out.println("\nInsert coordinates to place ship.");
            System.out.println("The ship you,re setting needs " + player.playerBoats[i].size + " spaces");
            int[] coords = player.setShips(player.playerBoats, scanner0.next(), i);
            playfield.placeShip(coords, i, player.playerBoats, '1');
            int[] coords1 = cpu.setShips(cpu.cpuBoats,"Yee",i,playfield);
            playfield.placeShip(coords1,i,cpu.cpuBoats, 'c');
            playfield.drawField();
            i++;
        }
        System.out.println("\nBoats are in position! Hostiles are setting up for attack! Combat positions!");
    }
}

