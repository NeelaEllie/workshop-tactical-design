package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz;

import java.util.Optional;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.model.Buz;

public interface BuzRepository {

    Optional<Buz> get(final VorgangId vorgangId);

    Buz save(final Buz buz);

}
