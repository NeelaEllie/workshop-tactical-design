package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.mapping;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model.Tarif;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model.Vorschlag;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity.VorschlagEntity;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class VorschlagEntityMapper {

    private final TarifierungsergebnisEntityMapper tarifierungsergebnisMapper;

    public Vorschlag mapToDomain(VorschlagEntity entity) {
        if (entity == null) {
            return null;
        }
        return Vorschlag.builder()
                .vorgangId(new VorgangId(entity.getVorgangId()))
                .tarif(Tarif.valueOf(entity.getTarif()))
                .tarifierung(tarifierungsergebnisMapper.mapToDomain(entity.getTarifierungsergebnis()))
                .build();
    }

    public void mapToEntity(Vorschlag domain, VorschlagEntity entity) {
        if (domain == null || entity == null) {
            return;
        }
        entity.setVorgangId(domain.getVorgangId().getValue());
        entity.setTarif(domain.getTarif().name());
        entity.setTarifierungsergebnis(tarifierungsergebnisMapper.mapToEntity(domain.getTarifierung(),
                entity.getTarifierungsergebnis()));
    }
}
