package com.example.nea_project;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class difficultyScene {
    private final Stage stage;
    private final Scene firstScene;
    private final Scene secondScene;
    public boolean flag = true;

    public difficultyScene(Stage stage, Scene firstScene, Scene secondScene) {
        this.stage = stage;
        this.firstScene = firstScene;
        this.secondScene = secondScene;
    }

    public void showdifficultyScene(){
        Group thirdGroup = new Group();

        Text text3 = new Text();
        text3.setTextAlignment(TextAlignment.CENTER);
        text3.setText("Choose your difficulty:");
        text3.setFont(new Font(45));
        text3.setX(800);
        text3.setY(400);
        text3.setFill(Color.WHITE);

        Button NeutralDiff = createButton("Neutral", 855, 450);
        Button ChallengingDiff = createButton("Challenging", 855, 570);
        Button ChaoticDiff = createButton("Chaotic",855, 690);

        thirdGroup.getChildren().addAll(NeutralDiff, ChallengingDiff, ChaoticDiff, text3);

        Scene thirdScene = new Scene(thirdGroup, 1920, 1080, Color.BLACK); //creates the scene where the title of the game and the buttons exist. Sets dimensions of 1920 by 1000.
        stage.setTitle("Game"); //sets the title of the scene as "Game"
        stage.setScene(thirdScene); //sets the scene firstScene
        stage.show(); //displays firstScene on the display
        stage.setMaximized(true);

        LevelOne levelOne = new LevelOne();



        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if((NeutralDiff.isPressed() || ChallengingDiff.isPressed() || ChaoticDiff.isPressed()) && flag){
                    flag = false;
                    levelOne.showLevelOne();
                    stage.close();
                }
            }
        };
        timer.start();



    }
    private Button createButton(String text, double x, double y) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: white; -fx-cursor: hand");
        button.setFont(new Font(45));
        button.setMinWidth(300);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setTextFill(Color.BLACK);

        button.setOnMouseEntered(mouseEvent -> button.setStyle("-fx-background-color: cyan"));
        button.setOnMouseExited(mouseEvent -> button.setStyle("-fx-background-color: white"));

        return button;
    }
}
