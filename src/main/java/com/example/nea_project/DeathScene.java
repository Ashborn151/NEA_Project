package com.example.nea_project;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DeathScene {


    public void showDeathScene(){
        Stage stage = new Stage();
        Group deathGroup = new Group();
        Text deathText = new Text();
        Scene deathScene = new Scene(deathGroup, 1920, 1080, Color.BLACK);

        deathText.setText("Skill issue...");
        deathText.setX(855);
        deathText.setY(400);
        deathText.setFill(Color.WHITE);
        deathText.setFont(new Font(100));

        deathGroup.getChildren().add(deathText);

        stage.setTitle("Death");
        stage.setScene(deathScene);
        stage.show();
        stage.setMaximized(true);

    }
}