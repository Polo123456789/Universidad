module com.poo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.poo2 to javafx.fxml;
    exports com.poo2;
}
