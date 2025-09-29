package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.vorschlag;

import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tarifierungsergebnis {

    private boolean valide;
    /**
     * Fehlermeldungen aus der Tarifierung
     */
    @Builder.Default
    private final Set<String> validierungsfehler = new HashSet<>();
    /**
     * Hinweise aus der Tarifierung
     */
    @Builder.Default
    private final Set<String> hinweise = new HashSet<>();
}
