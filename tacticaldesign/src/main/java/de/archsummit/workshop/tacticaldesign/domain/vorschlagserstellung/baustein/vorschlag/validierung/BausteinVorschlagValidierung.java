package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.validierung;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.VorschlagService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model.Vorschlag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.Validator;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.ValidierungException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BausteinVorschlagValidierung implements Validator {

    private final VorschlagService vorschlagService;

    @Override
    public void validiere(VorgangId vorgangId) throws ValidierungException {
        Vorschlag vorschlag = vorschlagService.getVorschlag(vorgangId);
        if (!vorschlag.getTarifierung().isValide()) {
            throw new ValidierungException("Tarifierung ist nicht valide");
        }
    }
}
