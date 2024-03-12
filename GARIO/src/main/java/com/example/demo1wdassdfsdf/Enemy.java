package com.example.demo1wdassdfsdf;

import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Enemy extends MoveableBody{


    Enemy(Group group, double initialSize){
        //new Enemy made and added to the group

        Sprite = new Circle(initialSize, Paint.valueOf("00ff00"));
        Sprite.setCenterX((Math.random() * AgarioApplication.getMapLimitWidth() * 2) - AgarioApplication.getMapLimitWidth());
        Sprite.setCenterY((Math.random() * AgarioApplication.getMapLimitHeight() * 2) - AgarioApplication.getMapLimitHeight());

        //puts the Enemy infront of all the food
        //puts bigger entities in front of smaller entities
        Sprite.setViewOrder(-Sprite.getRadius());

        AgarioApplication.Enemies.add(this);
        group.getChildren().add(Sprite);
    }

    @Override
    public void Update(){
        //move player towards the mouse position
        moveToward(AgarioApplication.player.getPosition());

        //check if player is colliding with anything
        checkCollision();
    }
}
