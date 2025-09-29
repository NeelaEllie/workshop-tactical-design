package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.mapping;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.tarifierungsergebnis.Tarifierungsergebnis;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity.TarifierungsergebnisEntity;

@Component
public class TarifierungsergebnisEntityMapper {

    public Tarifierungsergebnis mapToDomain(TarifierungsergebnisEntity entity) {
        if (entity == null) {
            return null;
        }
        return Tarifierungsergebnis.builder()
                .garantierteRenteGemZahlweise(entity.getGarantierteRenteGemZahlweise())
                .garantiertesVertragsguthaben(entity.getGarantiertesVertragsguthaben())
                .gesamtBeitragGemZahlweise(entity.getGesamtBeitragGemZahlweise())
                .build();
    }

    public TarifierungsergebnisEntity mapToEntity(Tarifierungsergebnis domain, TarifierungsergebnisEntity entity) {
        if (domain == null) {
            return null;
        }
        if (entity == null) {
            entity = new TarifierungsergebnisEntity();
        }
        entity.setGarantierteRenteGemZahlweise(domain.getGarantierteRenteGemZahlweise());
        entity.setGarantiertesVertragsguthaben(domain.getGarantiertesVertragsguthaben());
        entity.setGesamtBeitragGemZahlweise(domain.getGesamtBeitragGemZahlweise());
        return entity;
    }
}
