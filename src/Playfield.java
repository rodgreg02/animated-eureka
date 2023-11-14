import java.util.Scanner;

public class Playfield {
    char[][] playFieldCpu = new char[10][10];
    char[][] playFieldPlr = new char[10][10];

    public void createField() {
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

    public void drawField() {
        int counter = 9;
        int counter1 = 9;
        String BLUE_BRIGHT = "\033[0;94m";
        String ANSI_RESET = "\u001B[0m";
        System.out.println("CPU's Ocean:");
        for (int i = 0; i < playFieldCpu.length; i++) {
            System.out.println("");
            System.out.print("|---|---|---|---|---|---|---|---|---|---|\n");
            for (int j = 0; j < playFieldCpu[i].length; j++) {
                System.out.print((j == 0) ? counter + " " + BLUE_BRIGHT + playFieldCpu[i][j] + ANSI_RESET + " | " : "" + BLUE_BRIGHT + playFieldCpu[i][j] + ANSI_RESET + " | ");
            }
            System.out.print((i == 9) ? "\n| J | I | H | G | F | E | D | C | B | A |\n" : "");
            counter--;

        }
        System.out.println("\n\n\nPlayer's Ocean:");
        for (int i = 0; i < playFieldPlr.length; i++) {
            System.out.println("");
            System.out.print("|---|---|---|---|---|---|---|---|---|---|\n");
            for (int j = 0; j < playFieldPlr[i].length; j++) {
                System.out.print((j == 0) ? counter1 + " " + BLUE_BRIGHT + playFieldPlr[i][j] + ANSI_RESET + " | " : "" + BLUE_BRIGHT + playFieldPlr[i][j] + ANSI_RESET + " | ");
            }
            System.out.print((i == 9) ? "\n| J | I | H | G | F | E | D | C | B | A |" : "");
            counter1--;

        }
    }

    public void placeShip(int[] coords, int x, Boat[] boat, char who) {
        Scanner scanner = new Scanner(System.in);
        int startY = 0;
        int startX = 0;
        for (int i = 0; i < coords.length; i++) {
            switch (i) {
                case 0:
                    startX = coords[i];
                    break;
                case 1:
                    startY = coords[i];
                    break;
            }
        }

        if (who == '1') {

            System.out.println("Which direction do you wanna place the boat captain?\nl)Left r)Right d)Down u)Up");
            switch (scanner.next()) {
                case "l":
                    for (int i = 0; i < boat[x].size; i++) {
                        playFieldPlr[startX][startY] = boat[x].mark;
                        startY--;
                    }
                    break;
                case "r":
                    for (int i = 0; i < boat[x].size; i++) {
                        playFieldPlr[startX][startY] = boat[x].mark;
                        startY++;
                    }
                    break;
                case "d":
                    for (int i = 0; i < boat[x].size; i++) {
                        playFieldPlr[startX][startY] = boat[x].mark;
                        startX++;
                    }
                    break;
                case "u":
                    for (int i = 0; i < boat[x].size; i++) {
                        playFieldPlr[startX][startY] = boat[x].mark;
                        startX--;
                    }
                    break;
            }

        } else if (who == 'c') {


        }
    }
}

