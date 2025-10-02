package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.vorbelegung;

import java.util.List;
import org.springframework.stereotype.Service;
import de.archsummit.workshop.tacticaldesign.domain.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.model.Fondsauswahl;
import lombok.RequiredArgsConstructor;

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
