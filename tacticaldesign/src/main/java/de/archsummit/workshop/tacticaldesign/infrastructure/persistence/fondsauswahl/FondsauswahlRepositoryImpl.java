package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.fondsauswahl;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.FondsauswahlRepository;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.model.Fondsauswahl;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.fondsauswahl.entity.FondsauswahlEntity;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.fondsauswahl.mapper.FondsauswahlEntityMapper;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FondsauswahlRepositoryImpl implements FondsauswahlRepository {

    private final FondsauswahlJpaRepository jpaRepository;
    private final FondsauswahlEntityMapper mapper;

    @Override
    public Optional<Fondsauswahl> get(VorgangId vorgangId) {
        return jpaRepository.getFondsauswahlEntityByVorgangId(vorgangId.getValue())
                .map(mapper::mapToDomain);
    }

    @Override
    public Fondsauswahl save(Fondsauswahl fondsauswahl) {
        FondsauswahlEntity entity = jpaRepository
                .getFondsauswahlEntityByVorgangId(fondsauswahl.getVorgangId().getValue())
                .orElse(new FondsauswahlEntity());
        entity.setVorgangId(fondsauswahl.getVorgangId() != null ? fondsauswahl.getVorgangId().getValue() : null);
        mapper.mapToEntity(fondsauswahl, entity);
        jpaRepository.save(entity);
        return mapper.mapToDomain(entity);
    }
}
