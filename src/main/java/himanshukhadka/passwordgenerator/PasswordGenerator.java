package himanshukhadka.passwordgenerator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PasswordGenerator extends Application {
    @Override
    public void start(Stage stage){
        int lengthOfPassword = 8;

        System.out.println(new password().generate(8,true));
//        System.exit(1);

        Text homeLabel = new Text("Password Generator");
        Text passString = new Text();
        passString.setVisible(false);
        Label lengthLabel = new Label("Length");
        TextField range = new TextField(Integer.toString(lengthOfPassword));


        Button generateBtn = new Button("Generate");
        generateBtn.setOnAction(e->{
            passString.setText(new password().generate(lengthOfPassword,true));
            passString.setVisible(true);

        });


        BorderPane pane = new BorderPane();
        pane.setTop(homeLabel);
        pane.setCenter(passString);
        pane.setBottom(generateBtn);

        Scene scene = new Scene(pane);
        stage.setTitle("Password Generator");
        stage.setScene(scene);
        stage.show();

    }

}