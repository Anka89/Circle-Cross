package com.kodilla;

import javafx.scene.control.Button;

public class Controller {

    private String userSymbol;
    private Model model = new Model();

    public void buttonClicked(Button button, Button[] buttons) throws InterruptedException {
        Thread.sleep( 5000 );
        button.setText( userSymbol );
        Integer userData = (Integer) button.getUserData();
        model.setX(userData);
        int buttonNumberO = model.getComputerMoveO();

        buttons[buttonNumberO].setText("O");
        model.setO(buttonNumberO);
    }

    public void setUserSymbol(Button button) {
//        if (Button circle = new Button( "O" );
//        circle.setOnAction( event -> controller.setUserSymbol("o") );)

        Dla uproszczenia chciałabym aby użytkownik był tulko O i miał do kliknięcia Button O, tylko nie wiem jak to zrobić :/

    }