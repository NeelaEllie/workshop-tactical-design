package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe;

import java.util.Optional;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Berechnungsvorgabe;

public interface BerechnungsvorgabeRepository {

    Optional<Berechnungsvorgabe> get(final VorgangId vorgangId);

    Berechnungsvorgabe save(final Berechnungsvorgabe berechnungsvorgabe);

}
