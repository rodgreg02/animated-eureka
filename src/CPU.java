import java.util.Random;

public class CPU extends Moves {
    Boat[] cpuBoats = new Boat[5];


    public void populateBoatCpu() {
        Moves move = new Moves();
        cpuBoats = move.addShipTypes();
    }
    @Override
    public int[] setShips(Boat[] boat, String coord1, String coord2, int i) {
        int[] rndCoords = new int[4];
        Random rnd = new Random();
        rndCoords[0] = rnd.nextInt(9);
        int a = 0;
        int x = 0;
        switch (rnd.nextInt(1)){
            case 0:
                rndCoords[2] = rndCoords[0];
                x = 3;
                break;
            case 1:
                rndCoords[3] = rndCoords[1];
                x = 2;
                break;
        }
        while(rndCoords[0] - a != boat[i].size){
            a = rnd.nextInt(9);

        }
        rndCoords[x] = a;

        return rndCoords;
    }
}
