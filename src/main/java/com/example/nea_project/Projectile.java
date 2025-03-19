package com.example.nea_project;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Projectile extends Circle {



    public double projectileSpeed = 100;
    public boolean projectilePierce = false;


    public void spawnProjectiles(Projectile projectile, Boss boss){

        projectile.setCenterX(930);
        projectile.setCenterY(607);
        projectile.setRadius(20);
        projectile.setFill(Color.RED);
    }
}
