import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

public class Legesystem1 {

    protected IndeksertListe<Pasient> pasientListe = new IndeksertListe<Pasient>();
    protected IndeksertListe<Legemiddel> legemiddelListe = new IndeksertListe<Legemiddel>();
    protected Prioritetskoe<Lege> legeListe = new Prioritetskoe<Lege>();
    protected IndeksertListe<Resept> reseptListe = new IndeksertListe<Resept>();

    // E1
    public void lesFraFil(String filnavn) throws UlovligUtskrift {
        Scanner lesInn = null;

        try {
            lesInn = new Scanner(new File(filnavn));
        } catch (FileNotFoundException e) {
            System.out.println("Finner ikke filen!");
            System.exit(-1);
        }

        while (lesInn.hasNextLine()) {
            String linjer = lesInn.nextLine();// leser #
            linjer = lesInn.nextLine();

            try {
                // Pasient(navn, fNr)
                System.out.println("Test pasient");
                while (!(linjer.startsWith("#"))) {
                    String[] linje = linjer.split(",");

                    String navn = linje[0];
                    System.out.println("\npasientNavn: " + navn);

                    String fNr = linje[1];
                    System.out.println("pasientfNr: " + fNr);

                    if (linje.length == 2 && fNr.length() == 11) {
                        Pasient pasientdata = new Pasient(navn, fNr);
                        pasientListe.leggTil(pasientdata);
                    }
                    linjer = lesInn.nextLine();
                }
                // Legemiddel(String navn, int pris, double virkestoff){
                // Legemidler (navn,type,pris,virkestoff,[styrke])
                linjer = lesInn.nextLine();// leser #
                System.out.println("\ntest legemiddel");
                while (!(linjer.startsWith("#"))) {
                    String[] linje = linjer.split(",");

                    String navn = linje[0];
                    System.out.println("\nlegemiddelnavn: " + navn);

                    String type = linje[1];
                    System.out.println("legemiddeltype: " + type);

                    int pris = Integer.parseInt(linje[2]);
                    System.out.println("legemiddelpris: " + pris);

                    double virkestoff = Double.parseDouble(linje[3]);
                    System.out.println("legemiddel virkestoff: " + virkestoff);

                    if (linje.length > 4) {
                        int styrke = Integer.parseInt(linje[4]);
                        System.out.println("legemiddel styrk: " + styrke);

                        if (type.equals("narkotisk")) {
                            Legemiddel narkostiskData = new Narkotisk(navn, pris, virkestoff, styrke);
                            legemiddelListe.leggTil(narkostiskData);

                        }
                        if (type.equals("vanedannende")) {
                            Legemiddel vanedannendeData = new Vanedannende(navn, pris, virkestoff, styrke);
                            legemiddelListe.leggTil(vanedannendeData);
                        }
                    } else {
                        if (type.equals("vanlig")) {
                            Legemiddel vanligdata = new Vanlig(navn, pris, virkestoff);
                            legemiddelListe.leggTil(vanligdata);
                        }
                    }
                    linjer = lesInn.nextLine();
                }

                // lege konstruktør(navn)
                // spesielist konstruktør(navn, kID)

                linjer = lesInn.nextLine();
                System.out.println("\nTest lege:");
                while (!(linjer.startsWith("#"))) {
                    String[] linje = linjer.split(",");

                    String navn = linje[0];
                    System.out.println("\nlegenavn: " + navn);

                    String kontrollid = linje[1];
                    System.out.println("kontrollID: " + kontrollid);

                    if (kontrollid.equals("0")) {
                        Lege legeData = new Lege(navn);
                        legeListe.leggTil(legeData);
                    } else {
                        Spesialist spesialistData = new Spesialist(navn, kontrollid);
                        legeListe.leggTil(spesialistData);
                    }
                    linjer = lesInn.nextLine();
                }

                // Resept( Legemiddel legemid, Lege utSkrLege, Pasient pID, int reit )
                // # Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])

                linjer = lesInn.nextLine();
                System.out.println("\ntest resept: ");
                while (!(linjer.startsWith("#"))) {
                    String[] linje = linjer.trim().split(",");
                    System.out.println(Arrays.toString(linje));

                    int legemiddelNr = Integer.parseInt(linje[0]);
                    System.out.println("\nLegemiddelnummer: " + legemiddelNr);

                    String legeNavn = linje[1];
                    System.out.println("legeNavn: " + legeNavn);

                    int pasientID = Integer.parseInt(linje[2]);
                    System.out.println("pasientID: " + pasientID);

                    String type = linje[3];
                    System.out.println("resepttype: " + type);

                    Legemiddel legmid = null;
                    Lege lg = null;
                    Pasient pas = null;
                    int reit = 3;

                    if (!type.equals("militaer")) {
                        reit = Integer.parseInt(linje[4]);
                        System.out.println("reit: " + reit + "\n");
                    }
                    for (Legemiddel lm : legemiddelListe) {
                        if (lm.hentId() == legemiddelNr) {
                            legmid = lm;
                        }
                    }

                    for (Lege lege : legeListe) {
                        if (lege.hentNavn().equals(legeNavn)) {
                            lg = lege;
                        }
                    }

                    for (Pasient pasient : pasientListe) {
                        if (pasient.hentId() == pasientID) {
                            pas = pasient;
                        }
                    }

                    // linjer = lesInn.nextLine();
                    if (type.equals("blaa")) {
                        Resept blaaResept = lg.skrivBlaaResept(legmid, pas, reit);
                        reseptListe.leggTil(blaaResept);
                    }

                    else if (type.equals("hvit")) {
                        Resept hviteResept = lg.skrivHvitResept(legmid, pas, reit);
                        reseptListe.leggTil(hviteResept);

                    }

                    else if (type.equals("p")) {
                        Resept pResept = lg.skrivPResept(legmid, pas, reit);
                        reseptListe.leggTil(pResept);

                    }

                    else if (type.equals("militaer")) {
                        Resept milResept = lg.skrivMilResept(legmid, pas);
                        reseptListe.leggTil(milResept);
                    }
                    if (lesInn.hasNextLine()) {
                        linjer = lesInn.nextLine();
                    } else {
                        linjer = "#";
                    }
                }
            } catch (Exception e) {
                System.out.println("Hele filen er lest!");
                System.exit(-1);
            }
        }
        lesInn.close();
        System.out.println("innlesing er ferdi");
    }

