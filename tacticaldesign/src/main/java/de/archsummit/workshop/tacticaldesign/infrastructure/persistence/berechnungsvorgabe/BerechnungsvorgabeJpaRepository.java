package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.berechnungsvorgabe;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.berechnungsvorgabe.entity.BerechnungsvorgabeEntity;

public interface BerechnungsvorgabeJpaRepository extends JpaRepository<BerechnungsvorgabeEntity, Long> {

    Optional<BerechnungsvorgabeEntity> getBerechnungsvorgabeEntityByVorgangId(String vorgangId);
}
