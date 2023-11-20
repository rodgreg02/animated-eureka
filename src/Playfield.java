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

        int counter = 0;
        int counter1 = 0;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String BLUE_BRIGHT = "\033[0;94m";
        String ANSI_RESET = "\u001B[0m";
        System.out.println("CPU's Ocean:");
        for (int i = 0; i < playFieldCpu.length; i++) {
            System.out.println("");
            System.out.print("|---|---|---|---|---|---|---|---|---|---|\n");
            for (int j = 0; j < playFieldCpu[i].length; j++) {
                String color = BLUE_BRIGHT;
                char hiddenCpu = '~';
                if(playFieldCpu[i][j] == 'O'){hiddenCpu = 'O';}
                else if(playFieldCpu[i][j] == 'X'){hiddenCpu = 'X';}
                if(hiddenCpu == 'X'){color = "\u001b[31m";} else if (hiddenCpu == 'O') {color = "\u001b[37m";}

                System.out.print((j == 0) ? counter + " " + color + hiddenCpu + ANSI_RESET + " | " : "" + color + hiddenCpu  + ANSI_RESET + " | ");
            }
            System.out.print((i == 9) ? "\n| A | B | C | D | E | F | G | H | I | J |\n" : "");
            counter++;

        }
        System.out.println("\n\n\nPlayer's Ocean:");
        for (int i = 0; i < playFieldPlr.length; i++) {
            System.out.println("");
            System.out.print("|---|---|---|---|---|---|---|---|---|---|\n");
            for (int j = 0; j < playFieldPlr[i].length; j++) {
                String color = BLUE_BRIGHT;
                if(playFieldPlr[i][j] == 'X'){color = "\u001b[31m";} else if (playFieldPlr[i][j] == 'O') {color = "\u001b[37m";}
                System.out.print((j == 0) ? counter1 + " " + color + playFieldPlr[i][j] + ANSI_RESET + " | " : "" + color + playFieldPlr[i][j] + ANSI_RESET + " | ");
            }
            System.out.print((i == 9) ? "\n| A | B | C | D | E | F | G | H | I | J |" : "");
            counter1++;

        }
    }

    public void placeShip(int[] coords, int x, Boat[] boat, char who) {

        Scanner scanner = new Scanner(System.in);
        int startY = 0;
        int startX = 0;
        for (int i = 0; i < coords.length; i++) {
            switch (i) {
                case 0:
                    startY = coords[i];
                    break;
                case 1:
                    startX = coords[i];
                    break;
            }
        }
        try {
            if (who == '1') {
                boolean outBounds = false;
                System.out.println("Which direction do you wanna place the boat captain?\nl)Left r)Right d)Down u)Up");
                switch (scanner.next()) {

                    case "l":
                        outBounds = false;
                        int check1 = startY;
                        for (int i = 0; i < boat[x].size; i++) {
                            if (playFieldPlr[startX][check1] != '~') {
                                outBounds = true;
                            }
                            check1--;
                        }
                        if (!outBounds) {

                            for (int i = 0; i < boat[x].size; i++) {
                                playFieldPlr[startX][startY] = boat[x].mark;
                                startY--;
                            }
                        }
                        break;
                    case "r":
                        outBounds = false;
                        int check2 = startY;
                        for (int i = 0; i < boat[x].size; i++) {
                            if (playFieldPlr[startX][check2] != '~') {
                                outBounds = true;
                            }
                            check2++;
                        }
                        if (!outBounds) {

                            for (int i = 0; i < boat[x].size; i++) {
                                playFieldPlr[startX][startY] = boat[x].mark;
                                startY++;
                            }
                        }
                        break;
                    case "d":
                        outBounds = false;
                        int check3 = startX;
                        for (int i = 0; i < boat[x].size; i++) {
                            if (playFieldPlr[check3][startY] != '~') {
                                outBounds = true;
                            }
                            check3++;
                        }
                        if (!outBounds) {

                            for (int i = 0; i < boat[x].size; i++) {
                                playFieldPlr[startX][startY] = boat[x].mark;
                                startX++;
                            }
                        }
                        break;
                    case "u":
                        outBounds = false;
                        int check4 = startX;
                        for (int i = 0; i < boat[x].size; i++) {
                            if (playFieldPlr[check4][startY] != '~') {
                                outBounds = true;
                            }
                            check4--;
                        }
                        if (!outBounds) {

                            for (int i = 0; i < boat[x].size; i++) {
                                playFieldPlr[startX][startY] = boat[x].mark;
                                startX--;
                            }
                        }
                        break;
                }
            } else if (who == 'c') {
                int c = coords[2];
                for (int i = 0; i < boat[x].size; i++) {
                    playFieldCpu[startX][startY] = boat[x].mark;
                    switch (c) {
                        case 0:
                            startX--;
                            break;
                        case 1:
                            startX++;
                            break;
                        case 2:
                            startY++;
                            break;
                        case 3:
                            startY--;
                            break;
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("Out of bounds. Try again!");
        }

    }

    public boolean checkCPU(int[] coords, int x, Boat[] boat) {
        int b = coords[0];
        int a = coords[1];
        int c = coords[2];

        int size = boat[x].size;

        switch (c) {
            case 0:
                if (a - size < 0) {
                    return false;
                }
                break;
            case 1:
                if (a + size > playFieldCpu.length) {
                    return false;
                }
                break;
            case 2:
                if (b + size > playFieldCpu[a].length) {
                    return false;
                }
                break;
            case 3:
                if (b - size < 0) {
                    return false;
                }
                break;
            default:
                return false;
        }


        int tempA = a;
        int tempB = b;
        for (int i = 0; i < size; i++) {
            if (playFieldCpu[tempA][tempB] != '~') {
                return false;
            }
            switch (c) {
                case 0:
                    tempA--;
                    break;
                case 1:
                    tempA++;
                    break;
                case 2:
                    tempB++;
                    break;
                case 3:
                    tempB--;
                    break;
            }
        }
        return true;
    }

    public char checkVictory(Playfield playfield) {
        int hitCounterPlr = 0;
        int hitCounterCpu = 0;
        for (int i = 0; i < playfield.playFieldCpu.length; i++) {
            for (int j = 0; j < playfield.playFieldCpu.length; j++) {
                if (playfield.playFieldCpu[i][j] == 'X') {
                    hitCounterCpu++;
                }
            }
        }
        for (int i = 0; i < playfield.playFieldPlr.length; i++) {
            for (int j = 0; j <playfield. playFieldPlr.length; j++) {
                if (playfield.playFieldPlr[i][j] == 'X') {
                    hitCounterCpu++;
                }
            }
        }
        if(hitCounterPlr == 17){
            return 'c';
        } else if (hitCounterCpu == 17) {
            return '1';
        }
        return '0';
    }
    
    public void countLives(Playfield playfield){
        int aircraftCarrierLives = 0;
        int battleShipLives = 0;
        int cruiserLives = 0;
        int submarineLives = 0;
        int destroyerLives = 0;
        for (int i = 0; i < playfield.playFieldPlr.length; i++) {
            for (int j = 0; j < playfield.playFieldPlr.length; j++) {
                if (playfield.playFieldPlr[i][j] == 'A') {
                    aircraftCarrierLives++;
                }
                if (playfield.playFieldPlr[i][j] == 'B') {
                    battleShipLives++;
                }
                if (playfield.playFieldPlr[i][j] == 'C') {
                    cruiserLives++;
                }
                if (playfield.playFieldPlr[i][j] == 'S') {
                    submarineLives++;
                }
                if (playfield.playFieldPlr[i][j] == 'D') {
                    destroyerLives++;
                }
            }
        }
        System.out.println("Aircraft carrier: " + aircraftCarrierLives + "/5");
        System.out.println("Battleship: " + battleShipLives + "/4");
        System.out.println("Cruiser: " + cruiserLives + "/3");
        System.out.println("Submarine: " + submarineLives + "/3");
        System.out.println("Destroyer: " + destroyerLives + "/2");
    }
}
