package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services;

import org.springframework.stereotype.Service;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.Vorschlag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.Vorschlagvalidierung;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.vorbelegung.FrvVorschlagVorbelegung;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VorschlagService {

    private final FrvVorschlagVorbelegung frvVorschlagVorbelegung;
    private final VorschlagRepository vorschlagRepository;
    private final Vorschlagvalidierung vorschlagvalidierung;

    public Vorschlag erstelleNeuenVorschlag() {
        final var vorschlag = frvVorschlagVorbelegung.create();
        return vorschlagRepository.save(vorschlag);
    }

    public Vorschlag getVorschlag(final VorgangId vorgangId) {
        return vorschlagRepository.getVorschlag(vorgangId)
                .orElseThrow(() -> new IllegalArgumentException("Vorschlag nicht gefunden"));
    }

    public void validiereVorschlag(final VorgangId vorgangId) {
        final var vorschlag = getVorschlag(vorgangId);
        vorschlagvalidierung.validiere(vorschlag);
    }
}
