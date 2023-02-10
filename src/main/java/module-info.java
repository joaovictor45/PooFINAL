module br.edu.ifba.saj.fwads {
    requires javafx.controls;
    requires javafx.web;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.materialdesignicons;
    requires google.api.client;
    requires com.google.api.client;
    requires com.google.api.client.json.gson;

    opens br.edu.ifba.saj.fwads.controller to javafx.fxml;
    opens br.edu.ifba.saj.fwads.controller.util to javafx.fxml;
    opens br.edu.ifba.saj.fwads.model to javafx.base, javafx.fxml;
    exports br.edu.ifba.saj.fwads;
}
