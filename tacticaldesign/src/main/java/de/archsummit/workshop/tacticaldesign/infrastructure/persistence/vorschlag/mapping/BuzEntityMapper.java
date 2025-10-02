package de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.mapping;

import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.model.Beruf;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.model.Buz;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.model.BuzBf;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.buz.model.BuzBr;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity.BerufEmbeddable;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity.BuzBfEmbeddable;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity.BuzBrEmbeddable;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.vorschlag.entity.BuzEntity;

@Component
public class BuzEntityMapper {

    public Buz mapToDomain(BuzEntity entity) {
        if (entity == null) {
            return null;
        }
        return Buz.builder()
                .beruf(mapBerufToDomain(entity.getBeruf()))
                .buzBf(mapBuzBfToDomain(entity.getBuzBf()))
                .buzBr(mapBuzBrToDomain(entity.getBuzBr()))
                .build();
    }

    private Beruf mapBerufToDomain(BerufEmbeddable beruf) {
        if (beruf == null) {
            return new Beruf();
        }
        return Beruf.builder()
                .id(beruf.getBerufId())
                .build();
    }

    private BuzBf mapBuzBfToDomain(BuzBfEmbeddable buzBf) {
        if (buzBf == null) {
            return new BuzBf();
        }
        return new BuzBf(buzBf.isGewaehlt(), buzBf.getEndalterLeistungsdauer());
    }

    private BuzBr mapBuzBrToDomain(BuzBrEmbeddable buzBr) {
        if (buzBr == null) {
            return new BuzBr();
        }
        return new BuzBr(buzBr.isGewaehlt(), buzBr.getEndalterLeistungsdauer(), buzBr.getWunschrente(),
                buzBr.isAzubiStudent());
    }

    public BuzEntity mapToEntity(Buz domain, BuzEntity entity) {
        if (domain == null) {
            return null;
        }
        if (entity == null) {
            entity = new BuzEntity();
        }
        entity.setBeruf(mapBerufToEntity(domain));
        entity.setBuzBf(mapBuzBfToEntity(domain));
        entity.setBuzBr(mapBuzBrToEntity(domain));
        return entity;
    }

    private BuzBrEmbeddable mapBuzBrToEntity(Buz domain) {
        if (domain == null || domain.getBuzBr() == null) {
            return null;
        }
        BuzBr domainBuzBr = domain.getBuzBr();
        return new BuzBrEmbeddable(domainBuzBr.isGewaehlt(), domainBuzBr.getEndalterLeistungsdauer(),
                domainBuzBr.getWunschrente(), domainBuzBr.isAzubiStudent());
    }

    private static BuzBfEmbeddable mapBuzBfToEntity(Buz domain) {
        if (domain == null || domain.getBuzBf() == null) {
            return null;
        }
        BuzBf domainBuzBf = domain.getBuzBf();
        return new BuzBfEmbeddable(domainBuzBf.isGewaehlt(), domainBuzBf.getEndalterLeistungsdauer());
    }

    private static BerufEmbeddable mapBerufToEntity(Buz domain) {
        if (domain == null || domain.getBeruf() == null) {
            return null;
        }
        return new BerufEmbeddable(domain.getBeruf().getId());
    }
}

