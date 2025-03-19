package com.example.nea_project;

import javafx.application.Application;
import javafx.stage.Stage;

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