package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation;

import java.util.List;
import org.springframework.stereotype.Service;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.Vorschlag;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FrvVorschlagvalidierung {

    private final List<Validator> validatoren;

    public void validiere(final Vorschlag vorschlag) {
        validatoren.forEach(validator ->
                validator.validiere(vorschlag));
    }
}
