package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.parts;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.Vorschlag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.Fondsauswahl;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.ValidierungException;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.Validator;

@Component
public class FondsauswahlValidierung implements Validator {

    @Override
    public void validiere(Vorschlag vorschlag) throws ValidierungException {
        Fondsauswahl fondsAuswahl = vorschlag.getFondsAuswahl();
        if (fondsAuswahl == null) {
            throw new ValidierungException("FondsAuswahl nicht valide");
        }
        if (fondsAuswahl.getRisikoerwartung() == null) {
            throw new ValidierungException("Risikoerwartung nicht valide");
        }
        if (fondsAuswahl.getFondsAnteile() == null || fondsAuswahl.getFondsAnteile().isEmpty()) {
            throw new ValidierungException("FondsAnteile nicht valide");
        }
        if (fondsAuswahl.getWertsteigerungMinimum() == null || fondsAuswahl.getWertsteigerungMittel() == null
                || fondsAuswahl.getWertsteigerungMaximum() == null) {
            throw new ValidierungException("Wertsteigerungen nicht valide");
        }
    }
}
