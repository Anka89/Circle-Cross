package com.kodilla;

import javafx.application.Application;
import javafx.stage.Stage;

public class CircleAndCross extends Application {

    public static void main(String[] args) {
        launch( args );
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle( "Cross and Circle" );
        Controller controller = new Controller();
        View view = new View(controller);
        primaryStage.setScene( view.getScene() );
        primaryStage.show();
        do {
            controller.playGame();
        } while (controller.isGameNotFinished());
    }
}
