package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity.VorschlagEntity;

public interface VorschlagJpaRepository extends CrudRepository<VorschlagEntity, Long> {

    Optional<VorschlagEntity> getVorschlagEntityByVorgangId(String vorgangId);
}
