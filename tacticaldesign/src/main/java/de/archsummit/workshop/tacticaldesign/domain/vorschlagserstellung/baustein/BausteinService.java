package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein;

public interface BausteinService {

    VorschlagBaustein getOrCreate(final VorgangId vorgangId);

}
