package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.tarifierungsergebnis.sbu;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SbuTarifierungsergebnisJpaRepository extends JpaRepository<SbuTarifierungsergebnisEntity, Long> {

    Optional<SbuTarifierungsergebnisEntity> getSbuTarifierungsergebnisEntityByVorgangId(String vorgangId);
}
