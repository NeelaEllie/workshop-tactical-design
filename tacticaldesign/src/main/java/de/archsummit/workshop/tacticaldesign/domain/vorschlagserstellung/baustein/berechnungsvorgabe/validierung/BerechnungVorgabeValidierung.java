package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.validierung;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.BerechnungsvorgabeService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Berechnungsvorgabe;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Wunschvorgabe;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.Validator;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.ValidierungException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BerechnungVorgabeValidierung implements Validator {

    private final BerechnungsvorgabeService root;

    @Override
    public void validiere(VorgangId vorgangId) throws ValidierungException {
        Berechnungsvorgabe berechnungsvorgabe = root.getOrCreate(vorgangId);
        if (berechnungsvorgabe.getGeburtsdatum() == null) {
            throw new ValidierungException("Geburtsdatum nicht valide");
        }

        Wunschvorgabe beitragvorgabe = berechnungsvorgabe.getWunschvorgabe();
        if (beitragvorgabe == null) {
            throw new ValidierungException("Beitrag nicht valide");
        }

        if (beitragvorgabe.getZahlweise() == null) {
            throw new ValidierungException("Beitragszahlweise nicht valide");
        }

        if (beitragvorgabe.getWunschbetrag() == null) {
            throw new ValidierungException("Wunschbeitrag nicht valide");
        }
    }
}
