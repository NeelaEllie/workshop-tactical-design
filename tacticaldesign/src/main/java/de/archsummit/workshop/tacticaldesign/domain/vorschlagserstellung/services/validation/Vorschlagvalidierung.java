package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation;

import java.util.List;
import org.springframework.stereotype.Service;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.Vorschlag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.VorschlagService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Vorschlagvalidierung {

    private final List<Validator> validatoren;

    public void validiere(final Vorschlag vorschlag) {
        validatoren.forEach(validator ->
                validator.validiere(vorschlag));
    }
}
