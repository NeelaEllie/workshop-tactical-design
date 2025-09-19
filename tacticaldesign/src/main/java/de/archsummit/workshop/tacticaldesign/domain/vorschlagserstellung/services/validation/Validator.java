package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation;

import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.Vorschlag;

public interface Validator {

    void validiere(final Vorschlag vorschlag) throws ValidierungException;
}
