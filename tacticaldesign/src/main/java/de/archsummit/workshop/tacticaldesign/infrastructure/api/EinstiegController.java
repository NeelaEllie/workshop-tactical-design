package de.archsummit.workshop.tacticaldesign.infrastructure.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.AnwendungskontextService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/einstieg")
@RequiredArgsConstructor
public class EinstiegController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EinstiegController.class);
    private final AnwendungskontextService anwendungskontextService;

    @GetMapping("/initialFrv")
    public ResponseEntity<Anwendungskontext> getInitialenFrvVorschlag() {
        try {
            final var anwendungskontext = anwendungskontextService.initFrv();
            return ResponseEntity.ok(anwendungskontext);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

}
