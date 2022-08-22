
import java.util.ArrayList;

public class Hovedprogram {

    public static void main(String[] args){

        ArrayList<Object> klasseListe = new ArrayList<>();
    
        Legemiddel narko = new Narkotisk("Morfin", 305, 5.0, 5);
        Legemiddel vane = new Vanedannende("Klonazepam", 132, 0.10, 7);
        Legemiddel vanlig = new Vanlig("Paracet", 47, 250.0);

        Lege leg = new Spesialist("Svein", "224896");

        Resept mResept = new MilResept(vanlig, leg, 25);
        Resept pResept = new PResept(vanlig, leg, 57, 2);
        Resept bResept = new Blaaresepter(vanlig, leg, 14, 0);

        klasseListe.add(narko);
        klasseListe.add(vane);
        klasseListe.add(vanlig);
        klasseListe.add(leg);
        klasseListe.add(mResept);
        klasseListe.add(pResept);
        klasseListe.add(bResept);

        for(Object klass: klasseListe){
            System.out.println(klass +"\n");
        }




    }
    
}
