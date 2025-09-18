package de.archsummit.workshop.tacticaldesign.infrastructure.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.Vorschlag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.VorschlagRepository;

public class VorschlagRepositoryImpl implements VorschlagRepository {

    private Map<VorgangId, Vorschlag> vorschlagListe = new HashMap<>();

    @Override
    public Optional<Vorschlag> getVorschlag(VorgangId vorgangId) {
        return Optional.ofNullable(vorschlagListe.get(vorgangId));
    }

    @Override
    public Vorschlag save(Vorschlag vorschlag) {
        vorschlagListe.put(vorschlag.getVorgangId(), vorschlag);
        return vorschlag;
    }
}
