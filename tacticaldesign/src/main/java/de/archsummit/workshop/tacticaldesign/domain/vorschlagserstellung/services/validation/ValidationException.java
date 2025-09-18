package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation;

public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
