package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.laufzeit;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.model.*;

@Component
public class LaufzeitEntityMapper {

    public Laufzeit mapToDomain(LaufzeitEntity entity) {
        if (entity == null) {
            return null;
        }
        Versicherungsdauer versicherungsdauer = Versicherungsdauer.builder()
                .art(entity.getVersicherungsdauerArt() != null ? ArtVersicherungsdauer.valueOf(
                        entity.getVersicherungsdauerArt()) : null)
                .wert(entity.getVersicherungsdauerWert())
                .build();
        Beitragszahlung beitragszahlung = Beitragszahlung.builder()
                .art(entity.getBeitragszahlungArt() != null ? ArtBeitragszahlungsdauer.valueOf(
                        entity.getBeitragszahlungArt()) : null)
                .wert(entity.getBeitragszahlungWert())
                .build();
        return Laufzeit.builder()
                .vorgangId(new VorgangId(entity.getVorgangId()))
                .versicherungsdauer(versicherungsdauer)
                .beitragszahlung(beitragszahlung)
                .build();
    }

    public LaufzeitEntity mapToEntity(Laufzeit domain, LaufzeitEntity entity) {
        if (domain == null) {
            return null;
        }
        if (entity == null) {
            entity = new LaufzeitEntity();
        }
        entity.setVorgangId(domain.getVorgangId().getValue());
        Versicherungsdauer versicherungsdauer = domain.getVersicherungsdauer();
        entity.setVersicherungsdauerArt(
                versicherungsdauer != null && versicherungsdauer.getArt() != null ? versicherungsdauer.getArt().name()
                        : null);
        entity.setVersicherungsdauerWert(versicherungsdauer != null ? versicherungsdauer.getWert() : null);

        Beitragszahlung beitragszahlung = domain.getBeitragszahlung();
        entity.setBeitragszahlungArt(
                beitragszahlung != null && beitragszahlung.getArt() != null ? beitragszahlung.getArt().name() : null);
        entity.setBeitragszahlungWert(beitragszahlung != null ? beitragszahlung.getWert() : null);
        return entity;
    }
}
