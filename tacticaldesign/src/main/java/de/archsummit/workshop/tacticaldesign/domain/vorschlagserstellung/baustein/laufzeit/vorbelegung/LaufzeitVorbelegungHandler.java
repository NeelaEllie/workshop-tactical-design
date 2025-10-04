package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.vorbelegung;

import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.model.Laufzeit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaufzeitVorbelegungHandler {

    private final List<LaufzeitVorbelegung> vorbeleger;

    public Laufzeit get(final Anwendungskontext anwendungskontext) {
        return vorbeleger.stream()
                .filter(v -> v.isZustaendigFuer(anwendungskontext))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("Keine passende FondsauswahlVorbelegung gefunden"))
                .get(anwendungskontext.getVorgangId());
    }
}
