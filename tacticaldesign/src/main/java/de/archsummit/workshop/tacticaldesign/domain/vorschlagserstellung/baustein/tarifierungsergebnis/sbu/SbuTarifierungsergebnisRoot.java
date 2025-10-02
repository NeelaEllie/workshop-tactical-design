package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.sbu;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.kontextermittlung.AnwendungskontextService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.BausteinRoot;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.sbu.model.SbuTarifierungsergebnis;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SbuTarifierungsergebnisRoot implements BausteinRoot<SbuTarifierungsergebnis> {

    private final AnwendungskontextService anwendungskontextService;
    private final SbuTarifierungsergebnisRepository repository;
    private final SbuTarifierungsergebnisVorbelegungHandler vorbelegungHandler;

    @Override
    public SbuTarifierungsergebnis getOrCreate(VorgangId vorgangId) {
        return repository.get(vorgangId)
                .orElse(vorbelegungHandler.get(anwendungskontextService.get(vorgangId)));
    }
}
