package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.berechnungsvorgabe;

import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.berechnungsvorgabe.entity.BerechnungsvorgabeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BerechnungsvorgabeJpaRepository extends JpaRepository<BerechnungsvorgabeEntity, Long> {

    Optional<BerechnungsvorgabeEntity> getBerechnungsvorgabeEntitiesByVorgangId(String vorgangId);
}
