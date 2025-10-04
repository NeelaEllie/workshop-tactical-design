package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.berechnungsvorgabe.mapper;

import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Berechnungsvorgabe;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.berechnungsvorgabe.entity.BerechnungsvorgabeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BerechnungsvorgabeEntityMapper {

    private final BeitragEntityMapper beitragEntityMapper;

    public Berechnungsvorgabe mapToDomain(BerechnungsvorgabeEntity entity) {
        if (entity == null) {
            return null;
        }
        return Berechnungsvorgabe.builder()
                .vorgangId(new VorgangId(entity.getVorgangId()))
                .verfuegbar(entity.isVerfuegbar())
                .wunschvorgabe(beitragEntityMapper.mapToDomain(entity.getWunschvorgabe()))
                .geburtsdatum(entity.getGeburtsdatum())
                .build();
    }

    public void mapToEntity(Berechnungsvorgabe domain, BerechnungsvorgabeEntity entity) {
        if (domain == null || entity == null) {
            return;
        }
        entity.setVorgangId(domain.getVorgangId() != null ? domain.getVorgangId().getValue() : null);
        entity.setVerfuegbar(domain.isVerfuegbar());
        entity.setGeburtsdatum(domain.getGeburtsdatum());
        entity.setWunschvorgabe(beitragEntityMapper.mapToEntity(domain.getWunschvorgabe(), entity.getWunschvorgabe()));
    }
}
