package com.kodilla;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.awt.event.ActionListener;

public class View implements ActionListener {

    private Controller controller;
    private Image imageback;
    private Image hash;
    private Button[] buttons = new Button[9];

    public View(Controller controller) {
        this.controller = controller;
        imageback = new Image( "file/Background.jpg" );
        hash = new Image( "file/Hash.png" );
    }


    public void setButtonValue(int buttonNumber, String text) {
        buttons[buttonNumber].setText(text);
    }

    public Scene getScene() {
        BackgroundSize backgroundSize = new BackgroundSize( 100, 100, true, true, true, false );
        BackgroundImage backgroundImage = new BackgroundImage( imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize );
        Background background = new Background( backgroundImage );

        BackgroundSize hashSize = new BackgroundSize( 100, 100, true, true, true, false );
        BackgroundImage hashImage = new BackgroundImage( hash, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, hashSize );
        Background hashBcg = new Background( hashImage );

        VBox mainPanel = new VBox(  );


        StackPane stack = new StackPane();
        stack.setBackground( background );

//        ImageView img = new ImageView( hash );
//        stack.getChildren().add(img);

        Button circle = new Button( "O" );
        circle.setOnAction( event -> controller.setUserSymbol("o") );
        Button cross = new Button( "X" );
        cross.setOnAction( event -> controller.setUserSymbol("x") );

        TilePane boardGame = new TilePane(  );
        boardGame.setMaxWidth(200);
        boardGame.setMaxHeight(200);
        boardGame.setPrefRows(3);
        boardGame.setPrefColumns(3);
        boardGame.setBackground(hashBcg);
        boardGame.setHgap(30);
        boardGame.setVgap(40);

        for (int i = 0; i < 9; i++) {
            Button button = new Button( "     " );
            buttons[i] = button;
            button.setUserData(i);
            button.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        controller.buttonClicked(button, buttons);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } );
            boardGame.getChildren().add(button);
        }

        mainPanel.getChildren().add(circle);
        mainPanel.getChildren().add(cross);
        mainPanel.getChildren().add(stack);
        stack.getChildren().add(boardGame);
        return new Scene( mainPanel, 1500, 900, Color.WHITE );
    }

}
