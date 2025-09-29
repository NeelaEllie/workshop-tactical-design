package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.parts;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.Vorschlag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.Buz;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.ValidierungException;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.Validator;

@Component
public class BuzValidierung implements Validator {

    @Override
    public void validiere(Vorschlag vorschlag) throws ValidierungException {
        Buz buz = vorschlag.getBuz();
        if (buz == null) {
            throw new ValidierungException("BUZ nicht valide");
        }
        if (buz.getBuzBf() == null) {
            throw new ValidierungException("BUZ-BF nicht valide");
        }
        if (buz.getBuzBr() == null) {
            throw new ValidierungException("BUZ-BR nicht valide");
        }
        if (buz.isPresent()) {
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
    }
}
