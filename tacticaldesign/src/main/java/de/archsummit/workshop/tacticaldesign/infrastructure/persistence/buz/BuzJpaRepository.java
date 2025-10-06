package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.buz;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.buz.entity.BuzEntity;

public interface BuzJpaRepository extends JpaRepository<BuzEntity, Long> {

    Optional<BuzEntity> getBuzEntityByVorgangId(String vorgangId);
}
