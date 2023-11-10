import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CPU cpu = new CPU();
        System.out.println("What's your username?");
        Player player = new Player(scanner.next());


        Playfield playfield = new Playfield();
        playfield.createField();
        playfield.drawField();


    }
}