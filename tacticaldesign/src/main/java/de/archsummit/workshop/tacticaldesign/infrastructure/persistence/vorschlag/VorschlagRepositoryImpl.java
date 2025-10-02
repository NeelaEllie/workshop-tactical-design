package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.VorschlagRepository;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model.Vorschlag;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity.VorschlagEntity;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.mapping.VorschlagEntityMapper;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class VorschlagRepositoryImpl implements VorschlagRepository {

    private final VorschlagCrudRepository vorschlagCrudRepository;
    private final VorschlagEntityMapper vorschlagEntityMapper;

    @Override
    public Optional<Vorschlag> get(VorgangId vorgangId) {
        return vorschlagCrudRepository.getVorschlagEntitiesByVorgangId(vorgangId.getValue())
                .map(vorschlagEntityMapper::mapToDomain);
    }

    @Override
    public Vorschlag save(Vorschlag vorschlag) {
        VorschlagEntity entity = vorschlagCrudRepository.getVorschlagEntitiesByVorgangId(
                        vorschlag.getVorgangId().getValue())
                .orElse(new VorschlagEntity());
        vorschlagEntityMapper.mapToEntity(vorschlag, entity);
        vorschlagCrudRepository.save(entity);
        return vorschlagEntityMapper.mapToDomain(entity);
    }
}
