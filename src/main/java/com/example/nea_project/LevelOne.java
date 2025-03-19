package com.example.nea_project;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Timer;

public class LevelOne {
    public static Group firstGroup = new Group();
    public static ArrayList<Entity> toDelete = new ArrayList<>();

    public void showLevelOne(){
        Stage stage = new Stage();
        Timer myTimer1 = new Timer();
        Rectangle weapon = new Rectangle(120, 550, 50, 15);
        weapon.setFill(Color.BLACK);
        weapon.setVisible(false);

        Text healthText = new Text();
        Text enemyHealthText = new Text();

        Player player = new Player(50, 500);
        Enemy enemyOne = new Enemy(900, 540);
        Platform platform1 = new Platform(-1900, 670);
        Platform platform2 = new Platform(400, 500);
        Platform platform3 = new Platform(700, 350);
        Platform platform4 = new Platform(1100, 670);
        Platform platform5 = new Platform(1400, 670);

        Image Sprite1 = new Image("file:src/assets/Grimm_Idle.png");
        Image Sprite2 = new Image("file:src/assets/Platform1.png");
        Image Sprite4 = new Image("file:src/assets/NKG.png");
        Image Sprite5 = new Image("file:src/assets/TheKnight.png");
        Image Sprite6 = new Image("file:src/assets/pixel-art-knife.png");
        Image Sprite8 = new Image("file:src/assets/Platform1Smol.png");

        player.setImage(Sprite1);
        enemyOne.setImage(Sprite5);
        platform1.setImage(Sprite2);
        platform2.setImage(Sprite8);
        platform3.setImage(Sprite8);
        platform4.setImage(Sprite8);
        platform5.setImage(Sprite8);
        ImageView weapon1 = new ImageView(Sprite6);
        weapon1.setX(120);
        weapon1.setY(550);

        player.setFitWidth(100);
        player.setFitHeight(200);
        enemyOne.setFitWidth(Sprite5.getWidth());
        enemyOne.setFitHeight(Sprite5.getHeight());
        platform4.setFitWidth(320);
        platform5.setFitWidth(2000);

        healthText.setTextAlignment(TextAlignment.CENTER);
        healthText.setX(40);
        healthText.setY(40);
        healthText.setFill(Color.BLACK);
        healthText.setFont(new Font(30));

        enemyHealthText.setTextAlignment(TextAlignment.CENTER);
        enemyHealthText.setX(1800);
        enemyHealthText.setY(40);
        enemyHealthText.setFill(Color.BLACK);
        enemyHealthText.setFont(new Font(30));



        firstGroup.getChildren().addAll(player, enemyOne, platform1, platform2, platform3, platform4, platform5, weapon, healthText, enemyHealthText);
        Scene firstScene = new Scene(firstGroup, 1920, 1080, Color.DARKGRAY); //creates the scene where the title of the game and the buttons exist. Sets dimensions of 1920 by 1000.
        stage.setTitle("Game"); //sets the title of the scene as "Game"
        stage.setScene(firstScene); //sets the scene firstScene
        stage.show(); //displays firstScene on the display
        stage.setMaximized(true);


         AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                for (Node node : firstGroup.getChildren()){
                    if(node instanceof Entity){
                        ((Entity) node).update();
                    }
                }


                player.playerMovement(firstScene, player, enemyOne, weapon);
                player.playerDeath(stage, player);
                player.playerAttack(firstScene, player, enemyOne, myTimer1, weapon);
                platform1.platformCollision(player, enemyOne, platform1.platformUpdate(player, platform1, platform2, platform3, platform4, platform5));
                enemyOne.enemyMovement(enemyOne, player);
                enemyOne.enemyDeath();
//                enemyOne.isFalling(enemyOne, platform1);
                player.showHealth(healthText);
                enemyOne.showEnemyHealth(enemyHealthText);

                firstGroup.getChildren().removeAll(toDelete);
                toDelete.clear();
            }
        };
        timer.start();
         AnimationTimer otherTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                player.levelTwo(player, stage, timer);

            }
        };
        otherTimer.start();

    }

    public static void ListDelete(Entity node){
        toDelete.add(node);
    }

}
