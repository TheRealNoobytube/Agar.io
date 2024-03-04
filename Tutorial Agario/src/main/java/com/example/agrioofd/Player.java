package com.example.agrioofd;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.ParallelCamera;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Player{
    private double foodValue = 0.1;

    public ParallelCamera camera = new ParallelCamera(); // creates a camera for the player
    
    public double Speed = 1; // self explanatory, the player's speed
    public double Smoothing = 80; // higher numbers mean more smoothing, but also slower circle


    public Circle playerSprite; // the player's sprite

    Player(Group group, double initialSize){

        //new player made and added to the group

        playerSprite = new Circle(initialSize, Paint.valueOf("ff5555"));
        playerSprite.setCenterX(0);
        playerSprite.setCenterY(0);

        //puts the player infront of all the food
        playerSprite.setViewOrder(-1);

        group.getChildren().add(playerSprite);
    }


    public void checkCollision(){
        //go through each of the children of the root scene
        for(Node collider : AgarioApplication.root.getChildren()){ 

            //make sure we dont check if the player is colliding with the player
            if ((Shape) collider != playerSprite){

                //checks if the player is intersecting with the current child that we're looking at
                Shape intersect = Shape.intersect(playerSprite, (Shape) collider);

                //if the player is colliding with something, increase the players size and remove the food from the scene
                //this value will only be -1 if the player is colliding with nothing
                if (intersect.getBoundsInLocal().getWidth() != -1){
                    increaseSize(collider);

                    //removes the child from the scene
                    AgarioApplication.queueFree(collider);
                }
            }
        }
    }


    private void increaseSize(Node food){
        //called whenever the player eats food
        //once the player gets big enough, we want the camera to start zooming out
        playerSprite.setRadius(playerSprite.getRadius() + foodValue);

        //zoom out the camera when the player gets too big
        if (playerSprite.getRadius() > 70){
            camera.setScaleX(camera.getScaleX() + foodValue / 200);
            camera.setScaleY(camera.getScaleX() + foodValue / 200);
            
        }
    }


    public void moveToward(double[] position) {

        //initalize velocity, which is the mouse position - player position
        double[] velocity = {position[0] - playerSprite.getCenterX(), position[1] - playerSprite.getCenterY()};

        //used for the smooth movement depending on how far away the mouse is.
        //further away from the circle, the faster the movement is etc.
    
        double magnitudeSmoothing = Math.sqrt( (velocity[0] * velocity[0]) + (velocity[1] * velocity[1])) / Smoothing;

        if (magnitudeSmoothing > 4){
            magnitudeSmoothing = 4;
        }
        //normalize the position the player is going towards to get the direction
        velocity = normalizeDouble(velocity);

        //multiply direction by Speed to get the final velocity value, multiply smoothing for smoother movement
        velocity[0] *= Speed * magnitudeSmoothing;
        velocity[1] *= Speed * magnitudeSmoothing;

        //change playersprite position based on velocity
        //also check if the player is at the world limit, if it is then it doesnt move
        if (playerSprite.getCenterX() + velocity[0] < AgarioApplication.getMapLimitWidth()){
            if (playerSprite.getCenterX() + velocity[0] > -AgarioApplication.getMapLimitWidth()){
                playerSprite.setCenterX(playerSprite.getCenterX() + velocity[0] );
            }
        }
        if (playerSprite.getCenterY() + velocity[1] < AgarioApplication.getMapLimitHeight()){
            if (playerSprite.getCenterY() + velocity[1] > -AgarioApplication.getMapLimitHeight()){
                playerSprite.setCenterY(playerSprite.getCenterY() + velocity[1]);
            }
        }
        
        //set the position of the camera to the same position as the player
        //minus by half of the screen resolution, keep the player in the middle of the screen
        camera.setLayoutX((playerSprite.getCenterX() + velocity[0]) - AgarioApplication.getScreenWidth() / 2 * camera.getScaleX());
        camera.setLayoutY((playerSprite.getCenterY() + velocity[1])  - AgarioApplication.getScreenHeight() / 2 * camera.getScaleY());
    }


    public double[] normalizeDouble(double[] array){
        //don't worry about it :)

        double magnitude = Math.sqrt( (array[0] * array[0]) + (array[1] * array[1]) );

        if (array[0] != 0 || array[1] != 0 ){
            return new double[]{array[0] / magnitude, array[1] / magnitude};
        }
        return new double[]{0,0};
    }

}
