module com.example.agrioofd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.agrioofd to javafx.fxml;
    exports com.example.agrioofd;
}