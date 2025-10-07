package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.validierung;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.BuzService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.Validator;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.ValidierungException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuzValidierung implements Validator {

    private final BuzService buzRoot;

    @Override
    public void validiere(VorgangId vorgangId) throws ValidierungException {
        buzRoot.getOrCreate(vorgangId).ifVerfuegbar(buz -> {
            if (buz == null) {
                throw new ValidierungException("BUZ nicht valide");
            }
            if (buz.getBuzBf() == null) {
                throw new ValidierungException("BUZ-BF nicht valide");
            }
            if (buz.getBuzBr() == null) {
                throw new ValidierungException("BUZ-BR nicht valide");
            }
            if (buz.isGewaehlt()) {
                if (buz.getBeruf() == null || buz.getBeruf().getId() == null) {
                    throw new ValidierungException("Der Beruf muss gesetzt sein");
                }
                if (buz.getBuzBf().isGewaehlt()) {
                    if (buz.getBuzBf().getEndalterLeistungsdauer() == null) {
                        throw new ValidierungException("Das Endalter der Leistungsdauer muss gesetzt sein");
                    }
                }
                if (buz.getBuzBr().isGewaehlt()) {
                    if (buz.getBuzBr().getWunschrente() == null) {
                        throw new ValidierungException("Die BUZ-BR Wunschrente muss gesetzt sein");
                    }
                    if (buz.getBuzBr().getEndalterLeistungsdauer() == null) {
                        throw new ValidierungException("Das Endalter der Leistungsdauer muss gesetzt sein");
                    }
                }
            }
        });
    }
}
