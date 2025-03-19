package com.example.nea_project;

import javafx.scene.image.ImageView;

public class Obstacle extends ImageView {
    Obstacle(double X, double Y) {
        setX(X);
        setY(Y);
    }

    public void obstacleCollision(Player player, Obstacle obstacle){
        if(player.getBoundsInParent().intersects(obstacle.getBoundsInParent())){
            player.TakeDmg();
            System.out.println(player.HealthPoints);
        }
    }
}
