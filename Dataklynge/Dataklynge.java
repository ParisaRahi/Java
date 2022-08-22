import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Dataklynge {
    private ArrayList <Rack> rackList = new ArrayList<>();
    private int antallNodePerRack = 0;

    public void leggTilRack(Node node){
        for (int i= 0; i < rackList.size(); i++){
            if(rackList.get(i).erLedig()){
                rackList.get(i).leggTilNode(node);
                return;     
            }
        }
        Rack nyRack = new Rack(12);
        nyRack.leggTilNode(node);
        rackList.add(nyRack);
    }

    public void lesFraFil(String filNavn){
        Scanner lesInn = null;
        try {
            lesInn = new Scanner(new File(filNavn));

        } catch (Exception exception) {
            System.out.println("Fant ikke filen!");
            System.exit(-1);
        }    

        while(lesInn.hasNextLine()){
            
            String[] biter = lesInn.nextLine().split(" ");
            int node =Integer.parseInt(biter[0]);
            int prosessor = Integer.parseInt(biter[1]);
            int minne = Integer.parseInt(biter[2]);

            int teller = 0;
            while (node > teller ){
                leggTilRack(new Node(prosessor, minne));
                teller ++;
            } 
            if(prosessor > 16 || minne > 4096){
                System.out.println("ikke gyldig data!");
                System.exit(-1);
            }
        }
        lesInn.close();
    }
    public int antallProsessor(){
        int antProsessorer = 0;
        for(Rack r: rackList){
            if(r!= null){
                antProsessorer += r.antallProsessor();
            }
        }
        return antProsessorer;
    }

    public int antallRack(){
        int antRack = 0;
        for (Rack r: rackList){
            antRack ++;
        }
        return antRack;
    }

    public int noderMedNokMinne(int paakrevdminne){
        int antNode = 0;
        for(Rack r : rackList){
            antNode += r.noderMedNokMinne(paakrevdminne);
        }
        return antNode;
    }
}
