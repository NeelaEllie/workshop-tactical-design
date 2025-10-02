package de.archsummit.workshop.tacticaldesign.infrastructure.api.einstieg;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import de.archsummit.workshop.tacticaldesign.domain.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.domain.kontextermittlung.AnwendungskontextService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/einstieg")
@RequiredArgsConstructor
public class EinstiegController {

    private final AnwendungskontextService anwendungskontextService;

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
