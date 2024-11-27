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
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;




public class HelloApplication extends Application {

    Group firstGroup = new Group();


    @Override
    public void start(Stage stage) throws IOException {
        Button startButton = new Button("Start Game");
        startButton.setFont(new Font(70));
        startButton.setTextFill(Color.BLACK);
        firstGroup.getChildren().add(startButton);
        Scene firstScene = new Scene(firstGroup, 1850, 900, Color.WHITE);
        stage.setTitle("Game");
        stage.setScene(firstScene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}