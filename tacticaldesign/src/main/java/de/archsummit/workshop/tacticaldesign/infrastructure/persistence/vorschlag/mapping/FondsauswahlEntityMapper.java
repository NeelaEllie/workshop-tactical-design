package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.mapping;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.Fondsauswahl;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.FondsAnteil;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.fondsauswahl.Risikoerwartung;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity.FondsauswahlEntity;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity.FondsAnteilEntity;

import java.util.stream.Collectors;

@Component
public class FondsauswahlEntityMapper {

    public Fondsauswahl mapToDomain(FondsauswahlEntity entity) {
        if (entity == null) {
            return null;
        }
        Fondsauswahl domain = new Fondsauswahl();
        domain.setRisikoerwartung(
                entity.getRisikoerwartung() != null ? Risikoerwartung.valueOf(entity.getRisikoerwartung()) : null);
        domain.setWertsteigerungMinimum(entity.getWertsteigerungMinimum());
        domain.setWertsteigerungMittel(entity.getWertsteigerungMittel());
        domain.setWertsteigerungMaximum(entity.getWertsteigerungMaximum());
        domain.setWertsteigerungIndividuell(entity.getWertsteigerungIndividuell());
        if (entity.getFondsAnteile() != null) {
            domain.setFondsAnteile(entity.getFondsAnteile().stream()
                    .map(this::mapFondsAnteilToDomain)
                    .collect(Collectors.toList()));
        }
        return domain;
    }

    public FondsauswahlEntity mapToEntity(Fondsauswahl domain, FondsauswahlEntity entity) {
        if (domain == null) {
            return null;
        }
        if (entity == null) {
            entity = new FondsauswahlEntity();
        }
        entity.setRisikoerwartung(domain.getRisikoerwartung() != null ? domain.getRisikoerwartung().name() : null);
        entity.setWertsteigerungMinimum(domain.getWertsteigerungMinimum());
        entity.setWertsteigerungMittel(domain.getWertsteigerungMittel());
        entity.setWertsteigerungMaximum(domain.getWertsteigerungMaximum());
        entity.setWertsteigerungIndividuell(domain.getWertsteigerungIndividuell());
        if (domain.getFondsAnteile() != null) {
            entity.setFondsAnteile(domain.getFondsAnteile().stream()
                    .map(this::mapFondsAnteilToEntity)
                    .collect(Collectors.toList()));
        } else {
            entity.setFondsAnteile(null);
        }
        return entity;
    }

    private FondsAnteil mapFondsAnteilToDomain(FondsAnteilEntity entity) {
        if (entity == null) {
            return null;
        }
        return FondsAnteil.builder()
                .isin(entity.getIsin())
                .anteil(entity.getAnteil())
                .build();
    }

    private FondsAnteilEntity mapFondsAnteilToEntity(FondsAnteil domain) {
        if (domain == null) {
            return null;
        }
        FondsAnteilEntity entity = new FondsAnteilEntity();
        entity.setIsin(domain.getIsin());
        entity.setAnteil(domain.getAnteil());
        return entity;
    }
}
