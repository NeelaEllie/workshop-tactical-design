package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.berechnungsvorgabe.mapper;

import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Ergaenzungszahlung;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Wunschvorgabe;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Wunschvorgabe.Vorgabeart;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Zahlweise;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.berechnungsvorgabe.entity.ErgaenzungszahlungEmbeddable;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.berechnungsvorgabe.entity.WunschvorgabeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class BeitragEntityMapper {

    public Wunschvorgabe mapToDomain(WunschvorgabeEntity entity) {
        if (entity == null) {
            return null;
        }
        Ergaenzungszahlung ergaenzungszahlung;
        if (entity.getErgaenzungszahlung() == null) {
            ergaenzungszahlung = new Ergaenzungszahlung();
        } else {
            ergaenzungszahlung = Ergaenzungszahlung.builder()
                    .verfuegbar(entity.getErgaenzungszahlung().isVerfuegbar())
                    .wert(entity.getErgaenzungszahlung().getWert())
                    .build();
        }
        List<Vorgabeart> moeglicheVorgabearten = entity.getMoeglicheVorgabearten() == null ? new ArrayList<>()
                : entity.getMoeglicheVorgabearten().stream()
                .filter(Objects::nonNull)
                .map(Vorgabeart::valueOf)
                .collect(Collectors.toList());
        return Wunschvorgabe.builder()
                .verfuegbar(entity.isVerfuegbar())
                .zahlweise(entity.getZahlweise() != null ? Zahlweise.valueOf(entity.getZahlweise()) : null)
                .wunschbetrag(entity.getWunschbetrag())
                .vorgabeart(entity.getVorgabeart() != null ? Vorgabeart.valueOf(entity.getVorgabeart()) : null)
                .moeglicheVorgabearten(moeglicheVorgabearten)
                .ergaenzungszahlung(ergaenzungszahlung)
                .build();
    }

    public WunschvorgabeEntity mapToEntity(Wunschvorgabe domain, WunschvorgabeEntity entity) {
        if (domain == null) {
            return null;
        }
        if (entity == null) {
            entity = new WunschvorgabeEntity();
        }
        entity.setVerfuegbar(domain.isVerfuegbar());
        entity.setZahlweise(domain.getZahlweise() != null ? domain.getZahlweise().name() : null);
        entity.setWunschbetrag(domain.getWunschbetrag());
        entity.setVorgabeart(domain.getVorgabeart() != null ? domain.getVorgabeart().name() : null);
        entity.setMoeglicheVorgabearten(domain.getMoeglicheVorgabearten() == null ? null : domain.getMoeglicheVorgabearten().stream()
                .filter(Objects::nonNull)
                .map(Enum::name)
                .collect(Collectors.toList()));
        if (domain.getErgaenzungszahlung() == null) {
            entity.setErgaenzungszahlung(null);
        } else {
            ErgaenzungszahlungEmbeddable emb = new ErgaenzungszahlungEmbeddable();
            emb.setVerfuegbar(domain.getErgaenzungszahlung().isVerfuegbar());
            emb.setWert(domain.getErgaenzungszahlung().getWert());
            entity.setErgaenzungszahlung(emb);
        }
        return entity;
    }

}
