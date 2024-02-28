package com.example.agrioofd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class Player {

    Player(Group group){
        Circle circle = new Circle(Math.random() * 20, Paint.valueOf("ff00ff"));
        circle.setCenterX(0 );
        circle.setCenterY(0);
        group.getChildren().add(circle);
    }
}
