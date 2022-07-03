module com.testingdevops.mitest {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.testingdevops.elisium to javafx.fxml;
    exports com.testingdevops.elisium;
}
