package de.archsummit.workshop.tacticaldesign.infrastructure.springboot.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.VorschlagService;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.validation.Vorschlagvalidierung;

@Configuration
public class VorschlagerstellungBeanConfiguration {

    @Bean
    public VorschlagService vorschlagService() {
        return new VorschlagService();
    }

    @Bean
    public Vorschlagvalidierung vorschlagvalidierung() {
        return new Vorschlagvalidierung();
    }
}
