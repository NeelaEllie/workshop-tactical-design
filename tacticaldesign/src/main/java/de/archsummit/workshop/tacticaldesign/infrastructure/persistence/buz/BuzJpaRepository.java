package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.buz;

import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.buz.entity.BuzEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuzJpaRepository extends JpaRepository<BuzEntity, Long> {

    Optional<BuzEntity> getBuzEntitiesByVorgangId(String vorgangId);
}
