package com.example.agrioofd;


import javafx.animation.AnimationTimer;
import javafx.application.Application;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;


public class AgarioApplication extends Application {


    public class GameTimer extends AnimationTimer{

        private double framesPerSecond = 120;
        private double interval = 1000000000 / framesPerSecond;
        private double last = 0;
        @Override
        public void handle(long now) {

            if (last == 0){
                last = now;
            }

            if (now - last > interval ){
                last = now;
                freeQueuedObjects(); // deletes any objects queued up to be free
                update(); //calls update function every frame

            }
        }
    }


    private static Scene scene;
    public static Group root = new Group();
    static private double mapLimitWidth = 500;
    static private double mapLimitHeight = 500;
    static private double ScreenWidth = 640;
    static private double ScreenHeight = 480;
    static private ArrayList queuedObjectsForDeletion = new ArrayList<>();

    Player player;
    Enemy enemy;

    @Override
    public void start(Stage stage) throws IOException {
        //create a player object, add it to the group, the initial radius 50
        player = new Player(root, 50);
        enemy = new Enemy(root, 50 );

        //start the gametimer
        GameTimer timer = new GameTimer();
        timer.start();

        scene = new Scene(root, ScreenWidth, ScreenHeight, Paint.valueOf("afafaf"));
        //set the camera to the players camera, which will follow the player
        scene.setCamera(player.camera);


        stage.setTitle("Agar.io");
        stage.setScene(scene);

        stage.show();


    }

    static public double getScreenWidth(){
        return scene.getWindow().getWidth();
    }
    static public double getScreenHeight(){
        return scene.getWindow().getHeight();
    }
    static public double getMapLimitWidth(){
        return mapLimitWidth;
    }
    static public double getMapLimitHeight(){
        return mapLimitHeight;
    }


    static public double[] getMousePosition(){
        java.awt.Point mouse = java.awt.MouseInfo.getPointerInfo().getLocation();
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
        enemy.moveToward(new double[]{player.playerSprite.getCenterX(), player.playerSprite.getCenterY()});
        //check if player is colliding with anything
        player.checkCollision();
        createFood();



    }
    
    public void createFood(){
        Food food = new Food(root, 10, 1);
    }


    public static void queueFree(Object object){
        //there are errors when deleting objects inbetween of frames, mostly just unsafe in general
        //so when you want to delete an object, reference AgarioApplication and call this function queueFree
        //e.g. AgarioApplication.queueFree(foodSprite);
        //puts objects in a dynamic array, just means an array that doesnt have a fixed size
        //every frame before the update function is called, the objects in the queue will be deleted
        queuedObjectsForDeletion.add(object);
    }

    private void freeQueuedObjects(){
        //deletes all objects in the queue
        //complicated to explain why we have to do it this way
        //just know if we dont, there will be tons of lag and errors every frame
        root.getChildren().removeAll(queuedObjectsForDeletion);
        queuedObjectsForDeletion.clear();

    }
}