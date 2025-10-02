package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl;

import java.util.Optional;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.model.Fondsauswahl;

public interface FondsauswahlRepository {

    Optional<Fondsauswahl> get(final VorgangId vorgangId);

    Fondsauswahl save(final Fondsauswahl fondsauswahl);

}
