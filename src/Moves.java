import java.util.Scanner;

public class Moves {

    public Boat[] addShipTypes(){
        Boat[] defaultBoats = new Boat[5];
        for (int i = 0; i <= 4; i++) {
            switch(i){
                case 0:
                    Boat carrier = new Boat("AircraftCarrier", 5, 'A');
                    defaultBoats[i] = carrier;
                    break;
                case 1:
                    Boat battleship = new Boat("Battleship", 4, 'B');
                    defaultBoats[i] = battleship;
                    break;
                case 2:
                    Boat cruiser = new Boat("Cruiser", 3, 'C');
                    defaultBoats[i] = cruiser;
                    break;
                case 3:
                    Boat sub = new Boat("Submarine", 3,'S');
                    defaultBoats[i] = sub;
                    break;
                case 4:
                    Boat destroyer = new Boat("Destroyer", 2, 'D');
                    defaultBoats[i] = destroyer;
                    break;
            }
        }
        return defaultBoats;
    }
    public int[] coordToIndex(String coord) {
        int[] indexes = new int[2];
        int verticalIndex = 0;
        int horizontalIndex = 0;
        if(coord.length() == 2) {
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
                    indexes[0] = verticalIndex;
                } else if (coord0[i].equals("[1,2,3,4,5,6,7,8,9,0]")) {
                    horizontalIndex = Integer.valueOf(coord0[i]);
                    indexes[1] = horizontalIndex;
                    return indexes;
                }
                return null;
            }
        }
        return null;
    }

    public boolean setShips(Boat[] boat){
        boolean shipIsSet = false;
        Scanner scanner = new Scanner(System.in);
        while(!shipIsSet){
            System.out.println("You are placing ship " );
            System.out.println("What coordinates to set the ship Provide them (A0)");
            int [] firstCoord = coordToIndex(scanner.next());
        }
        return  false;
    }

    public void hitMoves(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What coordinates to hit CPT? Provide them (A0)");
        coordToIndex(scanner.next());
    }

}