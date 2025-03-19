package com.example.nea_project;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Timer;

public class LevelThree {
    public static Group thirdGroup = new Group();

    public void showLevelThree(){
        Stage stage = new Stage();
        Rectangle weapon = new Rectangle(120, 550, 50, 15);
        Text healthText = new Text();
        Text enemyHealthText = new Text();
        weapon.setVisible(false);

        Timer myTimer = new Timer();
        Player player = new Player(50,500);
        Boss boss = new Boss(900, 540);
        Platform platform1 = new Platform(0, 500);
        Platform platform2 = new Platform(0, 670);
        Obstacle obstacle = new Obstacle(300, 580);
        Obstacle obstacle2 = new Obstacle(1200, 580);
//        Platform platform3 = new Platform(0, 500);
//        Platform platform4 = new Platform(0, 500);

        Image Sprite1 = new Image("file:src/assets/Grimm_Idle.png");
        Image Sprite2 = new Image("file:src/assets/Platform1Smol.png");
        Image Sprite3 = new Image("file:src/assets/TheKnight.png");
        Image Sprite4 = new Image("file:src/assets/Platform1.png");
        Image Sprite5 = new Image("file:src/assets/spikesSmol.png");
        player.setImage(Sprite1);
        player.setFitWidth(100);
        player.setFitHeight(200);
        boss.setImage(Sprite3);
        obstacle.setImage(Sprite5);
        obstacle2.setImage(Sprite5);
//        platform1.setImage(Sprite2);
        platform2.setImage(Sprite4);

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

        boss.setFitWidth(Sprite3.getWidth());
        boss.setFitHeight(Sprite3.getHeight());

        thirdGroup.getChildren().addAll(player, boss, platform2, obstacle, obstacle2, healthText, weapon, enemyHealthText);
        Scene thirdScene = new Scene(thirdGroup, 1920, 1080, Color.DARKGRAY);
        stage.setTitle("Game");
        stage.setScene(thirdScene);
        stage.show();
        stage.setMaximized(true);

        final AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                for (Node node : thirdGroup.getChildren()){
                    if(node instanceof Entity){
                        ((Entity) node).update();
                    }
                }

                player.playerMovement(thirdScene, player, boss, weapon);
                player.playerDeath(stage, player);
                player.playerAttack(thirdScene, player, boss, myTimer, weapon);
                platform1.platformCollision(player, boss, platform2.platformUpdate(player, platform2, platform2, platform2, platform2, platform2));
                boss.enemyMovement(boss, player);
                boss.enemyDeath();
                obstacle.obstacleCollision(player, obstacle);
                obstacle2.obstacleCollision(player, obstacle2);
//                enemyTwo.isFalling(enemyTwo, platform1);
//                boss.projectileAttacks(boss, player, circle);
                player.showHealth(healthText);
                boss.showEnemyHealth(enemyHealthText);

                thirdGroup.getChildren().removeAll(LevelOne.toDelete);
                LevelOne.toDelete.clear();
            }
        };
        timer.start();
    }
}
