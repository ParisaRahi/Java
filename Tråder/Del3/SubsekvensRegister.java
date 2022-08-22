
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class SubsekvensRegister {

    private ArrayList<HashMap<String, Subsekvens>> hashBeholder = new ArrayList<>(); 
    
    
    public ArrayList<HashMap<String, Subsekvens>> hentHashBeholder(){
        return hashBeholder;
    }

    
    public void settInn(HashMap<String, Subsekvens> hashMap){
        hashBeholder.add(hashMap);     
    }

    public HashMap<String, Subsekvens> TaUt() {
        HashMap<String, Subsekvens> fjernetHashmap = hashBeholder.get(0);
        hashBeholder.remove(0);
        return fjernetHashmap;
    }

    public int stoerrelse() {
        return hashBeholder.size();       
    }

    public static HashMap<String, Subsekvens> lesFraFil(String file){
        HashMap<String, Subsekvens> sekvenserTilEnPerson = new HashMap<>();

        Scanner sc = null;
        try{
            sc = new Scanner(new File(file));
        }
        catch(FileNotFoundException e){
            System.out.println("Har ikke funnet filen!");
            System.exit(-1);
        }

       //sc.nextLine();// lese første raden.
        
        while(sc.hasNextLine()){
            String data = sc.nextLine();

            if(data.length() <= 2) System.exit(-1);
            
            for(int i= 0; i < data.length()-2; i++){
                String substring = data.substring(i,i+3);
            
                if(!sekvenserTilEnPerson.containsKey(substring)){
                    sekvenserTilEnPerson.put(substring,new Subsekvens(substring, 1));
        
                }
            }
        }
        sc.close();
        return sekvenserTilEnPerson;
    }

    public static HashMap<String, Subsekvens> slaaSammen(HashMap<String, Subsekvens> hm1, HashMap<String, Subsekvens> hm2){

        HashMap<String, Subsekvens> sammenslaattHashmap = new HashMap<>();

        for(String sub : hm1.keySet()){
            if(hm2.containsKey(sub)){
 
                Subsekvens sub2 = hm2.get(sub);
                int verdi = sub2.hentAntallForekomster();

                Subsekvens sub1 = hm1.get(sub);
                sub1.leggTillAntallForekomster(verdi);

                sammenslaattHashmap.put(sub, sub1);
            }
            else {
                sammenslaattHashmap.put(sub, hm1.get(sub));
            }
        }

        for(String sub : hm2.keySet()){
            if(!sammenslaattHashmap.containsKey(sub)){
                sammenslaattHashmap.put(sub, hm2.get(sub));
            }
        }
        
        return sammenslaattHashmap;
        
    }


    @Override
    public String toString(){
        String str = "" ;
        for(HashMap<String, Subsekvens> hm: hashBeholder){
            str += hm.values();
            str += "\n";
        }
        return str;    
    }

}
