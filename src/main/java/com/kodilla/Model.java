package com.kodilla;

import org.junit.Assert;

public class Model {
    private static final int EMPTY = 0;
    private static final int X_VALUE = 1;
    private static final int O_VALUE = -1;

    private int[][] table = new int[3][3];

    public Model() {
        for (int i = 0; i < 3; i++) {
            for (int j =0 ; j < 3; j++) {
                this.table[i][j] = EMPTY;
            }
        }
    }

    public void setX(int buttonNumber) {
        this.table[buttonNumber / 3][buttonNumber % 3] = X_VALUE;
    }

    public void setO(int buttonNumber) {
        this.table[buttonNumber / 3][buttonNumber % 3] = O_VALUE;
    }

    public int getComputerMoveO() throws GameEndException {
        int buttonNumber = /* TODO logika wyboru ruchu komputera */
        return buttonNumber;
    }


    {
        //given
        Model model = new Model();
        model.setX(0, 0);
        model.setX(0, 1);
        //when
        Position computerPosition = model.getComputerMove();
        //then
        Assert.assertEquals(0, computerPosition.getX());
        Assert.assertEquals(2, computerPosition.getY());
    }
}

