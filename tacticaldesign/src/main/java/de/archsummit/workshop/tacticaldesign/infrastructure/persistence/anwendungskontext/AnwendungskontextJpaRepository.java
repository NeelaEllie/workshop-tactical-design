package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.anwendungskontext;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface AnwendungskontextJpaRepository extends CrudRepository<AnwendungskontextEntity, Long> {

    Optional<AnwendungskontextEntity> findAnwendungskontextEntityByVorgangId(String vorgangId);
}



