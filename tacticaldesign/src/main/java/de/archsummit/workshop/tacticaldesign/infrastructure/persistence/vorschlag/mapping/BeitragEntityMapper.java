package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.mapping;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.Beitrag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.Zahlweise;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity.BeitragEntity;

@Component
public class BeitragEntityMapper {

    public Beitrag mapToDomain(BeitragEntity entity) {
        if (entity == null) {
            return null;
        }
        return Beitrag.builder()
                .beitragsZahlweise(Zahlweise.valueOf(entity.getZahlweise()))
                .wunschbeitrag(entity.getWunschbeitrag())
                .ergaenzungszahlung(entity.getErgaenzungszahlung())
                .build();
    }

    public BeitragEntity mapToEntity(Beitrag domain, BeitragEntity entity) {
        if (domain == null) {
            return null;
        }
        if (entity == null) {
            entity = new BeitragEntity();
        }
        entity.setZahlweise(domain.getBeitragsZahlweise().name());
        entity.setWunschbeitrag(domain.getWunschbeitrag());
        entity.setErgaenzungszahlung(domain.getErgaenzungszahlung());
        return entity;
    }

}
