package com.example.agariogame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws FileNotFoundException{
        Menu menu = new Menu();
        Scene scene = new Scene(menu, 400, 300);
        primaryStage.setTitle("Agar.io Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}