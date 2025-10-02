package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit;

import java.util.Optional;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.model.Laufzeit;

public interface LaufzeitRepository {

    Optional<Laufzeit> get(final VorgangId vorgangId);

    Laufzeit save(final Laufzeit laufzeit);

}
