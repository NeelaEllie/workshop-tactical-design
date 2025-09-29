package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Beitrag {

    private Zahlweise beitragsZahlweise;
    private Double wunschbeitrag;
    /**
     * Ist nur für FRV Produkte verfügbar.
     */
    private Double ergaenzungszahlung;

}

