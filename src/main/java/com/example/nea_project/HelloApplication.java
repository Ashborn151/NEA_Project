package com.example.nea_project;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class HelloApplication extends Application {

    Group firstGroup = new Group();
    Group secondGroup = new Group();

    @Override
    public void start(Stage stage) throws IOException {
        Text text1 = new Text();
        Button startButton = new Button("Start Game"); //creates button with label startButton and it displays Start Game
        startButton.setStyle("-fx-background-color: white; -fx-cursor: hand ");
        Button AboutButton = new Button("About"); //creates button with label AboutButton and it displays the control panel
        AboutButton.setStyle("-fx-background-color: white; -fx-cursor: hand ");
        Button exitButton = new Button("Exit Game"); //creates button with label exitButton and it displays Exit Game
        exitButton.setStyle("-fx-background-color: white; -fx-cursor: hand ");

        text1.setText("Game"); //sets the text to display the word "Game" on the screen
        text1.setX(855);
        text1.setY(400); //setX and setY set the position of the text "Game" on the scene by placing the text at position 855 on the x coordinate and 400 on the y coordinate
        text1.setFill(Color.WHITE); //sets the colour of the text to white
        text1.setFont(new Font(100)); //sets the font of the text to 100

        startButton.setFont(new Font(45)); //sets the font of Start Game to 45
        startButton.setMinWidth(300); //sets a width of 300 to the button
        startButton.setLayoutX(855);
        startButton.setLayoutY(450); //setX and setY set the position of the startButton on the scene by placing the button at position 855 on the x coordinate and 450 on the y coordinate
        startButton.setTextFill(Color.BLACK); //sets the colour of the text of Start Game to white
        startButton.setOnMouseEntered(mouseEvent -> {
            startButton.setStyle("-fx-background-color: cyan");
        });
        startButton.setOnMouseExited(mouseEvent -> {
            startButton.setStyle("-fx-background-color: white");
        });

        AboutButton.setFont(new Font(45)); //sets the font of About to 45
        AboutButton.setMinWidth(300); //sets a width of 300 to the button
        AboutButton.setLayoutX(855);
        AboutButton.setLayoutY(570); //setX and setY set the position of the AboutButton on the scene by placing the button at position 855 on the x coordinate and 570 on the y coordinate
        AboutButton.setTextFill(Color.BLACK); //sets the colour of the text of About to white
        AboutButton.setOnMouseEntered(mouseEvent -> {
            AboutButton.setStyle("-fx-background-color: cyan");
        });
        AboutButton.setOnMouseExited(mouseEvent -> {
            AboutButton.setStyle("-fx-background-color: white");
        });

        exitButton.setFont(new Font(45)); //sets the font of Exit Game to 45
        exitButton.setMinWidth(300); //sets a width of 300 to the button
        exitButton.setLayoutX(855);
        exitButton.setLayoutY(690); //setX and setY set the position of the exitButton on the scene by placing the button at position 855 on the x coordinate and 690 on the y coordinate
        exitButton.setTextFill(Color.BLACK); //sets the colour of the text of Exit Game to white
        exitButton.setOnMouseEntered(mouseEvent -> {
            exitButton.setStyle("-fx-background-color: cyan");
        });
        exitButton.setOnMouseExited(mouseEvent -> {
            exitButton.setStyle("-fx-background-color: white");
        });

        firstGroup.getChildren().add(startButton);
        firstGroup.getChildren().add(AboutButton);
        firstGroup.getChildren().add(exitButton);
        firstGroup.getChildren().add(text1);

        Scene firstScene = new Scene(firstGroup, 1920, 1080, Color.BLACK); //creates the scene where the title of the game and the buttons exist. Sets dimensions of 1920 by 1000.
        stage.setTitle("Game"); //sets the title of the scene as "Game"
        stage.setScene(firstScene); //sets the scene firstScene
        stage.show(); //displays firstScene on the display
        stage.setMaximized(true);

        Text text2 = new Text();
        secondGroup.getChildren().add(text2);
        text2.setTextAlignment(TextAlignment.CENTER);
        text2.setText("About \n This game is a sidescroller game similar to popular games such as Hollow Knight and Cuphead. \nYou will fight against several enemies and bosses that will test your skills to dodge against enemy attacks, \ndodge any obstacles while also dealing damage to the enemies and defeating them.\n\n Controls:\nA - move left\nD - move right\nMouse Right Click - attack\nSpace - jump\nESC - exit menu");
        text2.setX(300);
        text2.setY(200);
        text2.setFill(Color.WHITE);
        text2.setFont(new Font(30));

        Scene secondScene = new Scene(secondGroup, 1920, 1080, Color.BLACK);

        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() { //creates an event that opens a new window while closing the current window
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setTitle("Game2");
                stage.setScene(secondScene);
                stage.setMaximized(true);
                stage.show();

                secondScene.setOnKeyPressed(keyEvent -> {
                    if(keyEvent.getCode() == KeyCode.ESCAPE) {
                        stage.setTitle("Game");
                        stage.setScene(firstScene);
                    }
                });
            }
        };
        startButton.setOnAction(event1); //ties the event to this startButton so that the window is opened when the button is clicked
        AboutButton.setOnAction(event1);

        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        };

        exitButton.setOnAction(event2);



    }

    public static void main(String[] args) {
        launch();
    }
}