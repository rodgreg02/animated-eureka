public class Player extends Moves{
    String username;
    int score;
    Boat[] playerBoats = new Boat[5];

    public Player(String username) {
        this.username = username;
    }

    public void populateBoatPlayer() {
        Moves move = new Moves();
        playerBoats = move.addShipTypes();
    }
}
