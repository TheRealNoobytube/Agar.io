package com.example.agariogame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

public class Menu extends VBox {
    public Menu() {
        //Game Name set
        Label label = new Label("Agar.io");
        label.setFont(new Font("Arial", 60));

        //Background image


        // Add buttons
        Button startButton = new Button("Start");
        Button changeSkinButton = new Button("Change Skin");
        Button changeName = new Button("Change Name");
        Button exitButton = new Button("Exit");

        // Set actions for buttons
        startButton.setOnAction(e -> handleStartButton());
        changeSkinButton.setOnAction(e -> handleChangeSkinButton());
        changeName.setOnAction(e -> handleChangeNameButton());
        exitButton.setOnAction(e -> handleExitButton());

        // Set spacing and alignment
        setSpacing(40);
        setAlignment(Pos.CENTER);

        // Add buttons to the layout
        getChildren().addAll(label, startButton, changeSkinButton, changeName, exitButton);
    }

    // Button event handlers
    private void handleStartButton() {
        // Implement logic for start button click
        System.out.println("Start button clicked");
    }

    private void handleChangeSkinButton() {
        // Implement logic for change skin button click
        System.out.println("Change Skin button clicked");
    }

    private void handleExitButton() {
        // Implement logic for exit button click
        System.out.println("Exit button clicked");
    }

    private void handleChangeNameButton() {
        // Implement logic for change name button click
        System.out.println("Change Name button clicked");
    }
}