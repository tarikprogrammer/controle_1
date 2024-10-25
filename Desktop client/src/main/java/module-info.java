module com.tarik.cd {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.tarik.cd to javafx.fxml;
    exports com.tarik.cd;
}