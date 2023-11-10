public class Playfield {
    char[][] playFieldCpu = new char[10][10];
    char[][] playFieldPlr = new char[10][10];

    public void createField(){
        for (int i = 0; i < playFieldCpu.length; i++) {
            for (int j = 0; j < playFieldCpu[i].length; j++) {
                playFieldCpu[i][j] = '~';
            }
        }
        for (int i = 0; i < playFieldPlr.length; i++) {
            for (int j = 0; j < playFieldPlr[i].length; j++) {
                playFieldPlr[i][j] = '~';
            }
        }
    }

    public void drawField(){
        System.out.println("CPU's Ocean:");
        for (int i = 0; i < playFieldCpu.length; i++) {
            System.out.println("");
            System.out.print("|---|---|---|---|---|---|---|---|---|---|\n");
            for (int j = 0; j < playFieldCpu[i].length; j++) {
                System.out.print((j == 0)? i + " " + playFieldCpu[i][j] + " | ":"" + playFieldCpu[i][j] + " | ");
            }
            System.out.print((i == 9)? "\n| A | B | C | D | E | F | G | H | I | J |": "");
        }
        System.out.println("\n\n\nPlayer's Ocean:");
    for (int i = 0; i < playFieldPlr.length; i++) {
        System.out.println("");
        System.out.print("|---|---|---|---|---|---|---|---|---|---|\n");
        for (int j = 0; j < playFieldPlr[i].length; j++) {
            System.out.print((j == 0)?i + " " + playFieldPlr[i][j] + " | ":"" + playFieldPlr[i][j] + " | ");
        }
        System.out.print((i == 9)? "\n| A | B | C | D | E | F | G | H | I | J |": "");
    }
}

//public boolean checkPlayerHit(int horizontal, int vertical){
       // if(playFieldCpu[])
//}
}
