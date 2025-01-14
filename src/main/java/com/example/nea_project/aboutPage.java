package com.example.nea_project;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
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

public class aboutPage {
    private final Stage stage;
    private final Scene firstScene;

    public aboutPage(Stage stage, Scene firstScene) {
        this.stage = stage;
        this.firstScene = firstScene;
    }

    public void showaboutPage() {
        Group secondGroup = new Group();

        Text text2 = new Text();
        text2.setTextAlignment(TextAlignment.CENTER);
        text2.setText("About \n This game is a sidescroller game similar to popular games such as Hollow Knight and Cuphead. \n" +
                "You will fight against several enemies and bosses that will test your skills to dodge against enemy attacks, \n" +
                "dodge any obstacles while also dealing damage to the enemies and defeating them.\n\n Controls:\n" +
                "A - move left\nD - move right\nMouse Right Click - attack\nSpace - jump\nESC - open exit menu");
        text2.setX(300);
        text2.setY(200);
        text2.setFill(Color.WHITE);
        text2.setFont(new Font(30));

        secondGroup.getChildren().add(text2);

        Scene secondScene = new Scene(secondGroup, 1920, 1080, Color.BLACK);
        stage.setScene(secondScene);
        stage.setTitle("Game Details");
        stage.setMaximized(true);

        difficultyScene Page2 = new difficultyScene(stage, firstScene, secondScene);

        Timer myTime = new Timer();
        myTime.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    Page2.showdifficultyScene();
                });
            }
        },3000);

//        secondScene.setOnKeyPressed(keyEvent -> {
//            if (keyEvent.getCode() == KeyCode.ESCAPE) {
//                stage.setScene(firstScene);
//                stage.setTitle("Game");
//            }
//        });
    }
}



