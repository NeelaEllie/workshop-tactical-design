package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.berechnungsvorgabe;

import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.BerechnungsvorgabeRepository;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Berechnungsvorgabe;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.berechnungsvorgabe.entity.BerechnungsvorgabeEntity;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.berechnungsvorgabe.mapper.BerechnungsvorgabeEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BerechnungsvorgabeRepositoryImpl implements BerechnungsvorgabeRepository {

    private final BerechnungsvorgabeJpaRepository jpaRepository;
    private final BerechnungsvorgabeEntityMapper mapper;

    @Override
    public Optional<Berechnungsvorgabe> get(VorgangId vorgangId) {
        return jpaRepository.getBerechnungsvorgabeEntitiesByVorgangId(vorgangId.getValue())
                .map(mapper::mapToDomain);
    }

    @Override
    public Berechnungsvorgabe save(Berechnungsvorgabe berechnungsvorgabe) {
        BerechnungsvorgabeEntity entity = jpaRepository
                .getBerechnungsvorgabeEntitiesByVorgangId(berechnungsvorgabe.getVorgangId().getValue())
                .orElse(new BerechnungsvorgabeEntity());
        mapper.mapToEntity(berechnungsvorgabe, entity);
        jpaRepository.save(entity);
        return mapper.mapToDomain(entity);
    }
}
