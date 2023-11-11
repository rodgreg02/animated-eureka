import java.util.ArrayList;

public class CPU extends Moves {
    Boat[] cpuBoats = new Boat[5];

    public boolean cpuMove() {
        return false;
    }

    public void populateBoatCpu() {
        Moves move = new Moves();
        cpuBoats = move.addShipTypes();
    }
}
