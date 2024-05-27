module himanshukhadka.passwordgenerator {
    requires javafx.controls;
    requires javafx.fxml;


    opens himanshukhadka.passwordgenerator to javafx.fxml;
    exports himanshukhadka.passwordgenerator;
}