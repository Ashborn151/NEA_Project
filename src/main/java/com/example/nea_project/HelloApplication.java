package com.example.nea_project;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.text.Text;

import java.io.IOException;




public class HelloApplication extends Application {

    Group firstGroup = new Group();
    Group secondGroup = new Group();

    @Override
    public void start(Stage stage) throws IOException {
        Text text = new Text();
        Button startButton = new Button("Start Game"); //creates button with label startButton and it displays Start Game
        Button exitButton = new Button("Exit Game"); //creates button with label exitButton and it displays Exit Game

        text.setText("Game"); //sets the text to display the word "Game" on the screen
        text.setX(855);
        text.setY(400); //setX and setY set the position of the text "Game" on the scene by placing the text at position 855 on the x coordinate and 400 on the y coordinate
        text.setFill(Color.WHITE); //sets the colour of the text to white
        text.setFont(new Font(100)); //sets the font of the text to 100

        startButton.setFont(new Font(45)); //sets the font of Start Game to 45
        startButton.setMinWidth(300); //sets a width of 300 to the button
        startButton.setLayoutX(855);
        startButton.setLayoutY(455); //setX and setY set the position of the startButton on the scene by placing the button at position 855 on the x coordinate and 455 on the y coordinate
        startButton.setTextFill(Color.WHITE); //sets the colour of the text of Start Game to white

        exitButton.setFont(new Font(45)); //sets the font of Exit Game to 45
        exitButton.setMinWidth(300); //sets a width of 300 to the button
        exitButton.setLayoutX(855);
        exitButton.setLayoutY(570); //setX and setY set the position of the exitButton on the scene by placing the button at position 855 on the x coordinate and 570 on the y coordinate
        exitButton.setTextFill(Color.WHITE); //sets the colour of the text of Exit Game to white

        firstGroup.getChildren().add(startButton);
        firstGroup.getChildren().add(exitButton);
        firstGroup.getChildren().add(text);

        Scene firstScene = new Scene(firstGroup, 1920, 1000, Color.BLACK); //creates the scene where the title of the game and the buttons exist. Sets dimensions of 1920 by 1000.
        stage.setTitle("Game"); //sets the title of the scene as "Game"
        stage.setScene(firstScene); //sets the scene firstScene
        stage.show(); //displays firstScene on the display





        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                secondGroup.getChildren().add(text);
                text.setText("gybeiv");
                text.setX(855);
                text.setY(400);
                text.setFill(Color.WHITE);
                text.setFont(new Font(20));

                Scene secondScene = new Scene(secondGroup, 1920, 1000, Color.BLACK);
                stage.setTitle("Game2");
                stage.setScene(secondScene);
                stage.show();

            }
        };

        startButton.setOnAction(event);

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