module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;
    
   opens app to javafx.base, javafx.fxml;
   opens controllers to javafx.fxml;
   opens model to javafx.base, javafx.fxml;   
   exports app;
 }
