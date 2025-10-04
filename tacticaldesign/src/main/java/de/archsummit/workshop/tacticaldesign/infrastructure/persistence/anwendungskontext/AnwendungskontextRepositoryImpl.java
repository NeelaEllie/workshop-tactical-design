package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.anwendungskontext;

import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.AnwendungskontextRepository;
import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Tarif;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AnwendungskontextRepositoryImpl implements AnwendungskontextRepository {

    private final AnwendungskontextJpaRepository jpaRepository;

    @Override
    public Optional<Anwendungskontext> get(VorgangId vorgangId) {
        return jpaRepository.findById(vorgangId.getValue())
                .map(this::toDomain);
    }

    @Override
    public Anwendungskontext save(Anwendungskontext anwendungskontext) {
        AnwendungskontextEntity entity = toEntity(anwendungskontext);
        AnwendungskontextEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    private AnwendungskontextEntity toEntity(Anwendungskontext domain) {
        AnwendungskontextEntity entity = new AnwendungskontextEntity();
        entity.setVorgangId(domain.getVorgangId().getValue());
        entity.setTarif(domain.getTarif().getWert().name());
        return entity;
    }

    private Anwendungskontext toDomain(AnwendungskontextEntity entity) {
        return new Anwendungskontext(
                new VorgangId(entity.getVorgangId()),
                Tarif.builder().wert(Tarif.Auspraegung.valueOf(entity.getTarif())).build()
        );
    }
}

