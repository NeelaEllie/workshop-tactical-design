package de.archsummit.workshop.tacticaldesign.application.kontextermittlung;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tarif {

    private final Auspraegung wert;

    public static Tarif createFrv() {
        return new Tarif(Auspraegung.FRV);
    }

    public boolean isFrv() {
        return Auspraegung.FRV.equals(wert);
    }

    public enum Auspraegung {
        FRV, SBU;
    }
}
