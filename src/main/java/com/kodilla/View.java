package com.kodilla;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import javafx.stage.Stage;



public class View {

    private Controller controller;
    private Stage primaryStage;
    private Image imageback;
    private Image hash;

    public View(Stage primaryStage, Controller controller) {
        this.primaryStage = primaryStage;
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
        low.setStyle( "-fx-border-width: 5px; -fx-font-size: 5em; -fx-text-fill: \t#eeeeee; -fx-font-family: Impact" );
        low.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.lowClicked();
            }
        } );

        RadioButton hard = new RadioButton( "HARD" );
        hard.setStyle( "-fx-border-width: 5px; -fx-font-size: 5em; -fx-text-fill: \t#eeeeee; -fx-font-family: Impact" );
        hard.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.hardClicked();
            }
        } );

        Label title = new Label( "Choose the level" );
        title.setStyle( "-fx-border-width: 5px; -fx-font-size: 3em; -fx-text-fill: \t#000000; -fx-font-family: Impact" );
        VBox levelBox = new VBox();
        levelBox.setSpacing( 35.0 );
        levelBox.getChildren().add( title );
        levelBox.getChildren().add( low );
        levelBox.getChildren().add( hard );
        levelBox.setAlignment( Pos.TOP_CENTER );
        VBox.setMargin( title, new Insets( 10, 0, 0, 50 ) );

        Button newGame = new Button( "New Game" );
        newGame.setStyle( "-fx-border-width: 10px; -fx-font-size: 3.5em; -fx-background-color: null; -fx-color-label-visible: no; -fx-text-fill: #ff0000; -fx-font-family: Impact" );
        newGame.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.newGameButtonAction();
            }
        });

        HBox buttonBox = new HBox();
        buttonBox.setSpacing( 35.0 );
        buttonBox.getChildren().add( newGame );
        buttonBox.setAlignment( Pos.CENTER );

        Button load = new Button( "Load" );
        load.setStyle("-fx-border-width: 10px; -fx-font-size: 3.5em; -fx-background-color: null; -fx-color-label-visible: no; -fx-text-fill: t#eeeeee; -fx-font-family: Impact");
        load.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event){
            controller.loadButtonAction();
            }
            } );

        Button save = new Button( "Save" );
        save.setStyle( "-fx-border-width: 10px; -fx-font-size: 3.5em; -fx-background-color: null; -fx-color-label-visible: no; -fx-text-fill: #eeeeee; -fx-font-family: Impact" );
        save.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.saveButtonAction();
            }
        } );

        VBox loadSaveBox = new VBox();
        loadSaveBox.getChildren().add( load );
        loadSaveBox.getChildren().add( save );
        loadSaveBox.setSpacing( 35.0 );
        loadSaveBox.setAlignment( Pos.TOP_CENTER );
        VBox.setMargin( load, new Insets( 5, 100, 0, 50 ) );
        VBox.setMargin( save, new Insets( 5, 100, 0, 50 ) );

        mainPanel.setLeft( levelBox );
        mainPanel.setBottom( buttonBox );
        mainPanel.setRight( loadSaveBox );

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
