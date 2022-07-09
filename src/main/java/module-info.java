module com.testingdevops.elisium {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens com.testingdevops.elisium.controller to javafx.fxml;
    exports com.testingdevops.elisium;
}
