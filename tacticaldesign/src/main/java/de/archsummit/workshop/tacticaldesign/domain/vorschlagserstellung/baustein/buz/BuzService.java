package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.BausteinService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.model.Buz;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.vorbelegung.BuzVorbelegungHandler;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.VorschlagAnwendungskontextService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuzService implements BausteinService {

    private final VorschlagAnwendungskontextService anwendungskontextService;
    private final BuzRepository repository;
    private final BuzVorbelegungHandler vorbelegungHandler;

    @Override
    public Buz getOrCreate(VorgangId vorgangId) {
        return repository.get(vorgangId)
                .orElseGet(() -> create(vorgangId));
    }

    private Buz create(VorgangId vorgangId) {
        Buz buz = vorbelegungHandler.get(anwendungskontextService.get(vorgangId));
        return repository.save(buz);
    }
}
