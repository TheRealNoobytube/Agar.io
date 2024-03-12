package com.example.demo1wdassdfsdf;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.ParallelCamera;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Player extends MoveableBody{

    public ParallelCamera camera = new ParallelCamera(); // creates a camera for the player
    

    Player(Group group, double initialSize){

        //new player made and added to the group

        Sprite = new Circle(initialSize, Paint.valueOf("ff5555"));
        Sprite.setCenterX(0);
        Sprite.setCenterY(0);

        //puts the player infront of all the food
        Sprite.setViewOrder(-Sprite.getRadius());

        group.getChildren().add(Sprite);
    }
    public void increaseSize(double foodValue){
        super.increaseSize(foodValue);
        //zoom out the camera when the player gets too big
        if (Sprite.getRadius() > 70){
            camera.setScaleX(camera.getScaleX() + foodValue / 200);
            camera.setScaleY(camera.getScaleX() + foodValue / 200);
        }

    }

    public void moveToward(double[] velocity) {
        super.moveToward(velocity);
        velocity = normalizeDouble(velocity);
        //set the position of the camera to the same position as the player
        //minus by half of the screen resolution, keep the player in the middle of the screen
        camera.setLayoutX((Sprite.getCenterX() + velocity[0]) - AgarioApplication.getScreenWidth() / 2 * camera.getScaleX());
        camera.setLayoutY((Sprite.getCenterY() + velocity[1])  - AgarioApplication.getScreenHeight() / 2 * camera.getScaleY());
    }



    public void gameOver(){
        AgarioApplication.queueFree(Sprite);
    }
    @Override
    public void Update(){
        //move player towards the mouse position
        moveToward(AgarioApplication.getMousePosition());

        //check if player is colliding with anything
        checkCollision();
    }



}
