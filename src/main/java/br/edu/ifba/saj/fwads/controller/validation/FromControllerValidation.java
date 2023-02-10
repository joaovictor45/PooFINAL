package br.edu.ifba.saj.fwads.controller.validation;

import java.util.function.Consumer;
import java.util.function.Function;

import javafx.scene.control.Control;

public class FromControllerValidation<T extends Control> {
    private T control;
    private String message;
    private Function<FromControllerValidation<T>, Boolean> validationConsumer;

    public FromControllerValidation(T control, String message, Consumer<FromControllerValidation<T>> resetConsumer,
            Function<FromControllerValidation<T>, Boolean> validationConsumer) {
        this.control = control;
        this.message = message;
        resetConsumer.accept(this);
        this.validationConsumer = validationConsumer;
    }
    
    public T control() {
        return control;
    }

    public String message() {
        return message;
    }

    public Boolean validationConsumer() {
        return validationConsumer.apply(this);
    } 
}
