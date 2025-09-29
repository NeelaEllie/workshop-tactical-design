package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.mapping;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.FrvTarifierungsergebnis;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity.TarifierungsergebnisEntity;

@Component
public class TarifierungsergebnisEntityMapper {

    public FrvTarifierungsergebnis mapToDomain(TarifierungsergebnisEntity entity) {
        if (entity == null) {
            return null;
        }
        return FrvTarifierungsergebnis.builder()
                .garantierteRenteGemZahlweise(entity.getGarantierteRenteGemZahlweise())
                .garantiertesVertragsguthaben(entity.getGarantiertesVertragsguthaben())
                .gesamtBeitragGemZahlweise(entity.getGesamtBeitragGemZahlweise())
                .build();
    }

    public TarifierungsergebnisEntity mapToEntity(FrvTarifierungsergebnis domain, TarifierungsergebnisEntity entity) {
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
