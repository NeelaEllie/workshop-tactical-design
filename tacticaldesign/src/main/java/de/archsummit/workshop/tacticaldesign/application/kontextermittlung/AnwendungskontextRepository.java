package de.archsummit.workshop.tacticaldesign.application.kontextermittlung;

import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;

import java.util.Optional;

public interface AnwendungskontextRepository {

    Optional<Anwendungskontext> get(final VorgangId vorgangId);

    Anwendungskontext save(final Anwendungskontext anwendungskontext);
}
