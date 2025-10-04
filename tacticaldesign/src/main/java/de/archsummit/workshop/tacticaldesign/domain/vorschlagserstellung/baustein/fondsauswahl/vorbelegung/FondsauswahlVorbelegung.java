package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.vorbelegung;

import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.model.Fondsauswahl;

public interface FondsauswahlVorbelegung {

    boolean isZustaendigFuer(Anwendungskontext kontext);

    Fondsauswahl get(VorgangId vorgangId);
}
