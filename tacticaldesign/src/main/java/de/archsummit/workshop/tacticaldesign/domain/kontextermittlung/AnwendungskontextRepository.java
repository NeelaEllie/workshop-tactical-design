package de.archsummit.workshop.tacticaldesign.domain.kontextermittlung;

import java.util.Optional;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;

public interface AnwendungskontextRepository {

    Optional<Anwendungskontext> get(final VorgangId vorgangId);

    Anwendungskontext save(final Anwendungskontext anwendungskontext);
}
