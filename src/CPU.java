import java.util.ArrayList;

public class CPU extends  Moves{
    Boat[] cpuBoats = new Boat[5];

    public boolean cpuMove() {
        return false;
    }

    public boolean populateBoatCpu() {
        for (int i = 0; i <= 4; i++) {
            switch (i) {
                case 0:
                    Boat carrier = new Boat("AircraftCarrier", 5, 'A');
                    cpuBoats[i] = carrier;
                    break;
                case 1:
                    Boat battleship = new Boat("Battleship", 4, 'B');
                    cpuBoats[i] = battleship;
                    break;
                case 2:
                    Boat cruiser = new Boat("Cruiser", 3, 'C');
                    cpuBoats[i] = cruiser;
                    break;
                case 3:
                    Boat sub = new Boat("Submarine", 3, 'S');
                    cpuBoats[i] = sub;
                    break;
                case 4:
                    Boat destroyer = new Boat("Destroyer", 2, 'D');
                    cpuBoats[i] = destroyer;
                    break;
            }
            return true;
        }
   return true; }
}
