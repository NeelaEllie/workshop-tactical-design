package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.laufzeit;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.LaufzeitRepository;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.laufzeit.model.Laufzeit;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LaufzeitRepositoryImpl implements LaufzeitRepository {

    private final LaufzeitJpaRepository jpaRepository;
    private final LaufzeitEntityMapper mapper;

    @Override
    public Optional<Laufzeit> get(VorgangId vorgangId) {
        return jpaRepository.getLaufzeitEntityByVorgangId(vorgangId.getValue())
                .map(mapper::mapToDomain);
    }

    @Override
    public Laufzeit save(Laufzeit laufzeit) {
        LaufzeitEntity entity = jpaRepository
                .getLaufzeitEntityByVorgangId(laufzeit.getVorgangId().getValue())
                .orElse(new LaufzeitEntity());
        entity.setVorgangId(laufzeit.getVorgangId() != null ? laufzeit.getVorgangId().getValue() : null);
        mapper.mapToEntity(laufzeit, entity);
        jpaRepository.save(entity);
        return mapper.mapToDomain(entity);
    }
}
