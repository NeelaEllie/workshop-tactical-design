package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Anwendungskontext;
import de.archsummit.workshop.tacticaldesign.application.kontextermittlung.Tarif;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.VorgangId;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.model.Berechnungsvorgabe;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein.berechnungsvorgabe.vorbelegung.BerechnungsvorgabeVorbelegungHandler;
import de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.services.VorschlagAnwendungskontextService;

@ExtendWith(MockitoExtension.class)
class BerechnungsvorgabeRootTest {

    @Mock
    private VorschlagAnwendungskontextService anwendungskontextService;
    @Mock
    private BerechnungsvorgabeRepository repository;
    @Mock
    private BerechnungsvorgabeVorbelegungHandler vorbelegungHandler;
    @InjectMocks
    private BerechnungsvorgabeService classundertest;

    @Test
    void getOrCreate_returnsExistingBerechnungsvorgabe() {
        VorgangId vorgangId = new VorgangId("123");
        Berechnungsvorgabe vorgabe = mock(Berechnungsvorgabe.class);
        when(repository.get(vorgangId)).thenReturn(Optional.of(vorgabe));

        Berechnungsvorgabe result = classundertest.getOrCreate(vorgangId);

        assertSame(vorgabe, result);
        verify(repository, never()).save(any());
    }

    @Test
    void getOrCreate_createsAndSavesBerechnungsvorgabeIfNotExists() {
        VorgangId vorgangId = new VorgangId("456");
        Anwendungskontext anwendungskontext = new Anwendungskontext(new VorgangId("1234"), Tarif.createFrv());
        Berechnungsvorgabe vorgabe = mock(Berechnungsvorgabe.class);

        when(repository.get(vorgangId)).thenReturn(Optional.empty());
        when(anwendungskontextService.get(vorgangId)).thenReturn(anwendungskontext);
        when(vorbelegungHandler.get(anwendungskontext)).thenReturn(vorgabe);
        when(repository.save(vorgabe)).thenReturn(vorgabe);

        Berechnungsvorgabe result = classundertest.getOrCreate(vorgangId);

        assertSame(vorgabe, result);
        verify(repository).save(vorgabe);
    }
}