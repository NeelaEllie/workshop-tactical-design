package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.vorbelegung;

import java.util.List;
import org.springframework.stereotype.Service;
import de.archsummit.workshop.tacticaldesign.domain.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.model.Laufzeit;
import lombok.RequiredArgsConstructor;

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
