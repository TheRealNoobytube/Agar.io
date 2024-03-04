package com.example.agrioofd;


import javafx.scene.Group;
import javafx.scene.Node;
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
        foodSprite = new Circle(size, Paint.valueOf("aa2222"));
        foodSprite.setCenterX(Math.random() * (AgarioApplication.getMapLimitWidth() * 2) - AgarioApplication.getMapLimitWidth());
        foodSprite.setCenterY(Math.random() * (AgarioApplication.getMapLimitHeight() * 2) - AgarioApplication.getMapLimitHeight());
        group.getChildren().add(foodSprite);

    }
}
