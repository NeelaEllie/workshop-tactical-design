package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.tarifierungsergebnis.frv;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.frv.FrvTarifierungsergebnisRepository;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.tarifierungsergebnis.frv.model.FrvTarifierungsergebnis;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FrvTarifierungsergebnisRepositoryImpl implements FrvTarifierungsergebnisRepository {

    private final FrvTarifierungsergebnisJpaRepository jpaRepository;
    private final FrvTarifierungsergebnisEntityMapper mapper;

    @Override
    public Optional<FrvTarifierungsergebnis> get(VorgangId vorgangId) {
        return jpaRepository.getFrvTarifierungsergebnisEntityByVorgangId(vorgangId.getValue())
                .map(mapper::mapToDomain);
    }

    @Override
    public FrvTarifierungsergebnis save(FrvTarifierungsergebnis baustein) {
        FrvTarifierungsergebnisEntity entity = jpaRepository
                .getFrvTarifierungsergebnisEntityByVorgangId(baustein.getVorgangId().getValue())
                .orElse(new FrvTarifierungsergebnisEntity());
        entity.setVorgangId(baustein.getVorgangId() != null ? baustein.getVorgangId().getValue() : null);
        mapper.mapToEntity(baustein, entity);
        jpaRepository.save(entity);
        return mapper.mapToDomain(entity);
    }
}
