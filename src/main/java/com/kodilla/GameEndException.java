package com.kodilla;

public class GameEndException extends Exception {
        private boolean isComputerWin;

        private GameEndException(boolean isComputerWin) {
            this.isComputerWin = isComputerWin;
        }
}
