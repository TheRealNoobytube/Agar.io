package com.example.agrioofd;


import javafx.animation.AnimationTimer;
import javafx.application.Application;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;


public class AgarioApplication extends Application {

    public class GameTimer extends AnimationTimer{

        private double framesPerSecond = 120;
        private double interval = 1000000000 / framesPerSecond;
        private double last = 0;
        @Override
        public void handle(long now) {
            if (now - last > interval ){
                update(); //calls update function every frame
            }
        }
    }

    public static Group root = new Group();
    static private double ScreenWidth = 640;
    static private double ScreenHeight = 480;

    Player player;

    @Override
    public void start(Stage stage) throws IOException {
        //create a player object, add it to the group, the initial radius 50
        player = new Player(root, 50);

        //start the gametimer
        GameTimer timer = new GameTimer();
        timer.start();

        Scene scene = new Scene(root, ScreenWidth, ScreenHeight);
        scene.setCamera(player.camera);


        stage.setTitle("Agar.io");
        stage.setScene(scene);

        stage.show();


    }

    static public double getScreenWidth(){
        return ScreenWidth;
    }
    static public double getScreenHeight(){
        return ScreenHeight;
    }
    static public double[] getMousePosition(){
        Point mouse = java.awt.MouseInfo.getPointerInfo().getLocation();
        Point2D mousePos = root.screenToLocal(mouse.x, mouse.y);
        return new double[]{mousePos.getX(), mousePos.getY()};
    }


    public static void main(String[] args) {
        launch();
    }


    public void update(){
        //does something every frame, put actions in here

        //move player towards the mouse position
        player.moveToward(getMousePosition());
        player.checkCollision();
        createFood();


    }
    
    public void createFood(){
        Food food = new Food(root, 10);
    }
}