    @Override
    public String toString() {
        String str = " ";
        return str;
    }

    public void LegesystemMeny() {
        System.out.println("----------------------------------------");
        System.out.println("velkommen til Legesystem her kan du se, legge til og faa info om \n"
                + "Leger, legemiddel og Pasienter");
        System.out.println("velg hva du vil gjoere ved aa skrive inn tall fra 0-5");
        System.out.println("----------------------------------------");
        int userInputE2;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("----------------------------------------");
            System.out.println(
                    "tast 1 for aa Skrive ut en fullstendig oversikt over pasienter, leger, legemidler og resepter");
            System.out.println("tast 2 for aa Opprette og legge til nye elementer i systemet");
            System.out.println("tast 3 for aa Bruke en gitt resept fra listen til en pasient");
            System.out.println("tast 4 for aa Skrive ut forskjellige former for statistikk");
            System.out.println("tast 5 for aa Skrive alle data til fil");
            System.out.println("tast 0 for aa avslutte program");
            System.out.println("----------------------------------------");
            System.out.println(" ");

            userInputE2 = sc.nextInt();
            switch (userInputE2) {

                case 1:
                    skrivUt();
                    break;

                case 2:
                    leggTilNyttObjekt();
                    break;

                case 3:
                    interaksjon();
                    break;

                case 4:
                    subMenyValg();
                    break;

                case 5:
                    lagFil();
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("komando " + userInputE2 + " er ikke gjenskjennelig proev paa nytt");
                    break;

            }
        } while (userInputE2 != 0);
        sc.close();
    }

    // E3
    public void skrivUt() {

        System.out.println("----Paseint Info----\n");
        for (Pasient pas : pasientListe) {
            System.out.println(pas);
            System.out.println("----------");
        }

        System.out.println("\n----Legemiddel Info----");
        for (Legemiddel lm : legemiddelListe) {
            System.out.println(lm);
            System.out.println("----------");
        }

        System.out.println("\n----Lege Info----");
        for (Lege l : legeListe) {
            System.out.println(l);
            System.out.println("----------");
        }

        System.out.println("\n----Resept Info----");
        for (Resept r : reseptListe) {
            System.out.println(r.hentLegemiddel());
            System.out.println(r.hentLege());
            System.out.println(r.hentPasient());
            System.out.println("----------");
        }
    }

    // E4
    public void leggTilNyttObjekt() {
        // opprette og legge til nytt lege Objekt
        Scanner sc = new Scanner(System.in);

        Lege lege = null;
        Pasient pasient = null;
        Legemiddel legemiddel = null;
        Resept resept = null;

        System.out.println("Legg til nytt legenavn");
        String legenavn = sc.nextLine();

        System.out.println("Hvis legen er spesialist, skriv kontrollID/ ellers skriv 0");
        String kontrollID = sc.nextLine();

        if (kontrollID.equals("0")) {
            Lege nyLege = new Lege(legenavn);
            legeListe.leggTil(nyLege);
            lege = nyLege;
        } else {
            Lege nySpe = new Spesialist(legenavn, kontrollID);
            legeListe.leggTil(nySpe);
            lege = nySpe;
        }

        // oprette og legge til nytt pasient objekt
        System.out.println("Legg til nytt pasientnavn");
        String pasientnavn = sc.nextLine();

        System.out.println("Legg til pasient foedselsnummer");
        String pasientFnr = sc.nextLine();

        Pasient nypasient = new Pasient(pasientnavn, pasientFnr);
        pasientListe.leggTil(nypasient);
        pasient = nypasient;

        // opprette og legge til nytt legemiddel objekt
        // public Legemiddel(String navn, int pris, double virkestoff)

        System.out.println("Legg til legemiddelnavn");
        String legemiddelnavn = sc.nextLine();

        System.out.println("Legg til legemiddeltype(narkotisk, vanedannende, vanlig)");
        String legemiddeltype = sc.nextLine();

        System.out.println("Legg til legemiddelpris ");
        int legemiddelpris = sc.nextInt();

        System.out.println("Legg til legemiddelvirkestoff i desimaltall");
        double legemiddelvirkestoff = sc.nextDouble();

        System.out.println("Legg til legemiddelstyrke");
        int legemiddelstyrke = sc.nextInt();

        if (legemiddeltype.equals("narkotisk")) {
            Legemiddel nyLegemiddel = new Narkotisk(legemiddelnavn, legemiddelpris, legemiddelvirkestoff,
                    legemiddelstyrke);
            legemiddelListe.leggTil(nyLegemiddel);
            legemiddel = nyLegemiddel;
        }

        else if (legemiddeltype.equals("vanedannende")) {
            Legemiddel nyLegemiddel = new Vanedannende(legemiddelnavn, legemiddelpris, legemiddelvirkestoff,
                    legemiddelstyrke);
            legemiddelListe.leggTil(nyLegemiddel);
            legemiddel = nyLegemiddel;
        } 
        else {
        
            Legemiddel nyLegemiddel = new Vanlig(legemiddelnavn, legemiddelpris, legemiddelvirkestoff);
            legemiddelListe.leggTil(nyLegemiddel);
            legemiddel = nyLegemiddel;
        }

        System.out.println("skriv antall reit");
        int nyreit = sc.nextInt();

        System.out.println("Hva slags resept vil du ha( hvit, blaa, mil eller p resepter");
        String reseptype = sc.next();

        try {
            if (reseptype.equals("hvit")) {
                resept = lege.skrivHvitResept(legemiddel, pasient, nyreit);
                reseptListe.leggTil(resept);
            }

            if (reseptype.equals("blaa")) {
                resept = lege.skrivBlaaResept(legemiddel, pasient, nyreit);
                reseptListe.leggTil(resept);
            }

            if (reseptype.equals("mil")) {
                resept = lege.skrivMilResept(legemiddel, pasient);
                reseptListe.leggTil(resept);
            }

            if (reseptype.equals("p")) {
                resept = lege.skrivPResept(legemiddel, pasient, nyreit);
                reseptListe.leggTil(resept);
            }

        } catch (UlovligUtskrift exception) {
            System.out.println("[ERROR] + UlovligUtskrift!! ");
        }

    }

    // E5
    public void interaksjon() {
        Scanner sc = new Scanner(System.in);
        // pasient
        System.out.println("Hvilken pasient vil se du resepter for?");
        System.out.println("-------------------------------------");

        int teller = 0;
        for (Pasient p : pasientListe) {
            System.out.println(teller + ": " + p.hentNavn() + "(fnr " + p.hentfNr() + ")");
            teller++;
            System.out.println("");
        }
        int valg = sc.nextInt();
        Pasient valgPasient = pasientListe.hent(valg);
        System.out.println("Valgt pasient: " + valgPasient + "\n");
        System.out.println("------------------------------------");

        // resept
        System.out.println("Hvilken resept vil du bruke?");
        System.out.println("");
        IndeksertListe<Resept> reseplisteForPasient = valgPasient.hentReseptliste();
        System.out.println(reseplisteForPasient);

        int number = 0;
        for (Resept r : reseplisteForPasient) {
            System.out.println(number + ": " + r.hentLegemiddel().hentNavn() + "(" + r.hentReit() + "reit)");
            number++;
            System.out.println("--------------------------------");
        }

        int choice = sc.nextInt();
        Resept valgtResept = reseplisteForPasient.hent(choice);
        System.out.println(valgtResept);

        String legemiddelNavn = valgtResept.hentLegemiddel().hentNavn();
        if (valgtResept.hentReit() > 0) {
            valgtResept.bruk();

            System.out.println(" Brukte resept paa : " + legemiddelNavn
                    + ". Antall gjenvaerened reit: " + valgtResept.hentReit());
            System.out.println(" ");

        } else {
            System.out.println("Kunne ikke bruke resept paa : " + legemiddelNavn + ". (ingen gjenvaerende reit).");
            System.out.println("");
        }

    }

    // E6
    public void subMenyValg() {

        int userInputE6;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("----------------------------------------");
            System.out.println("for aa sjekke alle resepter av vanedannende middel skriv 1");
            System.out.println("for aa sjekke alle resepter av Narkotiske middel skriv 2");
            System.out.println("for aa sjekke alle leger som har skrevet ut resepter skriv 3");
            System.out.println("for aa sjekke alle Pasienter som har resept paa narkotisk middel skriv 4");
            System.out.println("tast 0 faar aa gaa tilbake til hovedmeny");
            System.out.println("----------------------------------------");

            userInputE6 = sc.nextInt();

            switch (userInputE6) {

                case 0:
                    LegesystemMeny();
                    break;

                case 1:
                    // protected IndeksertListe<Resept> utskrevneResept = new IndeksertListe<>();
                    // --Lege
                    int antallVanedannende = 0;
                    for (Resept r : reseptListe) {

                        Legemiddel legemiddel = r.hentLegemiddel();
                        if (legemiddel instanceof Vanedannende) {

                            antallVanedannende++;
                            System.out.println(" ");
                            System.out.println("Total antall vanedannede legemiddel i resesplista er: " +
                                    antallVanedannende);
                        }
                    }
                    break;

                case 2:
                    int antallNarkotiske = 0;
                    for (Resept r : reseptListe) {

                        Legemiddel legemiddel = r.hentLegemiddel();
                        if (legemiddel instanceof Narkotisk) {

                            antallNarkotiske++;
                            System.out.println(" ");
                            System.out.println(
                                    "Det er totalt " + antallNarkotiske + " resepter av narkotiske legemiddel");
                        }

                    }
                    break;
                case 3:
                    // IndeksertListe<Resept> hentResept()
                    // protected IndeksertListe<Legemiddel> legemiddelListe;
                    for (Lege lege : legeListe) {
                        int narkotisk = 0;
                        IndeksertListe<Resept> resepter = lege.hentResept();
                        for (Resept r : resepter) {
                            Legemiddel legemiddel = r.hentLegemiddel();

                            if (legemiddel instanceof Narkotisk) {
                                narkotisk++;
                            }
                        }

                        if (narkotisk > 0) {
                            String narkoLeger = lege.hentNavn();
                            System.out.println(" ");
                            System.out.println("Lege navn som skrevet ut resept paa Narkotiske: " + narkoLeger);
                            System.out.println("Antall narkotiske legemidler: " + narkotisk);
                        }
                    }
                    break;

                case 4:
                    for (Pasient pasient : pasientListe) {
                        int narkotisk = 0;

                        IndeksertListe<Resept> resepLister = pasient.hentReseptliste();
                        for (Resept res : resepLister) {
                            Legemiddel legemidler = res.hentLegemiddel();
                            if (legemidler instanceof Narkotisk) {
                                narkotisk++;
                            }
                        }
                        if (narkotisk > 0) {
                            String pasientNarko = pasient.hentNavn();
                            System.out.println(" ");
                            System.out.println("Pasient som har en resept paa narkotiske: " + pasientNarko);
                            System.out.println("Antall narkotiske legemidler: " + narkotisk);
                        }
                    }
                    break;

                default:
                    System.out.println(" ");
                    System.out.println("komando" + userInputE6 + "er ikke gyldig skriv ny input");
                    break;
            }
        } while (userInputE6 != 0);
        sc.close();
    }

    public void lagFil() {

        PrintWriter nyFil = null;

        try {
            nyFil = new PrintWriter("Nylegedata.txt");
        } catch (Exception e) {
            System.out.println("kan ikke lage filen!!");
            System.exit(1);
        }

        nyFil.println("# Pasienter (navn, fnr)");
        for (Pasient pas : pasientListe) {
            nyFil.println(pas.hentNavn() + "," + pas.hentfNr());
        }

        nyFil.println("# Legemidler (navn,type,pris,virkestoff,[styrke])");
        for (Legemiddel lm : legemiddelListe) {
            nyFil.println(lm.hentNavn() + "," + lm.typeLegemiddel() + "," + lm.hentPris() +
                    "," + lm.hentVirkestoff() + "," + lm.hentStyrke());
        }

        nyFil.println("# Leger (navn,kontrollid / 0 hvis vanlig lege)");
        for (Lege l : legeListe) {
            nyFil.print(l.hentNavn() + ", ");
            if (l instanceof Spesialist) {
                Spesialist ls = (Spesialist) l;
                nyFil.println(ls.hentKontrollID());
            } else {
                nyFil.println("0");
            }
        }

        nyFil.println("# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])");
        for (Resept res : reseptListe) {
            nyFil.println(res.hentLegemiddel().hentId() + "," + res.hentLege().hentNavn() + "," +
                    res.hentPasient().hentId() + "," + res.farge() + "," + res.hentReit());
        }

        nyFil.println();
        nyFil.close();
        System.out.println("ny fil ble opprettet");
        System.out.println(" ");
    }

}
