# User Stories SE1 Übung 4

Autor: Juri Wiens
Matrikelnummer: 9023765

**Anmerkung**: Mir ist bewusst, dass die Stories nicht das INVEST Merkmal der Unabhängigkeit erfüllen. Dies schien mir aber nicht realisitisch umsetzbar.

**Referenzwert für Story Points (SP):** Ein idealer Arbeitstag.

## User Story 1

Studierende, Dozenten und weitere Mitarbeiter sollen sich mit den bestehenden Hochschul-Zugangsdaten an der Platform anmelden können. Damit können auf der Platform getätigte Aktion eindeutig zugeordnet werden, ohne sich ein weiteres Passwort merken zu müssen.

**Value: 5**
**Aufwand: 5 SP**

#### Tests
* Eine Anmeldung mit korrekten Hochschul-Zugangsdaten sollen den Zugang zur Platform ermöglichen.
* Eine Anmeldung mit nicht-korrekten Hochschul-Zugangsdaten sollen mit einer Fehlermeldung abgelehnt werden.

## User Story 2

Registrierte Benutzer können neue Beiträge in unterschiedlichen Foren einstellen, um sich rund um unterschiedliche Themengebiete auszutauschen.

**Value: 5**
**Aufwand: 5 SP**

#### Tests
* Erstellter Beitrag soll im entsprechenden Forum sichtbar werden.
* Beitrag ohne Betreff oder leerem Text soll mit einer Fehlermeldung abgelehnt werden.

## User Story 3

Registrierte Benutzern mit der Administratorrolle können diese Rolle weiteren Nutzern zuweisen, um den Administrationsaufwand auf mehrere Personen verteilen zu können.

**Value: 3**
**Aufwand: 3 SP**

#### Tests
* Nach Zuweisung der Rolle hat der zugewiesene Benutzer entsprechende Rechte.
* Ohne Zuweisung der Rolle hat der zugewiesene Benutzer keine entsprechende Rechte (mir ist kein besserer Negativ Test eingefallen...)

## User Story 4

Registrierte Benutzer mit der Administratorrolle können jegliche Beiträge bearbeiten bzw. komplett löschen. Damit können Beiträge mit anstößigem bzw. unerwünschtem Inhalt entfernt werden.

**Value: 4**
**Aufwand: 3 SP**

#### Tests
* Nach dem Löschen eines Beitrags durch einen Administrator ist der Beitrag nicht mehr sichtbar.
* Ein Zugriff auf die Funktion durch Nicht-Administratoren wird mit einer Fehlermeldung unterbunden.

## User Story 5

Registrierte Benutzer mit der Administratorrolle können neue Foren einrichten, um Diskussionen zu bestimmten Themengebieten zu kategorisieren und anzuregen.

**Value: 3**
**Aufwand: 3 SP**

#### Tests
* Nach der vollständigen Eingabe aller relevanten Daten ist das neue Forum sicht- und benutzbar.
* Ein Zugriff auf die Funktion durch Nicht-Administratoren wird mit einer Fehlermeldung unterbunden.

## User Story 6

Registrierte Benutzer können sich als *Contributor* registrieren und damit ihre Kompetenzen anbieten. Bei passenden Anfragen der Industrie kann damit eine Verbindung zu ihnen hergestellt werden.

**Value: 4**
**Aufwand: 5 SP**

#### Tests
* Nach der Registrierung als Contributor ist dieser Benutzer mit seiner Kompetenz in der Datenbank auffindbar.
* Die Eintragung ohne Angabe einer Kompetenz wird mit einer Fehlermeldung abgelehnt.

## User Story 7

Benutzer mit entsprechender Berechtigung können nach *Contributors* und deren Kompetenzen suchen bzw. filtern, um bei Anfragen aus der Industrie herausfinden zu können, ob diese bedient werden können.

**Value: 4**
**Aufwand: 8 SP**

#### Tests
* Ein in der Datenbank vorhandener Contributor wird über seine Kompetenz gefunden.
* Ein in der Datenbank vorhandener Contributor wird nicht über Kompetenzen gefunden, welche er nicht offeriert.

## User Story 8

An Kompetenzen interessierte Personen wie z.B. Vertreter der Industrie können in einem öffentlich zugänglichen Kontaktformular Anfragen stellen. Deren Anfragen können damit strukturiert verarbeitet werden.

**Value: 4**
**Aufwand: 3 SP**

#### Test
* Das Absenden des vollständig ausgefüllten Formulars führt zu einer Bestätigung und zur Sichtbarkeit in der entsprechenden Datenbank.
* Nicht ausgefüllte Pflichtfelder führen zu Fehlermeldungen.
