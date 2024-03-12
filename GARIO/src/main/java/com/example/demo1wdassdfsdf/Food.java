package com.example.demo1wdassdfsdf;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Food{

    public double Mass;
    public Circle foodSprite;

    private Random random = new Random();

    Food(Group group, double size, double mass){

        Mass = mass;

        //new player made and added to the group
        Random rand = new Random();
        int r = rand.nextInt(255);
        int g  = rand.nextInt(255);
        int b  = rand.nextInt(255);

        foodSprite = new Circle(size, Color.rgb(r, g , b, 0.99));
        foodSprite.setCenterX(Math.random() * (AgarioApplication.getMapLimitWidth() * 2) - AgarioApplication.getMapLimitWidth());
        foodSprite.setCenterY(Math.random() * (AgarioApplication.getMapLimitHeight() * 2) - AgarioApplication.getMapLimitHeight());
        group.getChildren().add(foodSprite);

    }
}
