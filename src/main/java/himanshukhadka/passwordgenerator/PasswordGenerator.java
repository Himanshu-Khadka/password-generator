package himanshukhadka.passwordgenerator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



public class PasswordGenerator extends Application {
    private int defaultLength = 8;

    @Override
    public void start(Stage stage){
        int lengthOfPassword = defaultLength;

        //Creating Label
        Label mainLabel = new Label("Password Generator");
        //Some fonts
        Font font = Font.font("Times New Roman",FontWeight.EXTRA_BOLD,20);
        Font font1 = Font.font("Roboto",FontWeight.BOLD,18);
        mainLabel.setFont(font);


        //Creating text fields
        TextField passString = new TextField("Password Appears here");
        TextField passLength = new TextField(Integer.toString(lengthOfPassword));
        passString.setEditable(false);
        passString.setFont(font1);
        passString.setAlignment(Pos.CENTER);
        passString.setPrefWidth(300);
        passString.setPrefHeight(50);
        passLength.setPrefWidth(50);


        //Creating Buttons
        Button generateBtn = new Button("Generate");
        generateBtn.setStyle("-fx-pref-width: 100");
        generateBtn.setStyle("-fx-border-radius: 20");

        RadioButton specialCharacter = new RadioButton("Special Characters ");
        specialCharacter.setSelected(true);
        //On Button Pressed
        generateBtn.setOnAction(e->{
            String passStr;
            passStr = new password().generate(lengthOfPassword,specialCharacter.isSelected());
            passString.setText(passStr);
            System.out.println(specialCharacter.isSelected());
            generateBtn.setText("Generate Next");
        });

        //HBOx for main Label
        HBox mainLabelHbox = new HBox(mainLabel);
        mainLabelHbox.setAlignment(Pos.CENTER);
        mainLabelHbox.setPadding(new Insets(20));

        //HBox for label
        HBox lengthBox = new HBox();
        lengthBox.getChildren().addAll(new Label("Length:    "), passLength);
        lengthBox.setAlignment(Pos.CENTER);

        //Vbox for control pane
        VBox controlPane = new VBox();
        controlPane.setAlignment(Pos.CENTER);
        controlPane.setPadding(new Insets(12,12,80,12));
        controlPane.setSpacing(12);
        controlPane.getChildren().addAll(lengthBox,specialCharacter,generateBtn);

        //VBox for nodes
        VBox Vpane = new VBox();
        Vpane.setSpacing(20);
        Vpane.setAlignment(Pos.CENTER);
        Vpane.setPadding(new Insets(12,12,12,12));
        Vpane.getChildren().addAll(passString);

        //Main pane
        BorderPane pane = new BorderPane();
        pane.setTop(mainLabelHbox);
        pane.setCenter(Vpane);
        pane.setBottom(controlPane);
        pane.setStyle("-fx-background-color: #F1F1F1");

        //Setting up scene
        Scene scene = new Scene(pane,500,350);
        stage.setScene(scene);
        stage.setTitle("Password Generator");
        stage.show();
    }

}