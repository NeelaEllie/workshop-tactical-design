package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.sbu;

import java.util.Optional;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.sbu.model.SbuTarifierungsergebnis;

public interface SbuTarifierungsergebnisRepository {

    Optional<SbuTarifierungsergebnis> get(final VorgangId vorgangId);

    SbuTarifierungsergebnis save(final SbuTarifierungsergebnis laufzeit);

}
