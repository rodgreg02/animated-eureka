public class Boat {
    char mark;
    String name;
    int size;
    int hitAmount;
    boolean isDestroyed;

    public Boat(String name, int size, char mark){
        this.name = name;
        this.mark = mark;
        this.size = size;
        this.hitAmount = 0;
        this.isDestroyed = false;
    }
}
