package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation;

import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.Vorschlag;

public class VorschlagService {

    public Vorschlag erstelleNeuenVorschlag() {
        return new Vorschlag();
    }
}
