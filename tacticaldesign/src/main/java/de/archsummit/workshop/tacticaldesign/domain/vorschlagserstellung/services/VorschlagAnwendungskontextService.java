package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services;

import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;

public interface VorschlagAnwendungskontextService {
    Anwendungskontext get(final VorgangId vorgangId);
}
