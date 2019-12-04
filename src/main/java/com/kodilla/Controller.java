package com.kodilla;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<Button> buttons;
    private GameEngine gameEngine;
    private boolean gameNotFinished = true;
    private boolean computerPlays = false;

    public Controller() {
        this.buttons = new ArrayList<>();
        this.gameEngine = new GameEngine();
    }

    ;

    public void addButton(Button button) {
        buttons.add( button );
    }

    public boolean isGameNotFinished() {
        return gameNotFinished;
    }

    public void buttonClicked(int buttonNo) throws InterruptedException {
        gameEngine.getUserMove( buttonNo );
        buttons.get( buttonNo ).setText( "x" );
        playGame();
    }

    public void lowClicked() {
        gameEngine.setLevel( false );
    }

    public void hardClicked() {
        gameEngine.setLevel( true );
    }

    public void playGame() {
        if(!computerPlays) {
            if (gameEngine.isEndOfGameForUser()) {
                gameNotFinished = false;
            } else {
                computerPlays = true;
            }
        } else {
            int computerClicked = gameEngine.getComputerMoveO();
            buttons.get( computerClicked ).setText( "o" );
            if (gameEngine.isEndOfGameForComputer()) {
                gameNotFinished = false;
            } else {
                computerPlays = false;
            }
        }
    }
}