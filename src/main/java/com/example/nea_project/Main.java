package com.example.nea_project;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        mainMenu mainMenu = new mainMenu(stage);
        mainMenu.initialise();
        // creates an instance of the class mainMenu and uses the initialise method to set up the instance just created
    }

    public static void main(String[] args) {
        launch();
    }
}