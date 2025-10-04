package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz;

import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.AnwendungskontextService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.BausteinRoot;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.model.Buz;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.vorbelegung.BuzVorbelegungHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuzRoot implements BausteinRoot {

    private final AnwendungskontextService anwendungskontextService;
    private final BuzRepository repository;
    private final BuzVorbelegungHandler vorbelegungHandler;

    @Override
    public Buz getOrCreate(VorgangId vorgangId) {
        return repository.get(vorgangId)
                .orElse(vorbelegungHandler.get(anwendungskontextService.get(vorgangId)));
    }
}
