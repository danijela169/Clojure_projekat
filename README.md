Sirupi za mrsavljenje

Sirupi za mrsavljenje je Clojure CRUD aplikacija.

O aplikaciji 

Aplikacija je napravljena za narucivanje raznih vrsta sirupa za mrsavljenje od strane korisnika.
Korisnik ima opciju da izabere odredjenu vrstu i kolicinu sirupa i na taj nacin kreira narudzbinu. 
Takođe može da izmeni određenu narudzbinu ili da je obrise. Pri tome su odradjene validacije za minimalnu kolicinu 
odredjene vrste sirupa ( 1 sirup) i ukoliko se ne unese kolicina nemoguce je sacuvati narudzbinu, prikazuje se poruka
da korisnik mora uneti vrednost u polje kolicine. Korisnik ima opciju i da pretrazi sve narudzbine na osnovu naziva vrste sirupa.

Kako pokrenuti aplikaciju:
Za pokretanje aplikacije je potrebno imati instaliran Leiningen i MySQL bazu. 
-Potrebno je importovati fajl sirup_za_mrsavljenje.sql u MySQL
-Pokretanje web servera aplikacije putem komande: lein ring server
 
