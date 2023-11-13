import java.util.Random;

public class CPU extends Moves {
    Boat[] cpuBoats = new Boat[5];

    public boolean cpuMove() {
        return false;
    }

    public void populateBoatCpu() {
        Moves move = new Moves();
        cpuBoats = move.addShipTypes();
    }
    @Override
    public int[] setShips(Boat[] boat, String coord1, String coord2, int i) {
        Random rnd = new Random();
        for (int j = 0; j < 4; j++) {

        }
    }
}
