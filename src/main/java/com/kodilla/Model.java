package com.kodilla;

import java.util.Random;

public class Model {
    private static final int EMPTY = 0;
    private static final int X_VALUE = 1;
    private static final int O_VALUE = -1;
    private static boolean computer = true;

    private int[][] table = new int[3][3];

    public Model() {
        for (int i = 0; i < 3; i++) {
            for (int j =0 ; j < 3; j++) {
                this.table[i][j] = EMPTY;
            }
        }
    }
    public int[][] getTable() {
        return table;
    }

    public void setX(int buttonNumber) {
        this.table[buttonNumber / 3][buttonNumber % 3] = X_VALUE;
    }


    public void getComputerMoveO() {
        isEndOfGame();
        //end to win
        for (int i=0; i<3; i++) {
            if (table[i][0] == -1 && table[i][1] == -1 && table[i][2] == 0) {
                table[i][2] = -1;
                return;
            }
            if (table[i][0] == -1 && table[i][2] == -1 && table[i][1] == 0) {
                table[i][1] = -1;
                return;
            }
            if (table[i][2] == -1 && table[i][1] == -1 && table[i][0] == 0) {
                table[i][0] = -1;
                return;
            }
            if (table[0][i] == -1 && table[1][i] == -1 && table[2][i] == 0) {
                table[2][i] = -1;
                return;
            }
            if (table[0][i] == -1 && table[2][i] == -1 && table[1][i] == 0) {
                table[1][i] = -1;
                return;
            }
            if (table[2][i] == -1 && table[1][i] == -1 && table[0][i] == 0) {
                table[0][i] = -1;
                return;
            }
        }
        if (table[0][0] == -1 && table[1][1] == -1 && table[2][2] == 0) {
            table[2][2] = -1;
            return;
        }
        if (table[0][0] == -1 && table[2][2] == -1 && table[1][1] == 0) {
            table[1][1] = -1;
            return;
        }
        if (table[2][2] == -1 && table[1][1] == -1 && table[0][0] == 0) {
            table[0][0] = -1;
            return;
        }
        if (table[0][2] == -1 && table[1][1] == -1 && table[2][0] == 0) {
            table[2][0] = -1;
            return;
        }
        if (table[0][2] == -1 && table[2][0] == -1 && table[1][1] == 0) {
            table[1][1] = -1;
            return;
        }
        if (table[2][0] == -1 && table[1][1] == -1 && table[0][2] == 0) {
            table[0][2] = -1;
            return;
        }

        //block user
        for (int i=0; i<3; i++) {
            if (table[i][0] == 1 && table[i][1] == 1 && table[i][2] == 0) {
                table[i][2] = -1;
                return;
            }
            if (table[i][0] == 1 && table[i][2] == 1 && table[i][1] == 0) {
                table[i][1] = -1;
                return;
            }
            if (table[i][2] == 1 && table[i][1] == 1 && table[i][0] == 0) {
                table[i][0] = -1;
                return;
            }
            if (table[0][i] == 1 && table[1][i] == 1 && table[2][i] == 0) {
                table[2][i] = -1;
                return;
            }
            if (table[0][i] == 1 && table[2][i] == 1 && table[1][i] == 0) {
                table[1][i] = -1;
                return;
            }
            if (table[2][i] == 1 && table[1][i] == 1 && table[0][i] == 0) {
                table[0][i] = -1;
                return;
            }
        }
        if (table[0][0] == 1 && table[1][1] == 1 && table[2][2] == 0) {
            table[2][2] = -1;
            return;
        }
        if (table[0][0] == 1 && table[2][2] == 1 && table[1][1] == 0) {
            table[1][1] = -1;
            return;
        }
        if (table[2][2] == 1 && table[1][1] == 1 && table[0][0] == 0) {
            table[0][0] = -1;
            return;
        }
        if (table[0][2] == 1 && table[1][1] == 1 && table[2][0] == 0) {
            table[2][0] = -1;
            return;
        }
        if (table[0][2] == 1 && table[2][0] == 1 && table[1][1] == 0) {
            table[1][1] = -1;
            return;
        }
        if (table[2][0] == 1 && table[1][1] == 1 && table[0][2] == 0) {
            table[0][2] = -1;
            return;
        }
        //if cannot win or cannot block user then random move
        boolean done = false;
        Random r = new Random();
        int a,b;
        while (!done) {
            a = r.nextInt(3);
            b = r.nextInt(3);
            if (table[a][b] == 0) {
                table[a][b] = -1;
                done = true;
            }
        }
    }

    public void getComputerMoveLowLevel() {
        isEndOfGame();
        boolean done = false;
        Random r = new Random();
        int a, b;
        while (!done) {
            a = r.nextInt( 3 );
            b = r.nextInt( 3 );
            if (table[a][b] == 0) {
                table[a][b] = -1;

            }
        }
    }

    public boolean isEndOfGame(){
        getTable();
            if ((table[0][0] == table[1][0] && table[1][0] == table[2][0] && table[2][0] != ' ') ||
                (table[0][1] == table[1][1] && table[1][1] == table[2][1] && table[2][1] != ' ') ||
                (table[0][2] == table[1][2] && table[1][2] == table[2][2] && table[2][2] != ' ') ||
                (table[0][0] == table[0][1] && table[0][1] == table[0][2] && table[0][2] != ' ') ||
                (table[1][0] == table[1][1] && table[1][1] == table[1][2] && table[1][2] != ' ') ||
                (table[2][0] == table[2][1] && table[2][1] == table[2][2] && table[2][2] != ' ') ||
                (table[0][0] == table[1][1] && table[1][1] == table[2][2] && table[2][2] != ' ') ||
                (table[0][2] == table[1][1] && table[1][1] == table[2][0] && table[2][0] != ' ')) {
                if (computer) {
                    System.out.println("The computer has won !!!");


                } else {
                    System.out.println("Bravo, you won !!!");
                }
                return true;
            }
            if (table[0][0] != ' ' && table[1][0] != ' ' && table[2][0] != ' ' &&
                    table[0][1] != ' ' && table[1][1] != ' ' && table[2][1] != ' ' &&
                    table[0][2] != ' ' && table[1][2] != ' ' && table[2][2] != ' ') {
                System.out.println("DRAW!");
                return true;
            }
            computer = !computer;
            return false;
        }
}

