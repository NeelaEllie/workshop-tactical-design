package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.fondsauswahl;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.fondsauswahl.entity.FondsauswahlEntity;

public interface FondsauswahlJpaRepository extends JpaRepository<FondsauswahlEntity, Long> {

    Optional<FondsauswahlEntity> getFondsauswahlEntityByVorgangId(String vorgangId);
}
