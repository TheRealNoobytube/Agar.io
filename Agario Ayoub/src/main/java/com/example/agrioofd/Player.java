package com.example.agrioofd;


import javafx.scene.Group;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Player{
    public double Speed = 1; // self explanatory, the player's speed
    public double Smoothing = 40; // higher numbers mean more smoothing, but also slower circle
    public Circle playerSprite; // the player's sprite

    Player(Group group, double initialSize){

        //new player made and added to the group
        playerSprite = new Circle(initialSize, Paint.valueOf("ff00ff"));
        playerSprite.setCenterX(0);
        playerSprite.setCenterY(0);
        group.getChildren().add(playerSprite);

    }

    public void moveToward(double[] position) {

        //initalize velocity, which is the mouse position - player position
        double[] velocity = {position[0] - playerSprite.getCenterX(), position[1] - playerSprite.getCenterY()};

        //used for the smooth movement depending on how far away the mouse is.
        //further away from the circle, the faster the movement is etc.
        double magnitudeSmoothing = Math.sqrt( (velocity[0] * velocity[0]) + (velocity[1] * velocity[1])) / Smoothing;

        //normalize to get the direction
        velocity = normalizeDouble(velocity);

        //multiply direction by Speed to get the final velocity value, multiply smoothing for smoother movement
        velocity[0] *= Speed * magnitudeSmoothing;
        velocity[1] *= Speed * magnitudeSmoothing;

        //change playersprite position based on velocity
        playerSprite.setCenterX(playerSprite.getCenterX() + velocity[0] );
        playerSprite.setCenterY(playerSprite.getCenterY() + velocity[1]);


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
