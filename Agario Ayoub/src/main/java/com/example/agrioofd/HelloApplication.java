package com.example.agrioofd;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;




public class HelloApplication extends Application {

    double ScreenWidth = 640;
    double ScreenHeight = 480;

    @Override
    public void start(Stage stage) throws IOException {
        Group newGroup = new Group();

        Player player = new Player(newGroup);


        Scene scene = new Scene(newGroup, ScreenWidth, ScreenHeight);
        stage.setTitle("Agar.io");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}