# Aufgabenstellungen Workshop

## Set-Up:

Es handelt sich um ein SpringBoot Projekt mit Maven in Java 21. Es müsste somit ein entsprechendes JDK zur Verfügung
stehen.
Es ist eine Swagger-UI konfiguriert: http://localhost:8080/swagger-ui/index.html

## Aufgabe 1: Einführung eines zweiten Produktes

* Folgende Rahmenbedingungen sollen gelten:
    * ohne BUZ
    * Wunschrente als Vorgabevariante auch möglich (nicht nur Beitrag)
    * keine Ergänzungszahlung erlaubt

## Aufgabe 2a: Einführung von Aggregates

* Vorbereitender Theorieblock:
    * Herausforderung: wo steckt das Wissen, welche Unterkomponenten für welche Produkte verfügbar sind und welche
      Ausprägung erlaubt ist, wenn man ein Vorschlagsobjekt hat?
    * Lösungsansatz: Produktspezifische Vorschlagobjekte wäre denkbar, erzeugt jedoch eine hohe Redundanz und Verteilung
      von Fachlichkeit, die eigentlich zusammen gehört
    * Aggregate Schnitt mit Kriterien

## Aufgabe 2b: Erweiterung der Validierung (Vorbelegung)