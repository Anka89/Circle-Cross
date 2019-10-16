package com.kodilla;

import javafx.scene.control.Button;

public class Controller {

    private String userSymbol;

    public void buttonClicked(Button button) throws InterruptedException {
        Thread.sleep( 8000 );
        button.setText( userSymbol );
    }

    public void setUserSymvol(String userSymvol) {
        this.userSymbol = userSymvol;
    }
}
