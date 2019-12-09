package com.kodilla;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {

    private List<Button> buttons;
    private GameEngine gameEngine;
    private boolean gameNotFinished = true;
    private boolean computerPlays = false;


    public Controller() {
        this.buttons = new ArrayList<>();
        this.gameEngine = new GameEngine();
    }

    public void addButton(Button button) {
        buttons.add( button );
    }


    public void buttonClicked(int buttonNo) throws InterruptedException {
        gameEngine.getUserMove( buttonNo );
        buttons.get( buttonNo ).setText( " X " );
        didUserWon();
        playGame();
    }

    public void lowClicked() {
        gameEngine.setLevel( false );
    }

    public void hardClicked() {
        gameEngine.setLevel( true );
    }

    public void playGame() {
        if (computerPlays) {
            int computerClicked = gameEngine.getComputerMoveO();
            buttons.get( computerClicked ).setText( " O " );
            if (gameEngine.isEndOfGameForComputer()) {
                gameNotFinished = false;
                Alert alert = new Alert( Alert.AlertType.CONFIRMATION );
                alert.setTitle( "COMPUTER WON!!!" );
                alert.setContentText( "Do you want to play again?" );
                ButtonType okButton = new ButtonType( "Yes", ButtonBar.ButtonData.YES );
                ButtonType noButton = new ButtonType( "No", ButtonBar.ButtonData.NO );
                ButtonType cancelButton = new ButtonType( "Cancel", ButtonBar.ButtonData.CANCEL_CLOSE );
                alert.getButtonTypes().setAll( okButton, noButton, cancelButton );
                alert.showAndWait().ifPresent( type -> {
                    if (type.getButtonData() == ButtonBar.ButtonData.YES) {
                        gameEngine.clearTables();
                        buttons.forEach( b -> b.setText( " " ) );
                        playGame();
                    } else if (type.getButtonData() == ButtonBar.ButtonData.NO) {
                        System.exit( 0 );
                    } else {
                    }
                } );
            } else {
                computerPlays = false;
            }
        }
    }

    private void didUserWon() {
        if (gameEngine.isEndOfGameForUser()) {
            gameNotFinished = false;

            Alert alert = new Alert( Alert.AlertType.CONFIRMATION );
            alert.setTitle( "YOU WON!!!" );
            alert.setContentText( "Do you want to play again?" );
            ButtonType okButton = new ButtonType( "Yes", ButtonBar.ButtonData.YES );
            ButtonType noButton = new ButtonType( "No", ButtonBar.ButtonData.NO );
            ButtonType cancelButton = new ButtonType( "Cancel", ButtonBar.ButtonData.CANCEL_CLOSE );
            alert.getButtonTypes().setAll( okButton, noButton, cancelButton );
            alert.showAndWait().ifPresent( type -> {
                if (type.getButtonData() == ButtonBar.ButtonData.YES) {
                    gameEngine.clearTables();
                    buttons.forEach( b -> b.setText( "     " ) );
                    playGame();
                } else if (type.getButtonData() == ButtonBar.ButtonData.NO) {
                    System.exit( 0 );
                }
            } );
        } else {
            computerPlays = true;
        }
    }

    public void fillUserTable(String[] split) {
        for (String i : split) {
            Integer integer = Integer.valueOf( i );
            gameEngine.addToUserTable( integer );
            buttons.get( integer ).setText( " X " );
        }
    }

    public void fillComputerTable(String[] split1) {
        for (String i : split1) {
            Integer integer = Integer.valueOf( i );
            gameEngine.addToComputerTable( integer );
            buttons.get( integer ).setText( " O " );
        }
    }

    public String getUserTable() {
        Set<Integer> userTable = gameEngine.getUserTable();
        return userTable.stream().map( i -> i.toString() ).collect( Collectors.joining( "," ) );
    }

    public String getComputerTable() {
        Set<Integer> computerTable = gameEngine.getComputerTable();
        return computerTable.stream().map( i -> i.toString() ).collect( Collectors.joining( "," ) );
    }

    public void newGameButtonAction() {
        Alert alert = new Alert( Alert.AlertType.CONFIRMATION );
        alert.setTitle( "NEW GAME" );
        alert.setHeaderText( "I just want to make sure" );
        alert.setContentText( "Are you sure ???" );

        ButtonType okButton = new ButtonType( "Yes", ButtonBar.ButtonData.YES );
        ButtonType cancelButton = new ButtonType( "Cancel", ButtonBar.ButtonData.CANCEL_CLOSE );
        alert.getButtonTypes().setAll( okButton, cancelButton );
        alert.showAndWait().ifPresent( type -> {
            if (type.getButtonData() == ButtonBar.ButtonData.YES) {
                gameEngine.clearTables();
                buttons.forEach( b -> b.setText( " " ) );
                playGame();
            } else if (type.getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE){
                alert.close();

            } else {
                System.exit( 0 );
            }
        } );
    }

    public void loadButtonAction() {
        File file = new File( "C:\\Users\\Ania\\IdeaProjects\\CircleAndCross\\src\\main\\resources\\file\\save" );
        if (file != null) {
            try {
                BufferedReader reader = new BufferedReader( new FileReader( file ) );
                String firstLine = reader.readLine();
                String[] split = firstLine.split( "," );
                fillUserTable( split );
                String secondLine = reader.readLine();
                String[] split1 = secondLine.split( "," );
                fillComputerTable( split1 );
                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void saveButtonAction() {
        File file = new File( "C:\\Users\\Ania\\IdeaProjects\\CircleAndCross\\src\\main\\resources\\file\\save" );
        if (file != null) {
            try {
                BufferedWriter writer = new BufferedWriter( new FileWriter( file ) );
                writer.write( getUserTable() );
                writer.write( "\n" );
                writer.write( getComputerTable() );
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
