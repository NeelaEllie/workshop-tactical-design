package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.vorbelegung;

import java.util.List;
import org.springframework.stereotype.Component;
import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Berechnungsvorgabe;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Ergaenzungszahlung;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Wunschvorgabe;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Zahlweise;

@Component
class FrvBerechnungsvorgabeVorbelegung implements BerechnungsvorgabeVorbelegung {

    @Override
    public boolean isZustaendigFuer(Anwendungskontext kontext) {
        return kontext.getTarif().isFrv();
    }

    @Override
    public Berechnungsvorgabe get(VorgangId vorgangId) {
        return Berechnungsvorgabe.builder()
                .verfuegbar(true)
                .vorgangId(vorgangId)
                .wunschvorgabe(Wunschvorgabe.builder()
                        .verfuegbar(true)
                        .zahlweise(Zahlweise.MONATLICH)
                        .vorgabeart(Wunschvorgabe.Vorgabeart.BEITRAG)
                        .moeglicheVorgabearten(List.of(Wunschvorgabe.Vorgabeart.BEITRAG))
                        .ergaenzungszahlung(Ergaenzungszahlung.builder().verfuegbar(true).build())
                        .build())
                .build();
    }
}
