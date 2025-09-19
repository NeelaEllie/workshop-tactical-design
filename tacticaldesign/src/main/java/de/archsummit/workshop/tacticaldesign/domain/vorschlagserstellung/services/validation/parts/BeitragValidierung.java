package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.parts;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.Vorschlag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.beitrag.Beitrag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.ValidierungException;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.Validator;

@Component
public class BeitragValidierung implements Validator {

    @Override
    public void validiere(Vorschlag vorschlag) throws ValidierungException {
        Beitrag beitrag = vorschlag.getBeitrag();
        if (beitrag == null) {
            throw new ValidierungException("Beitrag nicht valide");
        }

        if (beitrag.getBeitragsZahlweise() == null) {
            throw new ValidierungException("Beitragszahlweise nicht valide");
        }

        if (beitrag.getWunschbeitrag() == null) {
            throw new ValidierungException("Wunschbeitrag nicht valide");
        }
    }
}
