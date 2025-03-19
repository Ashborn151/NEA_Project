package com.example.nea_project;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

import java.util.Timer;
import java.util.TimerTask;


public class Player extends Entity{


    Player(double X, double Y) {
        setX(X);
        setY(Y);
    }

    public double HealthPoints = 10;
    public double AttackDmg = 5;
    public double AttackRange = 50;
    public double AttackCD = 3000;
    public double lastAttackTime = 0;
    public double speed = 6.5;
    public double jumpSpeed = -20;
    public double gravity = 1;
    public double velocityY = 0;
    public boolean isJumping = false;
    public double groundY = 0;
    public double targetX = 50;
    public boolean aPressed = false;
    public boolean dPressed = false;
    public boolean spacePressed = false;
    public boolean gameOver = false;
    public boolean iFrame = false;
    public boolean isFalling = false;
    public boolean flag1 = true;
    public boolean flag2 = true;

    public void onCollisionDetected(){
        TakeDmg();
        System.out.println(HealthPoints);
    }

    public void playerMovement(Scene scene, Player player, Enemy enemy, Rectangle rectangle){
        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.D){
                dPressed = true;
            }
            if (keyEvent.getCode() == KeyCode.A){
                aPressed = true;
            }
            if (keyEvent.getCode() == KeyCode.SPACE || keyEvent.getCode() == KeyCode.W){
                spacePressed = true;
            }
        });

        scene.setOnKeyReleased(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.D){
                dPressed = false;
            }
            if (keyEvent.getCode() == KeyCode.A){
                aPressed = false;
            }
            if (keyEvent.getCode() == KeyCode.SPACE || keyEvent.getCode() == KeyCode.W){
                spacePressed = false;
            }
        });

        if (dPressed && player.getX()<2000) {
            targetX = player.getX() + speed;
//            System.out.println(player.getX());
            enemy.intersect(player, enemy);
        }
        if (aPressed && player.getX()>20) {
            targetX = player.getX() - speed;
//            System.out.println(player.getX());
            enemy.intersect(player, enemy);
        }
        if (spacePressed && !isJumping && !isFalling){
            groundY = player.getY();
            velocityY = jumpSpeed;
            isJumping = true;
            enemy.intersect(player, enemy);
        }

        if (player.getX() < targetX && player.getX()<2000) {
            player.setX(player.getX() + speed);
            rectangle.setX(player.getX() + 70);
            player.setScaleX(1);
            rectangle.setScaleX(1);
            enemy.intersect(player, enemy);
        } else if (player.getX() > targetX && player.getX()>20) {
            player.setX(player.getX() - speed);
            rectangle.setX(player.getX() - 20);
            player.setScaleX(-1);
            rectangle.setScaleX(-1);
            enemy.intersect(player, enemy);
        }

        if(isJumping || isFalling) {
            velocityY = velocityY + gravity; //relating to animation timer, the value of velocityY here is -14.
//This value will constantly increment all the way to 14 as you add gravity (1) each frame. It would go Player.getY + velocityY which would be 500 + (-14).
// Then it would go to 486 + (-13) as velocityY increments by 1 all the way to 395. Therefore, the change in the y coordinate would be 105 which is the triangle number of 14.
//Technically the change is 210 as the player goes up and then back down and that is 105 each which adds up to 210.
            player.setY((player.getY()) + velocityY);
            rectangle.setY((player.getY()) + 75);
//            System.out.println(player.getY());
//            System.out.println("This is velocityY "+velocityY);

            if(isJumping & player.getY() > groundY){
                if(player.getY() >= groundY ) {
//This conditions ensures that the player does not fall below their previous location and effectively stops them from infinitely falling downwards.
//Currently, this does not account for when there are differences in elevation but that will be fixed later when the map itself is added.
                    player.setY(groundY);
                    rectangle.setY(groundY + 75);
                    isJumping = false;
                    velocityY = 0;
                }
            }

        }

    }

    public void enemyCollision(Player player, Enemy enemy){
        if (enemy.intersect(player, enemy)){
//            HealthPoints--;
//            System.out.println(HealthPoints);
        }
    }

    public void playerDeath(Stage stage, Player player){
        if(HealthPoints <= 0 && !gameOver || player.getY() > 1080 && !gameOver) {
            gameOver = true;
            stage.close();
            DeathScene deathScene = new DeathScene();
            deathScene.showDeathScene();
        }
    }

    public void playerAttack(Scene scene, Player player, Enemy enemy, Timer timer, Rectangle rectangle){
        ColorAdjust colorAdjust = new ColorAdjust();
        scene.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY ){
                double distance = Math.sqrt(Math.pow(player.getX() - enemy.getX(),2) + Math.pow(player.getY() - enemy.getY(), 2));
                double actualAR = AttackRange + player.getFitWidth();
//                if(player.getBoundsInParent().intersects(enemy.getBoundsInParent()) && !AttackCD) {
                if(distance < actualAR){
                    rectangle.setVisible(true);
                    enemy.enemyTakeDmg(player, colorAdjust, rectangle, enemy);
                    colorAdjust.setHue(-1);
                    colorAdjust.setContrast(-1);
                    colorAdjust.setSaturation(-1);
                    enemy.setEffect(colorAdjust);
                }
            }
        });
    }


    public void TakeDmg(){
        if(!iFrame){
            HealthPoints--;
            iFrameInstance(new Timer());
        }
    }

    public void iFrameInstance(Timer timer){
        iFrame = true;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    iFrame = false;
                });
            }
        },900);
    }

    public void levelTwo(Player player, Stage stage, AnimationTimer animationTimer){
        if(player.getX() > 1930 && flag1){
            flag1 = false;
            double temp = player.HealthPoints;
            stage.close();
            LevelTwo levelTwo = new LevelTwo();
            levelTwo.showLevelTwo();
            player.HealthPoints = temp;
            animationTimer.stop();
        }
    }

    public void levelThree(Player player, Stage stage, AnimationTimer animationTimer){
        if(player.getX() > 1930 && flag2){
            flag2 = false;
            double temp = player.HealthPoints;
            stage.close();
            LevelThree levelThree = new LevelThree();
            levelThree.showLevelThree();
            player.HealthPoints = temp;
            animationTimer.stop();
        }
    }

    public  void showHealth(Text text){
        if(HealthPoints != 0){
            text.setText("HP: " + (int)HealthPoints);
        }
    }

    public void pause(){

    }



}
