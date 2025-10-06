package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.tarifierungsergebnis.frv;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.frv.model.FrvTarifierungsergebnis;

@Component
public class FrvTarifierungsergebnisEntityMapper {

    public FrvTarifierungsergebnis mapToDomain(FrvTarifierungsergebnisEntity entity) {
        if (entity == null) {
            return null;
        }
        return FrvTarifierungsergebnis.builder()
                .verfuegbar(entity.isVerfuegbar())
                .vorgangId(new VorgangId(entity.getVorgangId()))
                .garantierteRenteGemZahlweise(entity.getGarantierteRenteGemZahlweise())
                .garantiertesVertragsguthaben(entity.getGarantiertesVertragsguthaben())
                .gesamtBeitragGemZahlweise(entity.getGesamtBeitragGemZahlweise())
                .build();
    }

    public FrvTarifierungsergebnisEntity mapToEntity(FrvTarifierungsergebnis domain,
            FrvTarifierungsergebnisEntity entity) {
        if (domain == null) {
            return null;
        }
        if (entity == null) {
            entity = new FrvTarifierungsergebnisEntity();
        }
        entity.setVerfuegbar(domain.isVerfuegbar());
        entity.setVorgangId(domain.getVorgangId().getValue());
        entity.setGarantierteRenteGemZahlweise(domain.getGarantierteRenteGemZahlweise());
        entity.setGarantiertesVertragsguthaben(domain.getGarantiertesVertragsguthaben());
        entity.setGesamtBeitragGemZahlweise(domain.getGesamtBeitragGemZahlweise());
        return entity;
    }
}
