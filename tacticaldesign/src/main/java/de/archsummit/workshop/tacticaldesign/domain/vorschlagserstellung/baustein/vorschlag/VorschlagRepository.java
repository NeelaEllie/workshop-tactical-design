package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag;

import java.util.Optional;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model.Vorschlag;

public interface VorschlagRepository {

    Optional<Vorschlag> get(final VorgangId vorgangId);

    Vorschlag save(final Vorschlag vorschlag);

}
