package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.frv;

import java.util.Optional;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.frv.model.FrvTarifierungsergebnis;

public interface FrvTarifierungsergebnisRepository {

    Optional<FrvTarifierungsergebnis> get(final VorgangId vorgangId);

    FrvTarifierungsergebnis save(final FrvTarifierungsergebnis laufzeit);

}
