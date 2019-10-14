package com.kodilla;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

    public class CircleAndCross extends Application {

        private Image imageback = new Image("file:resources/file/BG.png");

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
            BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
            Background background = new Background(backgroundImage);

            GridPane grid = new GridPane();
            grid.setBackground(background);

            Scene scene = new Scene(grid, 800, 600, Color.WHITE);

            primaryStage.setTitle("Circle and Cross");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
}
