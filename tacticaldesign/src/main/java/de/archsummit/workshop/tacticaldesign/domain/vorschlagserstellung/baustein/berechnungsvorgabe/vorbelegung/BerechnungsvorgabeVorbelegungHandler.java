package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.vorbelegung;

import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Berechnungsvorgabe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
