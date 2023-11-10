import java.util.ArrayList;

public class Player {
    String username;
    int score;
    ArrayList<Boat> playerBoats;


    public Player(String username) {
        this.username = username;
    }

    public boolean populateBoatPlayer(){
        for (int i = 0; i <= 4; i++) {
            switch(i){
                case 0:
                    Boat carrier = new Boat("AircraftCarrier", 5, 'A');
                    playerBoats.add(carrier);
                    break;
                case 1:
                    Boat battleship = new Boat("Battleship", 4, 'B');
                    playerBoats.add(battleship);
                    break;
                case 2:
                    Boat cruiser = new Boat("Cruiser", 3, 'C');
                    playerBoats.add(cruiser);
                    break;
                case 3:
                    Boat sub = new Boat("Submarine", 3,'S');
                    playerBoats.add(sub);
                    break;
                case 4:
                    Boat destroyer = new Boat("Destroyer", 2, 'D');
                    playerBoats.add(destroyer);
                    break;
            }
        }
        return true;
    }

    public boolean playerMove(String coordPlay){
        return false;
    }
}
