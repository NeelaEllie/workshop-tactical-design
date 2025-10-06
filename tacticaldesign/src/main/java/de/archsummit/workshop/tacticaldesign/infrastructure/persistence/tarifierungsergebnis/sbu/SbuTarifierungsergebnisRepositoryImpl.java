package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.tarifierungsergebnis.sbu;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.sbu.SbuTarifierungsergebnisRepository;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.sbu.model.SbuTarifierungsergebnis;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SbuTarifierungsergebnisRepositoryImpl implements SbuTarifierungsergebnisRepository {

    private final SbuTarifierungsergebnisJpaRepository jpaRepository;
    private final SbuTarifierungsergebnisEntityMapper mapper;

    @Override
    public Optional<SbuTarifierungsergebnis> get(VorgangId vorgangId) {
        return jpaRepository.getSbuTarifierungsergebnisEntityByVorgangId(vorgangId.getValue())
                .map(mapper::mapToDomain);
    }

    @Override
    public SbuTarifierungsergebnis save(SbuTarifierungsergebnis baustein) {
        SbuTarifierungsergebnisEntity entity = jpaRepository
                .getSbuTarifierungsergebnisEntityByVorgangId(baustein.getVorgangId().getValue())
                .orElse(new SbuTarifierungsergebnisEntity());
        entity.setVorgangId(baustein.getVorgangId() != null ? baustein.getVorgangId().getValue() : null);
        mapper.mapToEntity(baustein, entity);
        jpaRepository.save(entity);
        return mapper.mapToDomain(entity);
    }
}
