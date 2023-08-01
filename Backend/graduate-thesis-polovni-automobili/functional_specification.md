# Funkcionalna specifikacija

## *Funkcionalni zahtevi*

Potrebno je implementirati aplikaciju za pretragu, postavljanje i uklanjanje automobila po uzoru na sajt polovniautomobili.com.


Korisnik aplikacije ima na raspolaganju sledeće funkcionalnosti:
1. Registracija korisnika. Administrator je predefinisan korisnik u sistemu. Korisnik prilikom registracije unosi:
    * Ime
    * Prezime
    * Država
    * Grad
    * Okrug
    * Poštanski broj
    * Adresa
    * Mobilni/fiksni
2. Prijava i odjava sa sistema. Na formi za prijavljivanje postoji link za prelaz na registraciju korisnika. Kada se korisnik uspešno prijavi na aplikaciju, omogućiti mu i da se odjavi. Bez prijave moguće je samo pregledati oglase i videti kontakt telefon korisnika koji je objavio oglas.
3. Dodavanje oglasa. Ulogovan korisnik ima mogućnost da postavi oglas. Polja potrebna za postavljanje oglasa su: 
   * Osnovne informacije:
     * Unos fotografija automobila
     * Marka i model
     * Godište
     * Karoserija
     * Gorivo
     * Obeležje motora(1.6 HDI, 2.0 TDI)
   * Dodatne informacije
     * Kubikaža motora
     * Snaga(kw/ks)
     * Kilometraža
     * Emisiona klasa motora
     * Pogon
     * Menjač
     * Broj vrata
     * Broj sedišta
     * Strana volana
     * Klima
     * Boja
     * Materijal enterijera
     * Boja enterijera
     * Registrovan do
     * Oštećenje
     * Zamena
   * Informacije o vlasništvu
     * Poreklo vozila
     * Broj šasije
   * Sigurnost vozila
     * Airbag za vozača
     * Airbag za suvozača
     * Bočni airbag
     * Child lock
     * ABS
     * ESP
     * ASR
     * Alarm
     * Senzor mrtvog ugla
     * Automatsko kočenje
     * Zaštita na automobilu
   * Stvari koje automobil poseduje od dodatne opreme 
   * Stanje vozila
     * Prvi vlasnik
     * Taxi vozilo
     * U garanciji
     * Test vozilo
     * Garažiran
     * Servisna knjiga
   * Način prodaje 
     * Komisiona
     * Konsignaciona
   * Cena
   * Opis oglasa 
     
4. Odobravanje oglasa. Nakon što je korisnik validno popunio podatke o automobilu, oglas je privremeno neaktivan, a da bi postao aktivan, potrebno je da ga administrator odobri. Ukoliko administrator ne odobri oglas, on menja stanje u odbijen i administrator je u obavezi da navede razlog zbog kog je oglas odbijen.
5. Ažuriranje podataka u oglasu. Korisnik koji je postavio oglas ima mogućnost da promeni podatke o istom.
6. Brisanje oglasa. Korisnik ima mogućnost da obriše oglas ukoliko to zeli.
7. Praćenje oglasa. Ulogovan korisnik ima mogućnost da zaprati oglas i time ga sаčuva u njegovu listu zapraćenih oglasa.
8. Obična i detaljna pretraga oglasa. Korisnik ima mogućnost da automobile pretraži samo po osnovnim informacija ukoliko se odluči za običnu pretragu. Ukoliko se odluči za detaljnu pretragu, moze je izvršiti po dodatnim informacijama.
9. Komunikacija izmedju korisnika. U slucaju da kupac želi da kontaktira prodavca, može videti njegov kontakt telefon.
10. Prijava oglasa. Korisnici imaju mogućnost da prijave oglas ukoliko smatraju da su:
    * Podaci netačno popunjeni
    * Prodato vozilo
    * Više vozila u jednom oglasu
    * Sumnja na prevaru
    * Reklamiranje usluga
    * Vredjanje u opisu oglasa
11. Pregled prijavljenih oglasa. Administrator ima mogućnost da pregleda sve prijavljene oglase i da na osnovu toga obriše oglas.
12. Izmena korisnikovih podataka na profilu. Dozvoliti korisniku da promeni lozinku, ali ne i svoje lične podatke.
13. Pregled ličnih oglasa i liste oglasa koje je korisnik zapratio. Korisnik ima mogućnost da pregleda svoje lične oglase i da ima listu oglasa koje prati.
14. U slučaju da korisnik prati oglas i on postane neaktivan, obavestiti korisnika preko e-mail adrese da oglas koji prati više nije aktivan.

### *Nefunkcionalni zahtevi*

* Podržati autentifikaciju korisnika upotrebom korisničkog imena i lozinke i autorizaciju korisnika upotrebom mehanizma tokena.
* Beležiti poruke o važnim događajim koji su nastali prilikom izvršavanja aplikacije
* Nakon potvrdjene forme za registraciju, korisnik će morati da udje na svoj mail i da potvrdi registraciju. Implementirati uz pomoć JavaMail biblioteke.


