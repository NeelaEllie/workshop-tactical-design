package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.vorbelegung;

import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.model.Fondsauswahl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FondsauswahlVorbelegungHandler {

    private final List<FondsauswahlVorbelegung> vorbeleger;

    public Fondsauswahl get(final Anwendungskontext anwendungskontext) {
        return vorbeleger.stream()
                .filter(v -> v.isZustaendigFuer(anwendungskontext))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("Keine passende FondsauswahlVorbelegung gefunden"))
                .get(anwendungskontext.getVorgangId());
    }
}
