import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Monitor2 {

    private SubsekvensRegister subreg ;
    private static Lock laas = new ReentrantLock();
    private Condition ikkeTom = laas.newCondition();

    public Monitor2(SubsekvensRegister sr){
        subreg = sr;
       
    }

    public SubsekvensRegister hentsubReg(){
        return subreg;
    }

    public void settInn(HashMap<String, Subsekvens> hashMap){
        laas.lock();
        try{
            subreg.settInn(hashMap);
            ikkeTom.signalAll();
        }
        finally{
            laas.unlock();
        }
    }

    public ArrayList<HashMap<String, Subsekvens>>hentUtTo() {
        laas.lock();
        try{
            while(subreg.stoerrelse() < 2 ){
                if(subreg.stoerrelse() == 1) return null;
                ikkeTom.await();
            } 
            
            ArrayList<HashMap<String, Subsekvens>> retur = new ArrayList<>();
            retur.add(subreg.hentHashBeholder().remove(0));
            retur.add(subreg.hentHashBeholder().remove(0));
            return retur;
        }
        catch(InterruptedException e){
            System.out.println("Avbrutt!");
            return null;
        }
        finally{
            laas.unlock();
        }
    }

    public int stoerrelse() {
        laas.lock();
        try{
            return subreg.hentHashBeholder().size();
        }
        finally{
            laas.unlock();
        }
    }

    public static HashMap<String, Subsekvens> lesFraFil(String file){
        laas.lock();
        try{
            HashMap<String, Subsekvens> sekvenserTilEnPerson = new HashMap<>();
            Scanner sc = null;
            try{
                sc = new Scanner(new File(file));
            }
            catch(FileNotFoundException e){
                System.out.println("Har ikke funnet filen!");
                System.exit(-1);
            }
            while(sc.hasNextLine()){
                String data = sc.nextLine().trim();
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
        finally{
            laas.unlock();
        }
    }


    public static HashMap<String, Subsekvens> slaaSammen(HashMap<String, Subsekvens> hm1, HashMap<String, Subsekvens> hm2){
        laas.lock();
        try{
            HashMap<String, Subsekvens> sammenslaattHashmap = new HashMap<>();
            for(String sub : hm1.keySet()){
                if(hm2.containsKey(sub)){
                    Subsekvens sub2 = hm2.get(sub);
                    int verdi = sub2.hentAntallForekomster();
                    Subsekvens sub1 = hm1.get(sub);
                    sub1.leggTillAntallForekomster(verdi);
                    sammenslaattHashmap.put(sub, sub1);
                }
                else{
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
        finally{
            laas.unlock();
        }
    }

}
    

