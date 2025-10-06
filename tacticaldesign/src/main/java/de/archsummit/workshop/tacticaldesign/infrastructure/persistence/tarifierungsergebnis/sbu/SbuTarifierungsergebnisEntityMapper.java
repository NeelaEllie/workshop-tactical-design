package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.tarifierungsergebnis.sbu;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.sbu.model.SbuTarifierungsergebnis;

@Component
public class SbuTarifierungsergebnisEntityMapper {

    public SbuTarifierungsergebnis mapToDomain(SbuTarifierungsergebnisEntity entity) {
        if (entity == null) {
            return null;
        }
        return SbuTarifierungsergebnis.builder()
                .verfuegbar(entity.isVerfuegbar())
                .vorgangId(new VorgangId(entity.getVorgangId()))
                .renteGemZahlweise(entity.getRenteGemZahlweise())
                .gesamtBeitragGemZahlweise(entity.getGesamtBeitragGemZahlweise())
                .build();
    }

    public SbuTarifierungsergebnisEntity mapToEntity(SbuTarifierungsergebnis domain,
            SbuTarifierungsergebnisEntity entity) {
        if (domain == null) {
            return null;
        }
        if (entity == null) {
            entity = new SbuTarifierungsergebnisEntity();
        }
        entity.setVerfuegbar(domain.isVerfuegbar());
        entity.setVorgangId(domain.getVorgangId().getValue());
        entity.setRenteGemZahlweise(domain.getRenteGemZahlweise());
        entity.setGesamtBeitragGemZahlweise(domain.getGesamtBeitragGemZahlweise());
        return entity;
    }
}
