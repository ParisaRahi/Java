

public class TestLegemiddel{
    public static void main(String[] args) {

        Narkotisk narko = new Narkotisk("Morfin", 305, 5.0, 5);
        Vanedannende vane = new Vanedannende("Klonazepam", 132, 0.10, 7);
        Vanlig vanlig = new Vanlig("Paracet", 47, 250.0);

        System.out.println(narko + "\n");
        
        System.out.println(vane + "\n");
        
        System.out.println(vanlig.toString() + "\n");
        
        System.out.println("\n------Test av ID-----");
        TestAvID(narko, 2);
        TestAvID(vane, 1);
        TestAvID(vanlig, 1);

        System.out.println("\n-----Test av Navn-----");
        TestAvNavn(narko, "morfin");
        TestAvNavn(vane, "Klonazepam");
        TestAvNavn(vanlig, "Paracet");

        narko.settNyPris(342);
        vane.settNyPris(145);
        vanlig.settNyPris(35);

        System.out.println("\n----Test av Pris----");
        TestAvPris(narko, 342);
        TestAvPris(vane, 132);
        TestAvPris(vanlig, 47);

        System.out.println("\n----Teste av Virkestoff----");
        TestAvVirkestoff(narko, 5.0);
        TestAvVirkestoff(vane, 0.11);
        TestAvVirkestoff(vanlig, 250.0);

        System.out.println("\n----Test av Narkotisk styrke----");
        TestAvNarkotisk(narko, 5);

        System.out.println("\n----Test av vanedannende styrke----");
        TestAvVanedannende(vane, 6);

    }

    public static boolean TestAvNavn(Legemiddel legemiddel, String forventetResultat){
        if(legemiddel.hentNavn().equals(forventetResultat)){
            System.out.println(legemiddel.typeLegemiddel() + ": Testen fungerte bra!");
        }
        else{
            System.out.println(legemiddel.typeLegemiddel() +": Testen fungerte ikke bra! riktig resultat er:" + forventetResultat);
        }    
        return legemiddel.hentNavn().equals(forventetResultat);
    }

    public static boolean TestAvID(Legemiddel legemiddel, int forventetResultat){
        if(legemiddel.hentId() == forventetResultat){
            System.out.println(legemiddel.typeLegemiddel() + ": Testen av ID fungerte bra!");
        }
        else{
            System.out.println(legemiddel.typeLegemiddel() + ": Testen av ID fungerte ikke bra! riktig resultat er: " + forventetResultat);
        }
        return legemiddel.hentId() == forventetResultat;
    }

    public static boolean TestAvPris(Legemiddel legemiddel, int forventetResultat){
        if(legemiddel.hentPris() == forventetResultat){
            System.out.println(legemiddel.typeLegemiddel() + ": Testen av pris fungerte bra");
        }
        else{
            System.out.println(legemiddel.typeLegemiddel() + ": Testen av pris fungerte ikke bra! riktig resutat er: " + forventetResultat);
        }    
        return legemiddel.hentPris() == forventetResultat;
    }

    public static boolean TestAvVirkestoff(Legemiddel legemiddel, double forventetResultat){
        if(legemiddel.hentVirkestoff() == forventetResultat){
            System.out.println(legemiddel.typeLegemiddel() + ": Testen av virkestoff fungerte bra");
        }
        else{
            System.out.println(legemiddel.typeLegemiddel() + ": Testen av virkestoff fungerte ikke bra! riktig resutat er: " + forventetResultat);
        }    
        return legemiddel.hentVirkestoff() == forventetResultat;

    }

    public static boolean TestAvNarkotisk(Narkotisk narko, int forventetResultat){
        if(narko.hentNarkotiskStyrke() == forventetResultat){
            System.out.println(narko.typeLegemiddel() + ": Testen av Narkotisk fungerte bra");
        }
        else{
            System.out.println(narko.typeLegemiddel() + ": Testen av Narkotisl fungerte ikke bra! riktig resutat er: " + forventetResultat);
        }    
        return narko.hentNarkotiskStyrke() == forventetResultat;

    }
    
    public static boolean TestAvVanedannende(Vanedannende vane, int forventetResultat){
        if(vane.hentVanedannendeStyrke() == forventetResultat){
            System.out.println(vane.typeLegemiddel() + ": Testen av vanedannende fungerte bra");
        }
        else{
            System.out.println(vane.typeLegemiddel() + ": Testen av vanedannedne fungerte ikke bra! riktig resutat er: " + forventetResultat + "\n");
        }    
        return vane.hentVanedannendeStyrke() == forventetResultat;

    }

}


//Kilder:
        //https://www.legemiddelhandboka.no/G2/Farmakokinetikk_og_doseringsprinsipper
        //https://www.google.com/search?q=narkotisk+legemiddel+eksempel&tbm=isch&ved=2ahUKEwiek6nOuYT2AhVr1uAKHerpCOsQ2-cCegQIABAA&oq=narkotisk+legemiddel+eksempel&gs_lcp=CgNpbWcQAzIHCCMQ7wMQJ1AAWABgqQRoAHAAeACAAVGIAVGSAQExmAEAqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=WwwNYt75Cuusgwfq06PYDg&bih=577&biw=1280&hl=no#imgrc=Pp7zDisIFKTzPM