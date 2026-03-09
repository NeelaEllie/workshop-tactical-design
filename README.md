# Aufgabenstellungen Workshop

## Set-Up:

Es handelt sich um ein SpringBoot Projekt mit Maven in Java 21 und Lombok. Es muss somit ein entsprechendes JDK zur
Verfügung stehen, damit das Projekt lauffähig ist.
Es ist eine Swagger-UI konfiguriert: http://localhost:8080/swagger-ui/index.html

## Aufgabe 1: Einführung eines zweiten Produktes

* auf Basis des master Branches soll neben dem bestehenden Produkt "FRV" ein zweites Produkt "SBU" eingeführt
  werden
* Folgende Rahmenbedingungen sollen für dieses gelten:
    * ohne Fondsauswahl
    * Wunschrente als Vorgabevariante auch möglich (nicht nur Beitrag)
    * keine Ergänzungszahlung erlaubt

## Aufgabe 2a: Einführung von Aggregates

* auf Basis des master Branches soll der Vorschlag in sinnvolle Aggregates geschnitten werden
* beachte dafür den fachlichen Kontext: [README Fachlicher Kontext.md](README%20Fachlicher%20Kontext.md)
* Kriterien für den Schnitt von Aggregates mit möglichst geringer Komplexität und Abhängigkeit zu anderen Aggregates:
    1. Konsistenz im Lebenszyklus, Konsistenz von Transaktionen
    2. fachliche Konsistenz, Konsistenz der Problemdomäne:
        * Objekte, die in einem sehr engen fachlichen Bezug zueinander stehen, sollten in einem Aggregate
          zusammengefasst werden.
        * Beispiel Tarifierungsergbnisse sind stark produktabhängig. Der fachliche Kontext ist somit je Produkt ein
          anderer.
    3. Stabilität gemeinsamer Nutzung in Szenarien
        * welche fachlichen Szenarien umfassen welche Objekte?
        * Objekte in häufig auftretenden Szenarien sollten in einem Aggregate zusammengefasst werden
    4. Konsistenz der Änderungsfrequenz von Anforderungen an Objekten und Szenarien
        * umfasst eine Problemdomäne oder Szenario zu viele Objekte für ein Aggregate, ist für eine weitere Aufteilung
          die Analyse nach der Häufigkeit von fachlichen Änderungen an Objekten hilfreich
        * Objekte mit "stabilen" Anforderungen können von Objekten mit regelmäßig fachlich bedingten Änderungen getrennt
          werden
        * Beispiel Risikobewertung als große fachliche Domäne mit drei verschiedene Aggregates aufgrund
          unterschiedlicher Änderungsfrequenz: berufliche und Freizeit-Risiken und Gesundheitsfragen
* Quellen:
    * https://www.alibabacloud.com/blog/an-in-depth-understanding-of-aggregation-in-domain-driven-design_598034
    * https://www.informatik-aktuell.de/entwicklung/methoden/domain-driven-design-aggregate-design-am-konkreten-beispiel.html

## Aufgabe 2b: Erweiterung der Vorbelegung (und optional der Validierung)

* die Aufgabe kann auf Basis folgender Stände bearbeitet werden:
    * auf Basis des Branches "loesung_2a_einfuehrung_bausteine": nicht compilefähiger Zwischenschritt
    * auf Basis des Branches "loesung_2a_bausteine_vollstaendig": für einen vollständigen Stand, der einige
      Lösungsschritte bereits vorweg nimmt
    * auf Basis dem Ergebnis von Aufgabe 2a soll das zweite Produkt aus Aufgabe 1 eingebunden werden
* Wie kann die Validierung und ggfls. auch die Vorbelegung mithilfe der Aggregates realisiert werden?
* Welche Herausforderungen und welche Vorteile ergeben sich aus Aggregates?

## Ausblick:

* Auflösung von Abhängigkeiten zwischen Aggregates über Events
* Schaffung tatsächlicher Aggregate Roots (Anemic Domain Model vermeiden)