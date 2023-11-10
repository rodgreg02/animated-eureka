public class Playfield {
    char[][] playField = new char[10][10];

    public void createField(){
        for (int i = 0; i < playField.length; i++) {
            for (int j = 0; j < playField[i].length; j++) {
                playField[i][j] = '~';
            }
        }
    }

    public void drawField(){
        for (int i = 0; i < playField.length; i++) {
            System.out.println("");
            System.out.print("|---|---|---|---|---|---|---|---|---|---|\n");
            for (int j = 0; j < playField[i].length; j++) {
                System.out.print((j == 0)?"| "+ playField[i][j] + " | ":"" + playField[i][j] + " | ");
            }
            System.out.print((i == 9)? "\n|---|---|---|---|---|---|---|---|---|---|": "");
        }
    }
}
