public class TestLegemiddel {
    public static void main(String[] args) {
        Narkotisk narkotisk = new Narkotisk("Oxynorm", 299, 5, 100);
        //String navn, int pris, double virkestoff,int styrke
        Vanedannende vanedannende = new Vanedannende("Sobril", 199, 15, 70);
        Vanlig vanlig = new Vanlig("Paracet", 79, 30);

        System.out.println("Tester Narkotisk:");
        testLegemiddelId(narkotisk, 1);
        testLegemiddelNavn(narkotisk, "Oxynorm");
        testLegemiddelPris(narkotisk, 299);
        testLegemiddelVirkestoff(narkotisk, 5);
        testLegemiddelNStyrke(narkotisk, 100);

        System.out.println("\nTester Vanedannende:");
        testLegemiddelId(vanedannende, 2);
        testLegemiddelNavn(vanedannende, "Sobril");
        testLegemiddelPris(vanedannende, 199);
        testLegemiddelVirkestoff(vanedannende, 15);
        testLegemiddelVStyrke(vanedannende,70);

        System.out.println("\nTester Vanlig:");
        testLegemiddelId(vanlig, 3);
        testLegemiddelNavn(vanlig, "Paracet");
        testLegemiddelPris(vanlig, 79);
        testLegemiddelVirkestoff(vanlig, 30);
        // hentId()
        // hentNavn()
        // hentPris()
        // hentVirkestoff()
        // hentNarkotiskStyrke()
    }
    public static void testLegemiddelId(Legemiddel legemiddel, int forventetLegemiddelID) {
        if (legemiddel.hentId() == forventetLegemiddelID) {
            System.out.println("ID er Riktig.");
        }else{
            System.out.println("ID er Feil!");
        }
    }
    public static void testLegemiddelNavn(Legemiddel legemiddel, String forventetLegemiddelNavn){
        if(legemiddel.hentNavn() == forventetLegemiddelNavn){
            System.out.println("Navn er riktig.");
        }else{
            System.out.println("navn er feil.");
        }
    }
    
    public static void testLegemiddelPris(Legemiddel legemiddel, int forventetLegemiddelPris){
        if(legemiddel.hentPris() == forventetLegemiddelPris){
            System.out.println("Pris fungerer bra.");
        }else{
            System.out.println("Det er feil  med pris.");
        }
    }

    public static void testLegemiddelVirkestoff(Legemiddel legemiddel, int forventetLegemiddelVirkestoff){
        if(legemiddel.hentVirkestoff() == forventetLegemiddelVirkestoff){
            System.out.println("Virkestoff fungerer bra.");
        }else{
            System.out.println("Det er feil  med virkestoff.");
        }
    }
    
    public static void testLegemiddelNStyrke(Narkotisk hentStyrke, int forventetLegemiddelStyrke){
        if(hentStyrke.hentStyrke() == forventetLegemiddelStyrke){
            System.out.println("Narkotisk-styrke har rett.");
        }else{
            System.out.println("Narkotisk-styrke tar feil.");
        }
    }

    public static void testLegemiddelVStyrke(Vanedannende hentStyrke, int forventetLegemiddelStyrke){//hentVanedannendeStyrke()
        if(hentStyrke.hentStyrke() == forventetLegemiddelStyrke){
            System.out.println("Vanedannede-styrke er riktig .");
        }else{
            System.out.println("Vanedannede-styrke er feil.");
        }
    } 
}

