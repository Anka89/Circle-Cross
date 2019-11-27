package com.kodilla;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class View {

    private Controller controller;
    private Image imageback;
    private Image hash;
    private Button[] buttons = new Button[9];
    private JLabel picture;
    static String lowString = "LOW";
    static String hardString = "HARD";

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

        VBox mainPanel = new VBox();

        StackPane stack = new StackPane();
        stack.setBackground( background );


        JRadioButton low = new JRadioButton( "LOW" );
        low.setMnemonic( KeyEvent.VK_L );
        low.setActionCommand(lowString);

        JRadioButton hard = new JRadioButton( "HARD" );
        hard.setMnemonic( KeyEvent.VK_H );
        hard.setActionCommand(hardString);

        ButtonGroup group = new ButtonGroup();
        group.add( low );
        group.add( hard );

        low.addActionListener( (ActionListener) this );
        hard.addActionListener( (ActionListener) this );

        picture = new JLabel(new ImageIcon("file/"
                + lowString
                + ".jpg"));
        picture.setPreferredSize(new Dimension(177, 122));


        JPanel radioPanel = new JPanel( new GridLayout( 0, 1 ) );
        radioPanel.add( low );
        radioPanel.add( hard );

//        add( radioPanel, BoxLayout.CENTER );
//        add( pictureLow, BoxLayout.CENTER );
//        add( pictureHard, BoxLayout.CENTER );
//        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));  Nie wiem do czego to dodać : do MainPanelu ???
//
//
        public void actionPerformed(ActionEvent e) {
            picture.setIcon( new ImageIcon( "file/"
                    + e.getActionCommand()
                    + ".gif" ) );
            if (hard.setAction(  ){
                model.compu
            }
        }
        button.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    controller.buttonClicked( button, buttons );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } );



//
//        /** Returns an ImageIcon, or null if the path was invalid. */
//        (String path){
//            java.net.URL imgURL = RadioButtonDemo.class.getResource( path );
//            if (imgURL != null) {
//                return new ImageIcon( imgURL );
//            } else {
//                System.err.println( "Couldn't find file: " + path );
//                return null;
//            }
//    }
//
//    /**
//     * Create the GUI and show it.  For thread safety,
//     * this method should be invoked from the
//     * event-dispatching thread.
//     */
//    private static void createAndShowGUI() {
//        //Create and set up the window.
//        JFrame frame = new JFrame("RadioButtonDemo");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        //Create and set up the content pane.
//        JComponent newContentPane = new RadioButtonDemo();
//        newContentPane.setOpaque(true); //content panes must be opaque
//        frame.setContentPane(newContentPane);
//
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        //Schedule a job for the event-dispatching thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
//
//        public void actionPerformed(ActionEvent) {
//            picture.setIcon(new ImageIcon("images/"
//                    + e.getActionCommand()
//                    + ".gif"));
//        }


            GridPane boardGame = new GridPane();
            boardGame.setAlignment( Pos.CENTER );
            boardGame.setPadding( new Insets( 11.5, 12.5, 13.5, 14.5 ) );
            boardGame.setHgap( 5.5 );
            boardGame.setVgap( 5.5 );

            for (int i = 0; i < 9; i++) {
                Button button = new Button( "     " );
                buttons[i] = button;
                button.setUserData( i );
                button.setOnAction( new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            controller.buttonClicked( button, buttons );
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } );
                boardGame.getChildren().add( button );
            }

            mainPanel.getChildren().add( stack );
            stack.getChildren().add( boardGame );
            return new Scene( mainPanel, 1500, 900, Color.WHITE );
        }

    }
