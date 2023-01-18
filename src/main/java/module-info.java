module com.example.binarytreeanimation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.binarytreeanimation to javafx.fxml;
    exports com.example.binarytreeanimation;
}