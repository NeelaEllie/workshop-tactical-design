package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.BausteinService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Berechnungsvorgabe;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.vorbelegung.BerechnungsvorgabeVorbelegungHandler;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.VorschlagAnwendungskontextService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BerechnungsvorgabeService implements BausteinService {

    private final VorschlagAnwendungskontextService anwendungskontextService;
    private final BerechnungsvorgabeRepository repository;
    private final BerechnungsvorgabeVorbelegungHandler vorbelegungHandler;

    @Override
    public Berechnungsvorgabe getOrCreate(VorgangId vorgangId) {
        return repository.get(vorgangId)
                .orElseGet(() -> create(vorgangId));
    }

    private Berechnungsvorgabe create(VorgangId vorgangId) {
        Berechnungsvorgabe berechnungsvorgabe = vorbelegungHandler.get(anwendungskontextService.get(vorgangId));
        return repository.save(berechnungsvorgabe);
    }
}
