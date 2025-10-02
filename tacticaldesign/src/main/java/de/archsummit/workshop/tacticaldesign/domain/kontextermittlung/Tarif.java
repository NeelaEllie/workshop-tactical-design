package de.archsummit.workshop.tacticaldesign.domain.kontextermittlung;

import lombok.Data;

@Data
public class Tarif {

    private final Auspraegung wert;

    public static Tarif createFrv() {
        return new Tarif(Auspraegung.FRV);
    }

    public boolean isFrv() {
        return Auspraegung.FRV.equals(wert);
    }

    public static Tarif createSbu() {
        return new Tarif(Auspraegung.SBU);
    }

    public boolean isSbu() {
        return Auspraegung.SBU.equals(wert);
    }

    enum Auspraegung {
        FRV, SBU;
    }
}
