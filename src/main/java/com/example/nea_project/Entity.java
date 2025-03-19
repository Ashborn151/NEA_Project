package com.example.nea_project;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Entity extends ImageView {

    public void update(){
        for (Node node : LevelOne.firstGroup.getChildren()){
            if (node instanceof Entity){
                if (node == this){
                    continue;
                }

                if (detectCollision((Entity)node)){
                    onCollisionDetected();
                }
            }
        }

        for(Node node : LevelTwo.secondGroup.getChildren()){
            if(node instanceof Entity){
                if (node == this){
                    continue;
                }

                if(detectCollision((Entity) node)){
                    onCollisionDetected();
                }
            }
        }

        for(Node node : LevelThree.thirdGroup.getChildren()){
            if(node instanceof Entity){
                if (node == this){
                    continue;
                }

                if(detectCollision((Entity) node)){
                    onCollisionDetected();
                }
            }
        }
    }



    public void onCollisionDetected(){

    }

    public Boolean detectCollision(Entity entity){
        double distance = Math.sqrt(Math.pow(entity.getX() - this.getX(),2) + Math.pow(entity.getY() - this.getY(), 2));
        double sumOfWidth = (this.getFitWidth()/2) + (entity.getFitWidth()/2);
        if(sumOfWidth >= distance){
//            System.out.println("True");
            return true;
        }
        else{
//            System.out.println("False");
            return false;
        }
    }

}
