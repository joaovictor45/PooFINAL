module br.edu.ifba.saj.fwads {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;
    requires org.hibernate.orm.core;
    requires java.persistence;

   opens app to javafx.base, javafx.fxml;
   opens controllers to javafx.fxml;
   
    exports app;
}
