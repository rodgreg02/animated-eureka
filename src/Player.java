import java.util.Scanner;

public class Player {
    String username;
    int score;
    Boat[] playerBoats = new Boat[5];

    public Player(String username) {
        this.username = username;
    }

    public boolean populateBoatPlayer(){
        for (int i = 0; i <= 4; i++) {
            switch(i){
                case 0:
                    Boat carrier = new Boat("AircraftCarrier", 5, 'A');
                    playerBoats[i] = carrier;
                    break;
                case 1:
                    Boat battleship = new Boat("Battleship", 4, 'B');
                    playerBoats[i] = battleship;
                    break;
                case 2:
                    Boat cruiser = new Boat("Cruiser", 3, 'C');
                    playerBoats[i] = cruiser;
                    break;
                case 3:
                    Boat sub = new Boat("Submarine", 3,'S');
                    playerBoats[i] = sub;
                    break;
                case 4:
                    Boat destroyer = new Boat("Destroyer", 2, 'D');
                    playerBoats[i] = destroyer;
                    break;
            }
        }
        return true;
    }

    public boolean playerMove(){
        int verticalIndex = 0;
        int horizontalIndex = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Captain, what coordinates should we hit? (A0)");
        String coord = scanner.next();
        if(coord.length() == 2){
            String[] coord0 = coord.split("");
            for (int i = 0; i < coord.length(); i++) {
                if (coord0[i].equals("[A,B,C,D,E,F,G,H,I,K]")) {
                    switch (coord0[i]) {
                        case "A":
                            verticalIndex = 0;
                            break;
                        case "B":
                            verticalIndex = 1;
                            break;
                        case "C":
                            verticalIndex = 2;
                            break;
                        case "D":
                            verticalIndex = 3;
                            break;
                        case "E":
                            verticalIndex = 4;
                            break;
                        case "F":
                            verticalIndex = 5;
                            break;
                        case "G":
                            verticalIndex = 6;
                            break;
                        case "H":
                            verticalIndex = 7;
                            break;
                        case "I":
                            verticalIndex = 8;
                            break;
                        case "J":
                            verticalIndex = 9;
                            break;
                    }
                } else if (coord0[i].equals("[1,2,3,4,5,6,7,8,9,0]")) {
                     horizontalIndex = Integer.valueOf(coord0[i]);
                }
            }
        }else{
            System.out.println("Captain, we need correct coordinates! Provide them like this 'A0'");
            return false;
        }
        return false;
    }
}
