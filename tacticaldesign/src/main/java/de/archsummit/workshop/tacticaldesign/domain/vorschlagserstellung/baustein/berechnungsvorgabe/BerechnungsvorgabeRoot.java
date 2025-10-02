package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.kontextermittlung.AnwendungskontextService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.BausteinRoot;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Berechnungsvorgabe;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.validierung.BerechnungVorgabeValidierung;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.vorbelegung.BerechnungsvorgabeVorbelegungHandler;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BerechnungsvorgabeRoot implements BausteinRoot {

    private final AnwendungskontextService anwendungskontextService;
    private final BerechnungsvorgabeRepository repository;
    private final BerechnungsvorgabeVorbelegungHandler vorbelegungHandler;
    private final BerechnungVorgabeValidierung validator;

    @Override
    public Berechnungsvorgabe getOrCreate(VorgangId vorgangId) {
        return repository.get(vorgangId)
                .orElse(vorbelegungHandler.get(anwendungskontextService.get(vorgangId)));
    }

    public void validiere(VorgangId vorgangId) {
        validator.validiere(vorgangId);
    }
}
