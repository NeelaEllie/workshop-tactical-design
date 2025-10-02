package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.validierung;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.FondsauswahlRoot;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.Validator;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.ValidierungException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FondsauswahlValidierung implements Validator {

    private final FondsauswahlRoot root;

    @Override
    public void validiere(VorgangId vorgangId) throws ValidierungException {
        root.getOrCreate(vorgangId).ifVerfuegbar(fondsauswahl -> {
            if (fondsauswahl == null) {
                throw new ValidierungException("FondsAuswahl nicht valide");
            }
            if (fondsauswahl.getRisikoerwartung() == null) {
                throw new ValidierungException("Risikoerwartung nicht valide");
            }
            if (fondsauswahl.getFondsAnteile() == null || fondsauswahl.getFondsAnteile().isEmpty()) {
                throw new ValidierungException("FondsAnteile nicht valide");
            }
            if (fondsauswahl.getWertsteigerungMinimum() == null || fondsauswahl.getWertsteigerungMittel() == null
                    || fondsauswahl.getWertsteigerungMaximum() == null) {
                throw new ValidierungException("Wertsteigerungen nicht valide");
            }
        });
    }
}
