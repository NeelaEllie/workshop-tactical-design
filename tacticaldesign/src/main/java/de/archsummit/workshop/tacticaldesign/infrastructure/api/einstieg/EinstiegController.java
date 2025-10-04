package de.archsummit.workshop.tacticaldesign.infrastructure.api.einstieg;

import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/einstieg")
@RequiredArgsConstructor
public class EinstiegController {

    private final VorschlagAnwendungskontextService anwendungskontextService;

    @GetMapping("/initialFrv")
    public ResponseEntity<Anwendungskontext> getInitialenFrvVorschlag() {
        final var anwendungskontext = anwendungskontextService.initFrv();
        return ResponseEntity.ok(anwendungskontext);
    }

    @GetMapping("/initialSbu")
    public ResponseEntity<Anwendungskontext> getInitialenSbuVorschlag() {
        final var anwendungskontext = anwendungskontextService.initSbu();
        return ResponseEntity.ok(anwendungskontext);
    }
}
