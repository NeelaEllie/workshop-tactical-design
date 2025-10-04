package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.tarifierungsergebnis.frv;

import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.frv.model.FrvTarifierungsergebnis;
import org.springframework.stereotype.Component;

@Component
public class FrvTarifierungsergebnisEntityMapper {

    public FrvTarifierungsergebnis mapToDomain(FrvTarifierungsergebnisEntity entity) {
        if (entity == null) {
            return null;
        }
        return FrvTarifierungsergebnis.builder()
                .garantierteRenteGemZahlweise(entity.getGarantierteRenteGemZahlweise())
                .garantiertesVertragsguthaben(entity.getGarantiertesVertragsguthaben())
                .gesamtBeitragGemZahlweise(entity.getGesamtBeitragGemZahlweise())
                .build();
    }

    public FrvTarifierungsergebnisEntity mapToEntity(FrvTarifierungsergebnis domain, FrvTarifierungsergebnisEntity entity) {
        if (domain == null) {
            return null;
        }
        if (entity == null) {
            entity = new FrvTarifierungsergebnisEntity();
        }
        entity.setGarantierteRenteGemZahlweise(domain.getGarantierteRenteGemZahlweise());
        entity.setGarantiertesVertragsguthaben(domain.getGarantiertesVertragsguthaben());
        entity.setGesamtBeitragGemZahlweise(domain.getGesamtBeitragGemZahlweise());
        return entity;
    }
}
