module com.example.kulb_csd214test2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.kulb_csd214test2 to javafx.fxml;
    exports com.example.kulb_csd214test2;
}