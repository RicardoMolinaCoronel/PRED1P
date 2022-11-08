module com.mycompany.prg9 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.prg9 to javafx.fxml;
    exports com.mycompany.prg9;
}
