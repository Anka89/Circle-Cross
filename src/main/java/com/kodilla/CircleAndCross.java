package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

    public class CircleAndCross extends Application {

        private Image imageback = new Image("file/Background.jpg");
        private Image hash = new Image( "file/Hash.xcf" );
        private FlowPane grids = new FlowPane( Orientation.HORIZONTAL);

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
            BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
            Background background = new Background(backgroundImage);

            GridPane grid = new GridPane();
            grid.setBackground(background);

            Scene scene = new Scene(grid, 1600, 1000, Color.WHITE);

            primaryStage.setTitle("Circle and Cross");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
}
