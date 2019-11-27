package com.kodilla;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class View {

    private Controller controller;
    private Image imageback;
    private Image hash;
    private Label picture;
    static String lowString = "LOW";
    static String hardString = "HARD";

    public View(Controller controller) {
        this.controller = controller;
        imageback = new Image( "file/Background.jpg" );
        hash = new Image( "file/Hash.png" );
    }

    public Scene getScene() {
        BackgroundSize backgroundSize = new BackgroundSize( 100, 100, true, true, true, false );
        BackgroundImage backgroundImage = new BackgroundImage( imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize );
        Background background = new Background( backgroundImage );

        BackgroundSize hashSize = new BackgroundSize( 100, 100, true, true, true, false );
        BackgroundImage hashImage = new BackgroundImage( hash, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, hashSize );
        Background hashBcg = new Background( hashImage );

        BorderPane mainPanel = new BorderPane();
        mainPanel.setBackground( background );

        RadioButton low = new RadioButton( "LOW" );
        RadioButton hard = new RadioButton( "HARD" );

        ToggleGroup group = new ToggleGroup();
        low.setToggleGroup( group );
        hard.setToggleGroup( group );

        low.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.lowClicked();
            }
        } );
        hard.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.hardClicked();
            }
        } );

        VBox levelBox = new VBox();
        levelBox.getChildren().add( low );
        levelBox.getChildren().add( hard );

        mainPanel.setLeft( levelBox );

        TilePane boardGame = new TilePane();
        boardGame.setMaxWidth( 350 );
        boardGame.setHgap( 100 );
        boardGame.setVgap( 100 );
        boardGame.setAlignment( Pos.CENTER );
        boardGame.setPadding( new Insets( 11.5, 12.5, 13.5, 14.5 ) );

        for (int i = 0; i < 9; i++) {
            Button button = new Button( "     " );
            controller.addButton( button );
            int finalI = i;
            button.setOnAction( new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        controller.buttonClicked( finalI );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } );
            boardGame.getChildren().add( button );
        }

        mainPanel.setCenter( boardGame );
        return new Scene( mainPanel, 1500, 900, Color.WHITE );
    }

}
