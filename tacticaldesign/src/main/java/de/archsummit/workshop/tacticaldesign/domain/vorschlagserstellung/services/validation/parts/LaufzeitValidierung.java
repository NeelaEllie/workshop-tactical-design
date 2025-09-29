package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.parts;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.Vorschlag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.Laufzeit;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.ValidierungException;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.Validator;

@Component
public class LaufzeitValidierung implements Validator {

    @Override
    public void validiere(Vorschlag vorschlag) throws ValidierungException {
        Laufzeit laufzeit = vorschlag.getLaufzeit();
        if (laufzeit == null) {
            throw new ValidierungException("Laufzeit nicht valide");
        }
        if (laufzeit.getVersicherungsdauer() == null) {
            throw new ValidierungException("Versicherungsdauer nicht valide");
        }
        if (laufzeit.getBeitragszahlung() == null) {
            throw new ValidierungException("Beitragszahlung nicht valide");
        }
    }
}
