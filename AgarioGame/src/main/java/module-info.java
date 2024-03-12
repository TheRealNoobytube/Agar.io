module com.example.agariogame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.agariogame to javafx.fxml;
    exports com.example.agariogame;
}