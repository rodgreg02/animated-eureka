import java.util.Random;

public class CPU extends Moves {
    Boat[] cpuBoats = new Boat[5];


    public void populateBoatCpu() {
        Moves move = new Moves();
        cpuBoats = move.addShipTypes();
    }


    public int[] setShips(Boat[] boat, String coord1, int i, Playfield playfield) {
        int[] rndCoords = new int[3];
        Random rnd = new Random();
        boolean isValid = false;
        while (!isValid) {
            rndCoords[0] = rnd.nextInt(10);
            rndCoords[1] = rnd.nextInt(10);
            rndCoords[2] = rnd.nextInt(4);
            isValid = playfield.checkCPU(rndCoords, i, boat);
        }

        return rndCoords;
    }
}
