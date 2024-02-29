package com.example.agrioofd;


import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Food {

    public Circle foodSprite;

    private Random random = new Random();
    Food(Group group, double size){

        //new player made and added to the group
        foodSprite = new Circle(size, Paint.valueOf("ff00ff"));
        foodSprite.setCenterX(Math.random() * AgarioApplication.getScreenWidth());
        foodSprite.setCenterY(Math.random() * AgarioApplication.getScreenHeight());
        group.getChildren().add(foodSprite);

    }
}
