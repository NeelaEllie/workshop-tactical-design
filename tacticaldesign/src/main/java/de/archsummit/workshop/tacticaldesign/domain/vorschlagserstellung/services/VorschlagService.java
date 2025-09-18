package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.Tarif;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.Vorschlag;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VorschlagService {

    private final VorschlagRepository vorschlagRepository;

    // TODO Folgeaufgabe: Produktspezifische Vorbelegung

    public Vorschlag erstelleNeuenVorschlag(final Tarif tarif) {
        Vorschlag vorschlag = Vorschlag.builder().tarif(tarif).build();
        return vorschlagRepository.save(vorschlag);
    }

    public Vorschlag getVorschlag(final VorgangId vorgangId) {
        return vorschlagRepository.getVorschlag(vorgangId)
                .orElseThrow(() -> new IllegalArgumentException("Vorschlag nicht gefunden"));
    }
}
