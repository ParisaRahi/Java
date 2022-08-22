
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Oblig5Del2A {

    public static void main(String[] args) throws FileNotFoundException{

        //Testdatalitenlike
        SubsekvensRegister subRegObjekt = new SubsekvensRegister();
        Monitor1 monitor1Objekt = new Monitor1(subRegObjekt);
        
        CountDownLatch barriere = new CountDownLatch(3);
        
        Scanner testdatalitenlike = new Scanner(new File("C:\\Users\\paris\\Desktop\\UIO\\IN1010\\Oblig\\Oblig5\\testdatalitenlike\\metadata.csv"));    
        while (testdatalitenlike.hasNextLine()){      
            Thread traad = new Thread(new LeseTrad(monitor1Objekt, "testdatalitenlike" +"/" + testdatalitenlike.nextLine(), barriere));
            traad.start();// lage hashmaper og sette den inn hashbeholder gjøres av run metoden ved traad.start()     
        }
        testdatalitenlike.close();
        
        try{
            barriere.await();
        }
        catch(InterruptedException e){
            System.out.println("AVBRUTT....");
            System.exit(-1);
        }
        while(monitor1Objekt.stoerrelse() > 1){
            HashMap<String,Subsekvens> hashmap1 = monitor1Objekt.TaUt();
            HashMap<String, Subsekvens> hashMap2 = monitor1Objekt.TaUt();
            monitor1Objekt.settInn(monitor1Objekt.slaaSammen(hashmap1, hashMap2));
           
        }


        int maksAntallTestdatalitenlike = 1;
        String stringTestdatalitenlike = "";  
          
        for(HashMap<String, Subsekvens>  hm : monitor1Objekt.hentsubReg().hentHashBeholder()){ 
            for(String s: hm.keySet()){
                Subsekvens verdi = hm.get(s);
                int antaFor = verdi.hentAntallForekomster();
                if(antaFor > maksAntallTestdatalitenlike){
                    maksAntallTestdatalitenlike = antaFor;
                    stringTestdatalitenlike = s;
                }
            }System.out.println("(" + stringTestdatalitenlike + " , " + maksAntallTestdatalitenlike + ")");
        }
        
        
         
        //Testdatalike
        SubsekvensRegister subRegObjekt2 = new SubsekvensRegister();
        Monitor1 monitor1Objekt2 = new Monitor1(subRegObjekt2);
    
        CountDownLatch barriere2 = new CountDownLatch(9);

        Scanner testdatalike = new Scanner(new File("C:\\Users\\paris\\Desktop\\UIO\\IN1010\\Oblig\\Oblig5\\testdatalike\\metadata.csv"));

        while(testdatalike.hasNext()){
            Thread traad = new Thread(new LeseTrad(monitor1Objekt2, "testdatalike" + "/" + testdatalike.nextLine(), barriere2));
            traad.start();
        }
        testdatalike.close();
        
        while(monitor1Objekt2.stoerrelse() > 1){
            HashMap<String,Subsekvens> hm1 = monitor1Objekt2.TaUt();
            HashMap<String, Subsekvens> hm2 = monitor1Objekt2.TaUt();
            monitor1Objekt2.settInn(monitor1Objekt2.slaaSammen(hm1, hm2));
        }

        try{
            barriere2.await();
        }
        catch(InterruptedException e){
            System.out.println("AVBRUTT....");
            System.exit(-1);
        }

        int maksAntallTestdatalike = 1;
        String stringTestdatalike = "";

        for(HashMap<String, Subsekvens> hm : monitor1Objekt2.hentsubReg().hentHashBeholder()){
            for(String k : hm.keySet()){
                Subsekvens sub = hm.get(k);
                int verdi = sub.hentAntallForekomster();
                if(verdi > maksAntallTestdatalike){
                    maksAntallTestdatalike = verdi;
                    stringTestdatalike = k;
                }
            }
        }
        System.out.println("(" + stringTestdatalike + " , " + maksAntallTestdatalike +")");

    }  
}
