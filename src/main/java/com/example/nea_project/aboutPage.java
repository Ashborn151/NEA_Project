package com.example.nea_project;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.Group;


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
        Button nextButton = createButton("Choose difficulty", 1500, 900);

        secondGroup.getChildren().addAll(text2, nextButton);

        Scene secondScene = new Scene(secondGroup, 1920, 1080, Color.BLACK);
        stage.setScene(secondScene);
        stage.setTitle("Game Details");
        stage.setMaximized(true);


        difficultyScene Page2 = new difficultyScene(stage, firstScene, secondScene);
        nextButton.setOnAction(e -> Page2.showdifficultyScene());

//        Timer myTime = new Timer();
//        myTime.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                Platform.runLater(() -> {
//                    Page2.showdifficultyScene();
//                });
//            }
//        },3000);

//        secondScene.setOnKeyPressed(keyEvent -> {
//            if (keyEvent.getCode() == KeyCode.ESCAPE) {
//                stage.setScene(firstScene);
//                stage.setTitle("Game");
//            }
//        });
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



