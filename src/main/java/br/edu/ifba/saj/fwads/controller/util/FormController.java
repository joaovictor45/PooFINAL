package br.edu.ifba.saj.fwads.controller.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import br.edu.ifba.saj.fwads.controller.validation.FromControllerValidation;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Control;


public abstract class FormController {

    protected List<FromControllerValidation<? extends Control>> validations = new ArrayList<>();

    protected void addValidation(FromControllerValidation<? extends Control> validation) {
        validations.add(validation);
    }

    protected boolean validate() {
        StringBuilder message = new StringBuilder();

        Stream.ofNullable(validations).flatMap(List::stream).filter(
                validation -> !validation.validationConsumer())
                .forEach(
                        validation -> {
                            message.append(validation.message() + "\n");
                            validation.control().getStyleClass().add("erro-class");
                        });

        if (message.length() > 0) {

            Alert alert = new Alert(AlertType.WARNING, message.toString());
            alert.setTitle("Alerta");
            alert.setHeaderText("Validações");
            alert.showAndWait();
            return false;
        }
        return true;
    }



}
