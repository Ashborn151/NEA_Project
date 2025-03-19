package com.example.nea_project;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class Enemy extends Entity {

    Enemy(double X, double Y) {
        setX(X);
        setY(Y);
    }

    public double HealthPoints = 50;
    public double speed = 3;
    public double velocityY = 0;
    public double gravity = 1;
    public boolean isFalling = false;
    public boolean enemyIframe = false;


    public Boolean intersect(Player player, Enemy enemy){
        double distance = Math.sqrt(Math.pow(enemy.getX() - player.getX(),2) + Math.pow(enemy.getY() - player.getY(), 2));
        double sumOfWidth = (player.getFitWidth()/2) + (enemy.getFitWidth()/2);
        if(sumOfWidth >= distance){
//            System.out.println("True");
            return true;
        }
        else{
//            System.out.println("False");
            return false;
        }
    }

    public void enemyDeath() {
        if (HealthPoints <= 0) {
            LevelOne.ListDelete(this);
        }
    }

    public boolean enemyAggro(Player player, Enemy enemy){
        double aggroRange = 300;
        if(player.getX() > enemy.getX() - aggroRange && player.getX() < enemy.getX() || player.getX() < enemy.getX() + aggroRange && player.getX() > enemy.getX()){
            return true;
        }
        return false;
    }

    public boolean projectileAggro(Projectile projectile, Enemy enemy){
        double projectileAggroRange = 1000;
        if(projectile.getCenterX() > enemy.getX() - projectileAggroRange && projectile.getCenterX() < enemy.getX() ||
                projectile.getCenterX() < enemy.getX() + projectileAggroRange && projectile.getCenterX() > enemy.getX()){
            return true;
        }
        return false;
    }

    public void enemyMovement(Enemy enemy, Player player){
        if(enemy.getX() > player.getX() && enemyAggro(player, enemy)) {
            enemy.setX(enemy.getX() - speed);
            enemy.setScaleX(1);
        } else if (enemy.getX() < player.getX() && enemyAggro(player, enemy)) {
            enemy.setX(enemy.getX() + speed);
            enemy.setScaleX(-1);
        }
    }

    public void isFalling(Enemy enemy, Platform platform){
        if(!enemy.getBoundsInParent().intersects(platform.getBoundsInParent())){
            isFalling = true;
        }

        if(isFalling){
            velocityY += gravity;
            enemy.setY(enemy.getY() + velocityY);
            if(enemy.getY() > 1080){
                LevelOne.ListDelete(this);
            }

        }

    }

    public  void showEnemyHealth(Text text){
        if(HealthPoints > 0){
            text.setText("HP: " + (int)HealthPoints);
        }
        else {
            text.setText("");
        }
    }

    public void enemyTakeDmg(Player player, ColorAdjust colorAdjust, Rectangle rectangle, Enemy enemy){
        if(!enemyIframe){
            HealthPoints = HealthPoints - player.AttackDmg;
            enemyIframeInstance(new Timer(), colorAdjust, rectangle, enemy);
        }
    }

    public void enemyIframeInstance(Timer timer, ColorAdjust colorAdjust, Rectangle rectangle, Enemy enemy){
        enemyIframe = true;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                javafx.application.Platform.runLater(()->{
                    enemyIframe = false;
                    rectangle.setVisible(false);
                    colorAdjust.setHue(0);
                    colorAdjust.setContrast(0);
                    colorAdjust.setSaturation(0);
                    enemy.setEffect(colorAdjust);
                });
            }
        },900);
    }






}
