package com.example.nea_project;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.Group;

public class mainMenu{
    private final Stage stage;

    public mainMenu(Stage stage){
        this.stage = stage;
    }
    public void initialise() {
        Group firstGroup = new Group();

        Text text1 = new Text("Game");
        text1.setX(855);
        text1.setY(400); //setX and setY set the position of the text "Game" on the scene by placing the text at position 855 on the x coordinate and 400 on the y coordinate
        text1.setFill(Color.WHITE); //sets the colour of the text to white
        text1.setFont(new Font(100)); //sets the font of the text to 100

        Button startButton = createButton("Start Game", 855, 450);
        Button AboutButton = createButton("About", 855, 570);
        Button exitButton = createButton("Exit Game", 855, 690);
        //uses the createButton method to make three different buttons

        firstGroup.getChildren().addAll(startButton, AboutButton, exitButton, text1);

        Scene firstScene = new Scene(firstGroup, 1920, 1080, Color.BLACK); //creates the scene where the title of the game and the buttons exist. Sets dimensions of 1920 by 1000.
        stage.setTitle("Game"); //sets the title of the scene as "Game"
        stage.setScene(firstScene); //sets the scene firstScene
        stage.show(); //displays firstScene on the display
        stage.setMaximized(true);

        aboutPage Page1 = new aboutPage(stage, firstScene); //creates a new instance of the class aboutPage
        about Page01 = new about(stage, firstScene); //creates a new instance of the class about

        startButton.setOnAction(e -> Page1.showaboutPage());
        AboutButton.setOnAction(e -> Page01.showabout());
        exitButton.setOnAction(e -> stage.close());
        // links each button to an event when clicked. Clicking the startButton calls the method that displays the aboutPage class. Clicking the aboutButton calls the method that displays the about class. Clicking the exitButton closes the scene.
    }

        private Button createButton(String text, double x, double y) {
            Button button = new Button(text);
            button.setStyle("-fx-background-color: white; -fx-cursor: hand");
            button.setFont(new Font(45));
            button.setMinWidth(300);
            button.setLayoutX(x);
            button.setLayoutY(y);
            button.setTextFill(Color.BLACK);

            button.setOnMouseEntered(mouseEvent -> button.setStyle("-fx-background-color: cyan"));
            button.setOnMouseExited(mouseEvent -> button.setStyle("-fx-background-color: white"));

            return button;
} //creates a method that takes the parameters text, x, and y where text is a string and x and y are integers. The button is initialised with the button's text being the text that is passed to it. The font of the text within the button will be 45 and the minimum width of the button is set as 300. The colour of the button itself as set as white. The x and y coordinates of the button are set by the integers passed to it when a button is created. The text colour within the button is set as black so the text is visible. The button.setOnMouseEntered and button.setOnMouseExited methods allow the button to change colour when the mouse enters and exits the area of the button.
}


