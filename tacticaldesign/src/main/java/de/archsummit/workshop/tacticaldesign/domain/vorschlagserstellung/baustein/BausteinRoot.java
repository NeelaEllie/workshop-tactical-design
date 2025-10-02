package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein;

public interface BausteinRoot<T extends VorschlagBaustein<T>> {

    T getOrCreate(final VorgangId vorgangId);

}
