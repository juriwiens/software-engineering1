# Antworten zur Übung 1

Autor: Juri Wiens
Matrikelnummer: 9023765

## Aufgabe 2.2
Die Klasse `GermanTranslator` ist aus zwei Gründen nicht kompilierbar:

- Die Methode `translateNumber` hat den Rückgabetyp `String` deklariert, gibt jedoch nichts zurück (kein `return` Statement vorhanden). Dies kann schnell (wenn auch unelegant) behoben werden, indem irgendein String per return zurückgegeben wird oder man wirft (etwas eleganter) eine Art `NotImplementedException`.

- Die Methode printAuthorInfo() besitzt eine `@Override` Annotation, jedoch besitzt das implementierte Interface Translator eine solche Methode nicht. Schnelle Lösung: Die Annotation entfernen bzw. über `translateNumber()` verschieben, dort ist diese nämlich angebracht.

Der Kommentar im Konstruktor der `Client` Klasse ist so nicht ganz korrekt, der leere Konstruktor kann theoretisch auch weggelassen werden, da der Java Compiler dann einen Default Constructor erzeugt. Das Client (explizit) von keiner Klasse abgeleitet ist, ist daher kein Grund und stimmt auch nicht ganz, da jede Klasse implizit von `Object` abgeleitet wird. Zu beachten ist jedoch, dass ein Default Constructor die Sichtbarkeit der Klasse übernimmt. Die Klasse ist diesem Fall paketsichtbar und der Konstruktor als `public` deklariert. Möchte man diese Konstellation haben, macht es dann aus diesem Grund Sinn.

## Aufgabe 2.3

Die Versionsnummer ist nicht zur Laufzeit anpassbar, da in Interfaces initialisierte Variablen immer `final` sind.

## Aufgabe 2.4
Der Vorteil einer seperaten Test Klasse ist alleine schon über "Single responsibility principle" gegeben, welches aussagt, dass jede Klasse nur eine Verantworlichkeit haben sollte. Die Klasse `Client` sollte danach lediglich ihre ursprüngliche Aufgaben erledigen und nicht noch zusätzlich für das "Sich-selbst-Testen" verantwortlich sein. Ein weiterer sich ergebener Vorteil ist, dass kann man für die Tests ein eigenes, abgegrenztes Szenario bauen kann. So können in einem solchen Szenario beispielsweise Abhängigkeiten durch Mock/Fake Objekte ersetzt werden um aufwändige/unerwünschte Aktionen wie z.B. Datenbankabfragen im Test zu unterbinden.

Ein Blackbox Test war mit der Code Vorgabe zunächst nicht ohne weiteres möglich, da die `execute`-Methode keine Funktionsrückgabe lieferte, sondern lediglich über das Ergebnis lediglich über `System.out.println()` ausgab. Da mir nicht bekannt war, wie ich letztere Ausgaben abfangen und auszuwerten könnte, habe ich die Funktion dahingehend verändert, dass diese die Rückgabe des `Translator` ebenfalls zurückgibt.

Die Anforderung nach "hinreichend" habe ich so interpretiert, dass die Tests möglichst alle möglichen Werte testen sollten. Da der Zahlenbereich von int endlich ist, wäre ein Test aller möglichen Werte zwar theoretisch möglich, würde aber eine lange Testlaufzeit nach sich ziehen. Stattdessen habe ich mich auf die Tests aller valider Werte und einiger ausgewählten Grenzfälle beschränkt. Als Grenzfälle habe ich die die Ränder des validen Zahlenbereichs genommen, sowie zusätzlich eine negative Zahl, dessen positiver Wert valide wäre.

## Aufgabe 2.5
Lösungen mittels Vererbungshierarchie sind in meiner Implementierung in zwei Varianten mit den Klassen `InheritedClient` und `DefaultClient` realisiert. Beide erben von Client und rufen innerhalb deren Konstruktor den Client-Konstruktor auf, um die `Translator` Abhängigkeit zu übergeben. Der Unteschied besteht darin dass beim `InheritedClient` ein beliebiger Translator übergeben werden kann und `DefaultClient` einfach ein "default" Translator genutzt wird.

Die `ClientBuilder` Lösung hat den Vorteil, dass die Verantwortlichkeiten der einzelnen Klassen klarer abgegrenzt sind, der Builder Klasse erzeugt einen Client, und Client selber trägt nur die eigentlichen Aufgaben eines Clients. Bei der Nutzung von `InheritedClient` und `DefaultClient` ist hingegeben nur der Umgang mit einer einzigen Klasse nötig, anstatt mit zwei.
