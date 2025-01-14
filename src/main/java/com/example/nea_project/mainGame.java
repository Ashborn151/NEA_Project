package com.example.nea_project;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class mainGame {
    private final Stage stage;
    private final Scene firstScene;
    private final Scene secondScene;
    private final Scene thirdScene;

    public mainGame(Stage stage, Scene firstScene, Scene secondScene, Scene thirdScene){
        this.stage = stage;
        this.firstScene = firstScene;
        this.secondScene = secondScene;
        this.thirdScene = thirdScene;
    }

    public void showmainGame(){
        Group fourthGroup = new Group();

        Scene thirdScene = new Scene(fourthGroup, 1920, 1080, Color.BLACK);
        stage.setTitle("Game");
        stage.setScene(thirdScene);
        stage.show();
        stage.setMaximized(true);
    }
}
