package com.example.demo1wdassdfsdf;


import javafx.scene.Group;
import javafx.scene.shape.Circle;


public class Food extends Entity{


    Food(Group group, double size){
        super(group, size);
        Sprite.setCenterX(Math.random() * (AgarioApplication.getMapLimitWidth() * 2) - AgarioApplication.getMapLimitWidth());
        Sprite.setCenterY(Math.random() * (AgarioApplication.getMapLimitHeight() * 2) - AgarioApplication.getMapLimitHeight());

    }
}
