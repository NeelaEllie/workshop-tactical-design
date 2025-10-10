# Fachlicher Kontext der Anwendung für die Aufgabenstellungen

Aufzuteilen ist die Fachdomäne "Vorschlagserstellung". In dieser befindet sich das Modell für einen
Vorschlag [Vorschlag.java](tacticaldesign/src/main/java/de/archsummit/workshop/tacticaldesign/domain/vorschlagserstellung/model/Vorschlag.java)
und Services für den generellen
Zugriff [VorschlagService.java](tacticaldesign/src/main/java/de/archsummit/workshop/tacticaldesign/domain/vorschlagserstellung/services/VorschlagService.java),
die produktspezifische
Validierung [FrvVorschlagvalidierung.java](tacticaldesign/src/main/java/de/archsummit/workshop/tacticaldesign/domain/vorschlagserstellung/services/validation/FrvVorschlagvalidierung.java)
und die
Vorbelegung [FrvVorschlagVorbelegung.java](tacticaldesign/src/main/java/de/archsummit/workshop/tacticaldesign/domain/vorschlagserstellung/services/vorbelegung/FrvVorschlagVorbelegung.java).
Es ist mit Fokus auf das Produkt "FRV" (Fondsgebundene Rentenversicherung) modelliert worden. Einige Vorbereitungen für
ein weiteres Produkt "SBU" (Schwere Berufsunfähigkeit) sind bereits getroffen worden.

## Der Vorschlag besteht aus folgenden Komponenten:

### Tarif

Der Tarif gibt das gewählte Produkt beim Einstieg wider. Er ist sowohl für die verfügbaren Produktmerkmale,
als auch für die relevanten Antragsbausteine entscheidend und wird üblicherweise nach dem Einstieg in einen Vorgang
nicht mehr angepasst.

### Versicherungsbeginn

Der Versicherungsbeginn ist eine notwendige Vorgabe für jedes Produkt. Es gibt bestimmte
fachliche Bedingungen wie weit im Voraus oder wie weit zurück der Beginn einer Versicherung datiert werden darf.
Basierend auf dem Versicherungsbeginn können verschiedene Laufzeiten, wie Beitragszahlungsdauer und Versicherungsdauer
berechnet werden.

### Geburtsdatum

Das Geburtsdatum der versicherten Person ist für jedes Leben Produkt eine notwendige Vorgabe.

### Beitrag

Einen Beitrag hat jedes Produkt. Wenn ein Wunschbeitrag vorgegeben wird, wird basierend darauf die resultierende Rente
ermittelt. Es gibt aber auch Produkte, bei denen eine Wunschrente vorgegeben wird und der Beitrag ermittelt wird.

### Laufzeit

Die Laufzeit umfasst verschiedene Laufzeiten einer Versicherung. Die Berechnung erfolgt über die Vorgabe
des zu erreichenden Alters, der Laufzeit in Jahren oder auch einer konkreten Jahreszahl. Zusammen mit dem
Versicherungsbeginn und in einigen Fällen des Geburtsdatums der versicherten Person werden die tatsächlichen
Laufzeiten nach produktübergreifenden Regeln ermittelt.

### Fondsauswahl

Die ausgewählten Fonds oder Portfolios mit der resultierenden Risikobewertung und der Angabe welche
beispielhaften Wertsteigerungen bei der Tarifierung mit berechnet werden sollen. Die Fondsauswahl ist nur für
fondsgebundene Produkte relevant.

### BUZ

Die Berufsunfähigkeitszusatzversicherung, welche nur aus einer Beitragsbefreiung (BUZ-BF) oder aber aus einer
BU-Rente (BUZ-BR) bestehen kann. Diese Zusatzversicherung ist nur bei bestimmten Produkten relevant und hat
eigene Laufzeiten und Beiträge.

### Tarifierungsergebnis

Das Ergebnis einer Tarifierung basierend auf allen gewählten Produktmerkmalen und Vorgaben.
Das Ergebnis kann auch nicht valide sein und transportiert in dem Falle Validierungsfehlermeldungen.
Die Zusammensetzung eines Tarifierungsergebnisses ist stark produktspezifisch.
