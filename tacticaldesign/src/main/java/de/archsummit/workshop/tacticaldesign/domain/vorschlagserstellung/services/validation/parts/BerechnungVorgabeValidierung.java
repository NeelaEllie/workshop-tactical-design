package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.parts;

import java.time.LocalDate;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.Vorschlag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.ValidierungException;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.Validator;

public class BerechnungVorgabeValidierung implements Validator {

    @Override
    public void validiere(Vorschlag vorschlag) throws ValidierungException {
        if (vorschlag.getTarif() == null) {
            throw new ValidierungException("Tarif nicht valide");
        }
        if (vorschlag.getVersicherungsbeginn() == null || vorschlag.getVersicherungsbeginn()
                .isBefore(LocalDate.now())) {
            throw new ValidierungException("Versicherungsbeginn nicht valide");
        }
        if (vorschlag.getGeburtsdatum() == null) {
            throw new ValidierungException("Geburtsdatum nicht valide");
        }
    }
}
