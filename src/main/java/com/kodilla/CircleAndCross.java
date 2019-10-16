package com.kodilla;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CircleAndCross extends Application {

    private Controller controller = new Controller();
    private View view = new View(controller);

    public static void main(String[] args) {
        launch( args );
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle( "Cross and Circle" );
        primaryStage.setScene( view.getScene() );
        primaryStage.show();
    }
}
