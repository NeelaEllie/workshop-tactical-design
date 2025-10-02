package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.vorbelegung;

import java.util.List;
import org.springframework.stereotype.Service;
import de.archsummit.workshop.tacticaldesign.domain.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Berechnungsvorgabe;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BerechnungsvorgabeVorbelegungHandler {

    private final List<BerechnungsvorgabeVorbelegung> vorbeleger;

    public Berechnungsvorgabe get(final Anwendungskontext anwendungskontext) {
        return vorbeleger.stream()
                .filter(v -> v.isZustaendigFuer(anwendungskontext))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("Keine passende BerechnungsvorgabeVorbelegung gefunden"))
                .get(anwendungskontext.getVorgangId());
    }
}
