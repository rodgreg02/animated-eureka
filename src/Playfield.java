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
        String BLUE_BRIGHT = "\033[0;94m";
        String ANSI_RESET = "\u001B[0m";
        System.out.println("CPU's Ocean:");
        for (int i = 0; i < playFieldCpu.length; i++) {
            System.out.println("");
            System.out.print("|---|---|---|---|---|---|---|---|---|---|\n");
            for (int j = 0; j < playFieldCpu[i].length; j++) {
                System.out.print((j == 0)? i + " " + BLUE_BRIGHT + playFieldCpu[i][j] +ANSI_RESET + " | ":"" + BLUE_BRIGHT +playFieldCpu[i][j] + ANSI_RESET+ " | ");
            }
            System.out.print((i == 9)? "\n| A | B | C | D | E | F | G | H | I | J |\n": "");
        }
        System.out.println("\n\n\nPlayer's Ocean:");
    for (int i = 0; i < playFieldPlr.length; i++) {
        System.out.println("");
        System.out.print("|---|---|---|---|---|---|---|---|---|---|\n");
        for (int j = 0; j < playFieldPlr[i].length; j++) {
            System.out.print((j == 0)?i + " " + BLUE_BRIGHT +playFieldPlr[i][j] + ANSI_RESET +" | ":"" + BLUE_BRIGHT +playFieldPlr[i][j] + ANSI_RESET + " | ");
        }
        System.out.print((i == 9)? "\n| A | B | C | D | E | F | G | H | I | J |": "");
    }
}

//public boolean checkPlayerHit(int horizontal, int vertical){
       // if(playFieldCpu[])
//}
}
