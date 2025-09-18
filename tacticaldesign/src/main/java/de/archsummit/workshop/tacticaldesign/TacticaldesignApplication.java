package de.archsummit.workshop.tacticaldesign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.Tarif;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.model.Vorschlag;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.VorschlagService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.Vorschlagvalidierung;

@SpringBootApplication
public class TacticaldesignApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TacticaldesignApplication.class, args);

        VorschlagService vorschlagService = context.getBean(VorschlagService.class);
        Vorschlag vorschlag1 = vorschlagService.erstelleNeuenVorschlag(Tarif.FRV);
        Vorschlag vorschlag2 = vorschlagService.erstelleNeuenVorschlag(Tarif.FRV);

        Vorschlagvalidierung vorschlagvalidierung = context.getBean(Vorschlagvalidierung.class);
        vorschlagvalidierung.validiereFrv(vorschlag1.getVorgangId());
    }

}
