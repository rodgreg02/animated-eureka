import java.util.ArrayList;

public class CPU {
    ArrayList<Boat> cpuBoats;

    public boolean cpuMove() {
        return false;
    }

    public boolean populateBoatCpu() {
        for (int i = 0; i <= 4; i++) {
            switch (i) {
                case 0:
                    Boat carrier = new Boat("AircraftCarrier", 5, 'A');
                    cpuBoats.add(carrier);
                    break;
                case 1:
                    Boat battleship = new Boat("Battleship", 4, 'B');
                    cpuBoats.add(battleship);
                    break;
                case 2:
                    Boat cruiser = new Boat("Cruiser", 3, 'C');
                    cpuBoats.add(cruiser);
                    break;
                case 3:
                    Boat sub = new Boat("Submarine", 3, 'S');
                    cpuBoats.add(sub);
                    break;
                case 4:
                    Boat destroyer = new Boat("Destroyer", 2, 'D');
                    cpuBoats.add(destroyer);
                    break;
            }
            return true;
        }
   return true; }
}
