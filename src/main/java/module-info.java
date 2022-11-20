module com.mycompany.prg9 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.desktop;

    opens com.mycompany.prg9 to javafx.fxml;
    opens com.mycompany.classes;
    exports com.mycompany.prg9;
    requires org.apache.commons.io;
    requires java.logging;
}
