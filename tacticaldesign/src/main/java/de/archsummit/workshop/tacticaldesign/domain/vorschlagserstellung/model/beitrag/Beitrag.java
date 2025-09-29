package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.beitrag;

import java.math.BigDecimal;
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

