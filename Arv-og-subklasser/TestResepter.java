
public class TestResepter {

    public static void main(String[] args){

        Legemiddel vanlig = new Vanlig("Ibox", 45, 250);
        Legemiddel vane = new Vanedannende("Fenobarbital", 564, 50, 10);
        if(vane instanceof Vanedannende){
            Vanedannende castedVane = (Vanedannende) vane;
        }

        Legemiddel narko = new Narkotisk("Metadon", 207, 35, 1);
        if (narko instanceof Narkotisk){
            Narkotisk castedNarko = (Narkotisk) narko;
        }

        Lege lege = new Lege("Svein Erling Hamnes Aaberge");

        Resept milres = new MilResept(vane, lege, 65);
        Resept pres = new PResept(narko, lege, 32, 10);
        Resept bres = new Blaaresepter(vanlig, lege, 90, 3);
            
        
        MilResept mResept = new MilResept(vanlig, lege, 25);
        PResept pResept = new PResept(vanlig, lege, 57, 2);
        Blaaresepter bResept = new Blaaresepter(vanlig, lege, 14, 0);


        System.out.println(mResept + "\n");
      
        System.out.println(pResept + "\n");

        System.out.println(bResept + "\n");
        

        System.out.println("----Test av farge----");
        testAvfarge(mResept, "Hvit");
        testAvfarge(pResept, "Hvit");
        testAvfarge(bResept, "blaa");


        System.out.println("\n----Test av prisAaBetale----");
        testenAvPris(mResept, 0);
        testenAvPris(pResept, 100);
        testenAvPris(bResept, 11);

        mResept.bruk();
        pResept.bruk();
        bResept.bruk();
    
        System.out.println("\n----Test av bruk(reit)----");
        testenAvBruk(mResept, true);
        testenAvBruk(pResept, true);
        testenAvBruk(bResept, false);
       
    }

    public static boolean testAvfarge(Resept res, String forventetresultat){
        if(res.farge().equals(forventetresultat)){
            System.out.println("Testen av farge fungerete bra! ");
        }
        else{
            System.out.println("Testen er ikke riktig! riktig resultal er: " + forventetresultat);
        }
        return res.farge().equals(forventetresultat);
    }
    public static boolean testenAvPris(Resept res, int forventetResultat){
        if(res.prisAaBetale() == forventetResultat){
            System.out.println("Testen av pris for " + res.farge() +" resept fungerer bra!");
        }
        else{
            System.out.println("Testen av pris for " + res.farge() + " resept fungere ikke! forventetresultat er :" + forventetResultat);
        }
        return (res.prisAaBetale() == forventetResultat);
    }

    public static boolean testenAvBruk(Resept res, boolean forventetResultat){
        if (res.bruk() == forventetResultat){
            System.out.println("Testen av bruk(reit) fungere bra!");
        }
        else{System.out.println("Testen av bruk(reit) fungerer ikke! riktig resultat er:" + forventetResultat);
        }
        return(res.bruk() == forventetResultat);
    }
    
}
