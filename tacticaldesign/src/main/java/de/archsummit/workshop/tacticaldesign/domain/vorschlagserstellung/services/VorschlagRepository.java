package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services;

import java.util.Optional;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.Vorschlag;

public interface VorschlagRepository {

    Optional<Vorschlag> getVorschlag(final VorgangId vorgangId);

    Vorschlag save(final Vorschlag vorschlag);

}
