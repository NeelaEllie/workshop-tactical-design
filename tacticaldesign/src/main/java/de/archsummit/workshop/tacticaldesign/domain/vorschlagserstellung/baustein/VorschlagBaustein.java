package de.archsummit.workshop.tacticaldesign.domain.vorschlagserstellung.baustein;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public interface VorschlagBaustein<T> {

    /**
     * Gibt die Referenz auf den übergeordneten Vorgang zurück
     *
     * @return Vorgang ID.
     */
    VorgangId getVorgangId();

    /**
     * Gibt das Kennzeichen zurück, ob die Komponente für den aktuellen Tarif und bisherigen Eingabedaten verfügbar,
     * d.h. potenziell nutzbar ist.
     * <p/>
     * Eine NICHT verfügbare Komponente darf nicht weiter verarbeitet bzw. für Konvertierungen und Validierungen
     * beachtet werden.
     *
     * @return Kennzeichen der Verfügbarkeit.
     */
    boolean isVerfuegbar();

    default void ifVerfuegbar(final Consumer<T> consumer) {
        if (isVerfuegbar()) {
            consumer.accept(getThis());
        }
    }

    default void ifVerfuegbarOrElse(final Consumer<T> consumer, final Runnable runnable) {
        if (isVerfuegbar()) {
            consumer.accept(getThis());
        } else {
            runnable.run();
        }
    }

    /**
     * Wenn es vorhanden ist, wird die Mapping-Function aufgerufen, ansonsten wird ein {@link Optional#empty()}
     * zurückgegeben.
     *
     * @param mapper die Mapping-Function, die aufgerufen wird, wenn {@link #isVerfuegbar()}
     * @param <U> Rückgabetyp der Mapping-Function
     * @return liefert ein {@code Optional} mit dem gemappten Ergebnis oder ein {@link Optional#empty()}.
     * @throws NullPointerException wenn die Mapping-Function {@code null} ist.
     */
    default <U> Optional<U> map(final Function<? super T, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        if (!isVerfuegbar()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(mapper.apply(getThis()));
        }
    }

    @SuppressWarnings("unchecked")
    private T getThis() {
        return (T) this;
    }
}
