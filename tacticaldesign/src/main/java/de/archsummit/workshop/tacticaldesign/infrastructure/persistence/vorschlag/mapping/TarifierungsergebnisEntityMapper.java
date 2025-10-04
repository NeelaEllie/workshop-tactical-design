package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.mapping;

import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag.model.Tarifierungsergebnis;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity.TarifierungsergebnisEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TarifierungsergebnisEntityMapper {

    public Tarifierungsergebnis mapToDomain(TarifierungsergebnisEntity entity) {
        if (entity == null) {
            return null;
        }
        Tarifierungsergebnis domain = new Tarifierungsergebnis();
        // Ableiten der Validität: keine Validierungsfehler => valide
        domain.setValide(entity.getValidierungsfehler() == null || entity.getValidierungsfehler().isEmpty());
        // Collections übertragen
        Set<String> validierungsfehler = domain.getValidierungsfehler();
        validierungsfehler.clear();
        if (entity.getValidierungsfehler() != null) {
            validierungsfehler.addAll(entity.getValidierungsfehler());
        }
        Set<String> hinweise = domain.getHinweise();
        hinweise.clear();
        if (entity.getHinweise() != null) {
            hinweise.addAll(entity.getHinweise());
        }
        return domain;
    }

    public TarifierungsergebnisEntity mapToEntity(Tarifierungsergebnis domain, TarifierungsergebnisEntity entity) {
        if (domain == null) {
            return null;
        }
        if (entity == null) {
            entity = new TarifierungsergebnisEntity();
        }
        // Collections übertragen (Listen im Entity)
        List<String> validierungsfehler = entity.getValidierungsfehler();
        if (validierungsfehler == null) {
            validierungsfehler = new ArrayList<>();
            entity.setValidierungsfehler(validierungsfehler);
        } else {
            validierungsfehler.clear();
        }
        if (domain.getValidierungsfehler() != null) {
            validierungsfehler.addAll(domain.getValidierungsfehler());
        }

        List<String> hinweise = entity.getHinweise();
        if (hinweise == null) {
            hinweise = new ArrayList<>();
            entity.setHinweise(hinweise);
        } else {
            hinweise.clear();
        }
        if (domain.getHinweise() != null) {
            hinweise.addAll(domain.getHinweise());
        }
        return entity;
    }
}
