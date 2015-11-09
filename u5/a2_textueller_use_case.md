# SE1 Übung 5, Aufgabe 2

Autor: Juri Wiens
Matrikelnummer: 9023765

**Name des Systems**: N@HBRS

**Name des Use Cases**: Weiterleitung von Kompetenzanfragen

**Teilnehmende Akteure**: Professor, Student

**Ereignisfluss:**
* Professor markiert Kompetenzanfragen und klickt auf "Weiterleiten" Button.
  * SYSTEM reagiert mit einem neuen Dialogfenster, in welchem die E-Mail Adressen von Studierenden zur Auswahl als Empfänger angeboten werden.
* Professor fügt ein oder mehrere E-Mail Adressen durch Klicken auf "+" Button zu Empfänger-Liste hinzu.
* Professor bestätigt durch einen Klick auf "Weiterleiten" Button.
  * SYSTEM sendet Informationen zu ausgewählten Kompetenzanfragen an ausgewälte E-Mail Adressen.
  * SYSTEM bestätigt erfolgreichen Versand in einer separaten Maske.

**Vorbedingung:**
* Professor ist als solcher registriert und eingeloggt.
* Professor hat eine Suche nach Kompetenzanfragen durchgeführt und hat Ergebnisliste geöffnet.

**Nachbedingung:** Die E-Mails wurden an die betreffenden Personen verschickt.

**Qualitätsanforderungen:** Eine E-Mail soll binnen 3 Sekunden versendet werden.

---

#### Test Case für den Akzeptanztest des Use Case "Weiterleitung von Kompetenzanfragen"

| Teilschritt der Testprozedur  | Das zu erwartende Ergebnis  |
| ----------------------------- | --------------------------- |
| 1. Als Professor einloggen und nach Kompetenzanfrage "C++" suchen | Ergebnisliste der Kompetenzanfragen erscheint |
| 2. Professor markiert mehrere Kompetenzanfragen | Kompetenzanfragen sind als markiert erkennbar |
| 3. Professor klickt auf "Weiterleiten" Button | Neues Dialogfenster mit E-Mail Adressen von Studierenden erscheint |
| 4. Professor fügt mehrere E-Mail Adressen durch Klicken "+" Button hinzu | Gewählte E-Mail Adressen erscheinen in Empfänger-Liste |
| 5. Professor bestätigt Versand durch einen Klick auf "Weiterleiten" Button | Versandbestätigung erscheint |
| 6. Ausgewählte Empfänger haben E-Mail erhalten | / |
