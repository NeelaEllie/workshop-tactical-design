package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation;

import java.util.List;
import org.springframework.stereotype.Service;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Vorschlagvalidierung {

    private final List<Validator> validatoren;

    public void validiere(final VorgangId vorgangId) {
        validatoren.forEach(validator ->
                validator.validiere(vorgangId));
    }
}
