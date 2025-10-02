package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.mapping;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.kontextermittlung.Tarif;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model.Vorschlag;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity.VorschlagEntity;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class VorschlagEntityMapper {

    private final BeitragEntityMapper beitragMapper;
    private final LaufzeitEntityMapper laufzeitMapper;
    private final FondsauswahlEntityMapper fondsauswahlMapper;
    private final BuzEntityMapper buzMapper;
    private final TarifierungsergebnisEntityMapper tarifierungsergebnisMapper;

    public Vorschlag mapToDomain(VorschlagEntity entity) {
        if (entity == null) {
            return null;
        }
        return Vorschlag.builder()
                .vorgangId(VorgangId.builder().value(entity.getVorgangId()).build())
                .tarif(Tarif.valueOf(entity.getTarif()))
                .versicherungsbeginn(entity.getVersicherungsbeginn())
                .geburtsdatum(entity.getGeburtsdatum())
                .beitrag(beitragMapper.mapToDomain(entity.getBeitrag()))
                .laufzeit(laufzeitMapper.mapToDomain(entity.getLaufzeit()))
                .fondsAuswahl(fondsauswahlMapper.mapToDomain(entity.getFondsAuswahl()))
                .buz(buzMapper.mapToDomain(entity.getBuz()))
                .tarifierungsergebnis(tarifierungsergebnisMapper.mapToDomain(entity.getTarifierungsergebnis()))
                .build();
    }

    public void mapToEntity(Vorschlag domain, VorschlagEntity entity) {
        if (domain == null || entity == null) {
            return;
        }
        entity.setVorgangId(domain.getVorgangId().getValue());
        entity.setTarif(domain.getTarif().name());
        entity.setVersicherungsbeginn(domain.getVersicherungsbeginn());
        entity.setGeburtsdatum(domain.getGeburtsdatum());
        entity.setBeitrag(beitragMapper.mapToEntity(domain.getBeitrag(), entity.getBeitrag()));
        entity.setLaufzeit(laufzeitMapper.mapToEntity(domain.getLaufzeit(), entity.getLaufzeit()));
        entity.setFondsAuswahl(fondsauswahlMapper.mapToEntity(domain.getFondsAuswahl(), entity.getFondsAuswahl()));
        entity.setBuz(buzMapper.mapToEntity(domain.getBuz(), entity.getBuz()));
        entity.setTarifierungsergebnis(tarifierungsergebnisMapper.mapToEntity(domain.getTarifierungsergebnis(),
                entity.getTarifierungsergebnis()));
    }
}
