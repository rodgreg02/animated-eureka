public class Moves extends Playfield {

    public Boat[] addShipTypes() {
        Boat[] defaultBoats = new Boat[5];
        for (int i = 0; i <= 4; i++) {
            switch (i) {
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
                    Boat sub = new Boat("Submarine", 3, 'S');
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
        boolean check1 = false;
        boolean check2 = false;
        int[] indexes = new int[2];
        if (coord.length() == 2) {
            String[] coord0 = coord.toUpperCase().split("");
            switch (coord0[0]) {
                case "A":
                    indexes[0] = 0;
                    check2 = true;
                    break;
                case "B":
                    indexes[0] = 1;
                    check2 = true;
                    break;
                case "C":
                    indexes[0] = 2;
                    check2 = true;
                    break;
                case "D":
                    indexes[0] = 3;
                    check2 = true;
                    break;
                case "E":
                    indexes[0] = 4;
                    check2 = true;
                    break;
                case "F":
                    indexes[0] = 5;
                    check2 = true;
                    break;
                case "G":
                    indexes[0] = 6;
                    check2 = true;
                    break;
                case "H":
                    indexes[0] = 7;
                    check2 = true;
                    break;
                case "I":
                    indexes[0] = 8;
                    check2 = true;
                    break;
                case "J":
                    indexes[0] = 9;
                    check2 = true;
                    break;
                default:
                    System.out.println("What? Quickly Captain, time's running out! We need to strike them.");
                    break;
            }
            switch (coord0[1]) {
                case "1":
                    indexes[1] = 1;
                    check1 = true;
                    break;
                case "2":
                    indexes[1] = 2;
                    check1 = true;
                    break;
                case "3":
                    indexes[1] = 3;
                    check1 = true;
                    break;
                case "4":
                    indexes[1] = 4;
                    check1 = true;
                    break;
                case "5":
                    indexes[1] = 5;
                    check1 = true;
                    break;
                case "6":
                    indexes[1] = 6;
                    check1 = true;
                    break;
                case "7":
                    indexes[1] = 7;
                    check1 = true;
                    break;
                case "8":
                    indexes[1] = 8;
                    check1 = true;
                    break;
                case "9":
                    indexes[1] = 9;
                    check1 = true;
                    break;
                case "0":
                    indexes[1] = 0;
                    check1 = true;
                    break;
                default:
                    System.out.println("What? Quickly Captain, time's running out! We need to strike them.");
                    break;
            }
            if (check1 || check2) {
                return indexes;
            } else {
                return null;
            }
        }
        return null;
    }


    public int[] setShips(Boat[] boat, String coord1, String coord2, int i) {
        // Converter coordenadas para index values
        while (true) {
            int[] coordArray1 = coordToIndex(coord1);
            int[] coordArray2 = coordToIndex(coord2);

            // Verificar se sao válidas
            if (coordArray1 == null || coordArray2 == null) {
                System.out.println("Invalid coordinates Captain! Quickly please");
                return null;
            }

            // Verificar se o ship tá na mesmo row/column
            int size = boat[i].size;
            boolean sameRow = coordArray1[0] == coordArray2[0];
            boolean sameCol = coordArray1[1] == coordArray2[1];

            //  Verificar pelo tamanho do ship
            if ((sameRow && coordArray2[1] - coordArray1[1] + 1 == size) ||
                    (sameCol && coordArray2[0] - coordArray1[0] + 1 == size)) {

                // Criar um array para guardar e o index dos ships
                int[] fullArray = new int[5];

                for (int j = 0; j < fullArray.length; j++) {
                    if (j < 2) {
                        fullArray[j] = coordArray1[j];
                    } else if (j < 4) {
                        fullArray[j] = coordArray2[j - 2];
                    } else {
                        fullArray[j] = i; // a guardar no array
                    }
                }
                return fullArray;
            } else {
                System.out.println("Invalid ship size or placement, focus Captain!");
                return null;
            }
        }
    }
}

    /*public void hitMoves(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What coordinates to hit CPT? Provide them (A0)");
        coordToIndex(scanner.next());
    }*/


