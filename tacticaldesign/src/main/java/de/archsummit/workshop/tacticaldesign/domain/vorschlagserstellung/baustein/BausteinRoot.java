package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein;

public interface BausteinRoot {

    VorschlagBaustein getOrCreate(final VorgangId vorgangId);

}
