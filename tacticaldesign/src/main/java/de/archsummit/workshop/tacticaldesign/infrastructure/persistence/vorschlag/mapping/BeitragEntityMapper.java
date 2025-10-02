package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.mapping;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Wunschvorgabe;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Zahlweise;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity.BeitragEntity;

@Component
public class BeitragEntityMapper {

    public Wunschvorgabe mapToDomain(BeitragEntity entity) {
        if (entity == null) {
            return null;
        }
        return Wunschvorgabe.builder()
                .zahlweise(Zahlweise.valueOf(entity.getZahlweise()))
                .wunschbeitrag(entity.getWunschbeitrag())
                .ergaenzungszahlung(entity.getErgaenzungszahlung())
                .build();
    }

    public BeitragEntity mapToEntity(Wunschvorgabe domain, BeitragEntity entity) {
        if (domain == null) {
            return null;
        }
        if (entity == null) {
            entity = new BeitragEntity();
        }
        entity.setZahlweise(domain.getZahlweise().name());
        entity.setWunschbeitrag(domain.getWunschbeitrag());
        entity.setErgaenzungszahlung(domain.getErgaenzungszahlung());
        return entity;
    }

}
