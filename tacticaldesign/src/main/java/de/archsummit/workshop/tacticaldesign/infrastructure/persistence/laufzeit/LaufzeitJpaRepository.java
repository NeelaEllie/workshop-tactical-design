package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.laufzeit;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaufzeitJpaRepository extends JpaRepository<LaufzeitEntity, Long> {

    Optional<LaufzeitEntity> getLaufzeitEntityByVorgangId(String vorgangId);
}
