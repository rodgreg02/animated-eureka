import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("1. Singleplayer\n2. Multiplayer");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.next()){
            case "1":
                PvC.play();
                break;
            case "2":
                PvP.play();
                break;
            default:
                System.out.println("Po caralho");
                break;
        }

    }
}

