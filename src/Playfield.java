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

    public void placeShip(int[] coords,int x, Boat[] boat,char who) {
        int endY = 0;
        int endX = 0;
        int startY = 0;
        int startX = 0;
        for (int i = 0; i < coords.length; i++) {
            switch (i){
                case 0:
                    startY = coords[i];
                    break;
                case 1:
                    startX = coords[i];
                    break;
                case 2:
                    endY = coords[i];
                    break;
                case 3:
                    endX = coords[i];
                    break;
            }
        }

        if(who == '1'){
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                playFieldPlr[i][j] = boat[x].mark;
            }
        }
        }
        else if(who == 'c'){
            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY; j++) {
                    playFieldCpu[i][j] = boat[x].mark;
                }
        }
    }
}
}
