package br.edu.ifba.saj.fwads.controller.validation;

import java.util.function.Consumer;
import java.util.function.Function;

import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class FromControllerValidationBuilder<T extends Control> {
    private T control;
    private String message;
    private Consumer<FromControllerValidation<T>> resetConsumer;
    private Function<FromControllerValidation<T>, Boolean> validationConsumer;

    //private FromControllerValidation<? extends Control> fromControllerValidation;

    public static <T extends Control> FromControllerValidationBuilder<T> builder() {
        return new FromControllerValidationBuilder<T>();
    }

    public FromControllerValidationBuilder<T> control(T control) {
        this.control = control;
        return this;
    }

    public FromControllerValidationBuilder<T> message(String message) {
        this.message = message;
        return this;
    }

    public FromControllerValidationBuilder<T> resetConsumer(Consumer<FromControllerValidation<T>> resetConsumer) {
        this.resetConsumer = resetConsumer;
        return this;
    }

    public FromControllerValidationBuilder<T> validationConsumer(Function<FromControllerValidation<T>, Boolean> validationConsumer) {
        this.validationConsumer = validationConsumer;
        return this;
    }

    public FromControllerValidation<? extends Control> build() {
        if((control != null) && (control instanceof TextField tf) && (message != null)){
            if((resetConsumer == null) && (validationConsumer == null)) {
                return new FromControllerValidation<TextField>(tf, message,
                FromControllerValidationBuilder::resetTextField,
                FromControllerValidationBuilder::requiredTextField);
            }
        }
        if((control != null) && (control instanceof DatePicker dp) && (message != null)){
            if((resetConsumer == null) && (validationConsumer == null)) {
                return new FromControllerValidation<DatePicker>(dp, message,
                                                               FromControllerValidationBuilder::resetDatePickerField,
                                                               FromControllerValidationBuilder::requiredDatePicker);
            }
        }
        

        return new FromControllerValidation<T>(control, message, resetConsumer,validationConsumer);
    }

    public static void resetTextField(FromControllerValidation<TextField> fromControllerValidationTextField) {
        fromControllerValidationTextField.control().textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                fromControllerValidationTextField.control().getStyleClass().remove("erro-class");
            }
        });
    }

    public static Consumer<FromControllerValidation<TextField>> resetTextField = fromControllerValidationTextField -> {
        fromControllerValidationTextField.control().textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                fromControllerValidationTextField.control().getStyleClass().remove("erro-class");
            }
        });
    };

    public static Boolean requiredTextField(FromControllerValidation<TextField> fromControllerValidationTextField) {
        if (fromControllerValidationTextField.control().getText() == null || fromControllerValidationTextField.control().getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public static Function<FromControllerValidation<TextField>, Boolean> requiredTextField = fromControllerValidationTextField -> {
        if (fromControllerValidationTextField.control().getText() == null || fromControllerValidationTextField.control().getText().trim().isEmpty()) {
            return false;
        }
        return true;
    };


    public static void resetDatePickerField(FromControllerValidation<DatePicker> fromControllerValidationDatePicker) {
        fromControllerValidationDatePicker.control().valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue!= null) {
                fromControllerValidationDatePicker.control().getStyleClass().remove("erro-class");
            }
        });
    }
    public static Boolean requiredDatePicker(FromControllerValidation<DatePicker> fromControllerValidationDatePicker) {
        if (fromControllerValidationDatePicker.control().getValue() == null) {
            return false;
        }
        return true;
    }
}
