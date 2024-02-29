package com.example.agrioofd;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;




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

    public Group root = new Group();
    static private double[] mousePosition = {0,0};
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



        //create an eventhandler which detects when the mouse is moving
        EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //get the mouse x position and mouse y position
                mousePosition[0] = mouseEvent.getSceneX();

                mousePosition[1] = mouseEvent.getSceneY();
            }
        };

        Scene scene = new Scene(root, ScreenWidth, ScreenHeight);
        //add the eventhandler to the scene
        scene.addEventFilter(MouseEvent.MOUSE_MOVED, handler);
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
        return mousePosition;
    }


    public static void main(String[] args) {
        launch();
    }


    public void update(){
        //does something every frame, put actions in here

        //move player towards the mouse position
        player.moveToward(mousePosition);
        //Food food = new Food(root, 10);


    }
    
    public void createFood(){
        Food food = new Food(root, 10);
    }
}