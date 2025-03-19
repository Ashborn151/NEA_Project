package com.example.nea_project;

import javafx.scene.image.ImageView;

public class Platform extends ImageView {
    public Platform(double X, double Y) {
        setX(X);
        setY(Y);
    }

    public boolean isOnPlatform = false;


    public boolean platformCollision(Player player, Enemy enemy, Platform platform){
        if(player.getBoundsInParent().intersects(platform.getBoundsInParent())){
            player.isFalling = false;
            isOnPlatform = true;
        }
        else{
            isOnPlatform = false;
        }

        if(isOnPlatform && player.getBoundsInParent().intersects(platform.getBoundsInParent()) && !player.isFalling){
            player.setY(platform.getY() - player.getFitHeight());
            player.isJumping = false;
            return true;
        }
        else{
            isOnPlatform = false;
            player.isFalling = true;
        }
        return false;
    }

    public Platform platformUpdate(Player player, Platform platform1, Platform platform2, Platform platform3, Platform platform4, Platform platform5){
        if(player.getBoundsInParent().intersects(platform1.getBoundsInParent())){
            player.groundY = platform1.getY();
            return platform1;
        }
        else if (player.getBoundsInParent().intersects(platform2.getBoundsInParent())) {
            player.groundY = platform2.getY();
            return platform2;
        }
        else if (player.getBoundsInParent().intersects(platform3.getBoundsInParent())) {
            player.groundY = platform3.getY();
            return platform3;
        }
        else if (player.getBoundsInParent().intersects(platform4.getBoundsInParent())) {
            player.groundY = platform4.getY();
            return platform4;
        }
        else if (player.getBoundsInParent().intersects(platform5.getBoundsInParent())) {
            player.groundY = platform5.getY();
            return platform5;
        }

        return platform1;
    }
}