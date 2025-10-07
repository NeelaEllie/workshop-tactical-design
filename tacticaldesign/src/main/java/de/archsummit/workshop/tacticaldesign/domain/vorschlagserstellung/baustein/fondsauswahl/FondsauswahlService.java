package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.BausteinService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.model.Fondsauswahl;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.vorbelegung.FondsauswahlVorbelegungHandler;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.VorschlagAnwendungskontextService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FondsauswahlService implements BausteinService {

    private final VorschlagAnwendungskontextService anwendungskontextService;
    private final FondsauswahlRepository repository;
    private final FondsauswahlVorbelegungHandler vorbelegungHandler;

    @Override
    public Fondsauswahl getOrCreate(VorgangId vorgangId) {
        return repository.get(vorgangId)
                .orElseGet(() -> create(vorgangId));
    }

    private Fondsauswahl create(VorgangId vorgangId) {
        Fondsauswahl fondsauswahl = vorbelegungHandler.get(anwendungskontextService.get(vorgangId));
        return repository.save(fondsauswahl);
    }
}
