package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.buz;

import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.BuzRepository;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.model.Buz;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.buz.entity.BuzEntity;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.buz.mapper.BuzEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BuzRepositoryImpl implements BuzRepository {

    private final BuzJpaRepository jpaRepository;
    private final BuzEntityMapper mapper;

    @Override
    public Optional<Buz> get(VorgangId vorgangId) {
        return jpaRepository.getBuzEntitiesByVorgangId(vorgangId.getValue())
                .map(mapper::mapToDomain);
    }

    @Override
    public Buz save(Buz buz) {
        BuzEntity entity = jpaRepository
                .getBuzEntitiesByVorgangId(buz.getVorgangId().getValue())
                .orElse(new BuzEntity());
        entity.setVorgangId(buz.getVorgangId() != null ? buz.getVorgangId().getValue() : null);
        mapper.mapToEntity(buz, entity);
        jpaRepository.save(entity);
        return mapper.mapToDomain(entity);
    }
}
