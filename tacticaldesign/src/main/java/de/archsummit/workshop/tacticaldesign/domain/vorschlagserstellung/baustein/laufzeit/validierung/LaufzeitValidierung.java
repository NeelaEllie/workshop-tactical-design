package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.validierung;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.LaufzeitRoot;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.Validator;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.ValidierungException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LaufzeitValidierung implements Validator {

    private LaufzeitRoot root;

    @Override
    public void validiere(VorgangId vorgangId) throws ValidierungException {
        root.getOrCreate(vorgangId).ifVerfuegbar(laufzeit -> {
            if (laufzeit == null) {
                throw new ValidierungException("Laufzeit nicht valide");
            }
            if (laufzeit.getVersicherungsdauer() == null) {
                throw new ValidierungException("Versicherungsdauer nicht valide");
            }
            if (laufzeit.getBeitragszahlung() == null) {
                throw new ValidierungException("Beitragszahlung nicht valide");
            }
        });
    }
}
