package com.example.nea_project;

import javafx.scene.shape.Circle;

import java.util.Timer;

public class Boss extends Enemy{

    Boss(double X, double Y) {
        super(X, Y);
    }


    public void projectileAttacks(Boss boss, Player player, Circle circle){
        Projectile projectile = new Projectile();
        Timer timer = new Timer();

//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                Platform.runLater(()->{
//
//                });
//            }
//        },2000);

//        projectile.spawnProjectiles(projectile, boss);

        if(projectileAggro(projectile, boss) && player.getX() < boss.getX()){

            double placeHolder = projectile.getCenterX() - projectile.projectileSpeed;
            projectile.setCenterX(placeHolder);
            LevelTwo.secondGroup.getChildren().add(projectile);
            if(player.getBoundsInParent().intersects(projectile.getBoundsInParent())) {
                player.TakeDmg();


            }

        } else if (projectileAggro(projectile, boss) && player.getX() > boss.getX()) {

            double placeHolder2 = projectile.getCenterX() + projectile.projectileSpeed;
            projectile.setCenterX(placeHolder2);
            LevelTwo.secondGroup.getChildren().add(projectile);
            if(player.getBoundsInParent().intersects(projectile.getBoundsInParent())) {
                player.TakeDmg();

            }
        }
    }
}

