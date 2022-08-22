
public class Hovedprogram {
    public static void main(String[] args) {

        Dataklynge saga = new Dataklynge();
    
        int tell = 0;
        while (tell < 450){
            saga.leggTilRack(new Node(4, 512));
            tell++;
        }

        int teller = 0;
        while (teller < 16){

            saga.leggTilRack(new Node(8, 1024));
            teller ++;
        }
        
        saga.lesFraFil("dataklynge2.txt");
        
        System.out.println();

        System.out.println("Noder med minst 128 GB: " + saga.noderMedNokMinne(128));
        System.out.println("Noder med minst 512 GB: " + saga.noderMedNokMinne(512));
        System.out.println("Noder med minst 1024 GB: " + saga.noderMedNokMinne(1024));

        System.out.println();

        System.out.println("Antall prosessorer: " + saga.antallProsessor());
        System.out.println("Antall rack: " + saga.antallRack());
        
        
    }
  }      
