package com.kodilla;

import javafx.scene.control.Button;

public class Controller {

    private Model model = new Model();

    public void buttonClicked(Button button, Button[] buttons) throws InterruptedException {
        Integer userData = (Integer) button.getUserData();
        model.isEndOfGame();
        if (model.isEndOfGame() == true) {
            System.out.println( "End of Game" );
            break;
        } else {
            model.setX( userData );
            model.isEndOfGame();
            if(model.isEndOfGame() == true) {
                System.out.println( "End of Game" );
                break;
            } else {
            model.getComputerMoveO();
                if(model.isEndOfGame() == true) {
                    System.out.println( "End of Game" );
                    break;
                }
            }
            draw( buttons, model.getTable() );
        }
    }

    private void draw(Button[] buttons, int[][] table) {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == 1) {
                    buttons[k].setText( "x" );
                } else if (table[i][j] == -1) {
                    buttons[k].setText( "O" );
                } else {
                    buttons[k].setText( " " );
                }
                k++;
            }
        }
    }
}