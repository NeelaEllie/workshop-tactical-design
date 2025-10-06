package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.tarifierungsergebnis.frv;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrvTarifierungsergebnisJpaRepository extends JpaRepository<FrvTarifierungsergebnisEntity, Long> {

    Optional<FrvTarifierungsergebnisEntity> getFrvTarifierungsergebnisEntityByVorgangId(String vorgangId);
}
