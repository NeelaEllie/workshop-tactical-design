package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation;

import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;

public interface Validator {

    void validiere(final VorgangId vorgangId) throws ValidierungException;
}
