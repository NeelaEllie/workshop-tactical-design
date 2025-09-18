package de.archsummit.workshop.tacticaldesign.infrastructure.spring.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.VorschlagRepository;
import de.archsummit.workshop.tacticaldesign.infrastructure.persistence.VorschlagRepositoryImpl;

@Configuration
public class BeanConfiguration {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public VorschlagRepository repository() {
        return new VorschlagRepositoryImpl();
    }
}
