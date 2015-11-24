# SE1 Übung 7 c)

Autor: Juri Wiens, Matrikelnummer: 9023765

#### (Positiver) Akzeptanztest des Use Case "Weiterleitung von Kompetenzanfragen"

| Teilschritt der Testprozedur  | Das zu erwartende Ergebnis  |
| ----------------------------- | --------------------------- |
| 1. Einloggen mit Test-Studenten-Account "teststud@h-brs.de", Passwort: "WittIstBoss" (*Vorbedingung*)| Hauptseite erscheint ohne Fehlermeldungen |
| 2. Aufruf der Unterseite zur Suche nach Jobangeboten (*Vorbedingung*) | Seite zur Suche nach Jobangeboten erscheint |
| 3. Der Student nutzt die Erweiterte Suche und gibt als Arbeitgeber "CONET", als Job-Beschreibung "Entwickler", als Gehalt "400" und als Gewünschte Studienrichtung "Informatik" in die entsprechenden Textfelder ein und bestätigt per Klick auf den "Suche" Button | Es erscheinen folgende zwei Suchergebnisse auf einer neuen Ergebnisseite: (ID: T1, Beschreibung: "TestJob 1") und (ID: T2, Beschreibung: "TestJob 2") |
| 4. Mit Datenbank-Client persistierte Suchanfragen zu Benutzer "teststud@h-brs.de" abrufen (*Nachbedingung*) | Die zuvor ausgeführte Suche wird angezeigt, alle gespeicherten Eingabewerte stimmen mit den getätigten Eingaben überein und es sind exakt zwei JobTreffer für die Jobs mit den IDs T1 und T2 verlinkt |
