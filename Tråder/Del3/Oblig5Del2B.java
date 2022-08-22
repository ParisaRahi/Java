import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Oblig5Del2B {
    
    
    public static void main(String[] args) throws FileNotFoundException {

        //Testdatalitenlike

        final int ANTALL_TRAADER = 8;
        final int ANTALL_FILER = 3;

        SubsekvensRegister subReg = new SubsekvensRegister();
        Monitor2 monitor2 = new Monitor2(subReg, ANTALL_FILER);
        
        
        CountDownLatch lesLatch = new CountDownLatch(ANTALL_FILER);
        CountDownLatch flettLatch = new CountDownLatch(ANTALL_TRAADER);
        
        Scanner testdatalitenlike = new Scanner(new File("C:\\Users\\paris\\Desktop\\UIO\\IN1010\\Oblig\\Oblig5\\Oblig5Del2B\\testdatalitenlike\\metadata.csv"));    
        
        while(testdatalitenlike.hasNextLine()){      
            Thread traad = new Thread(new LeseTrad(monitor2, "testdatalitenlike" +"/" + testdatalitenlike.nextLine(), lesLatch));
            traad.start();// lage hashmaper og sette den inn hashbeholder gjøres av run metoden ved traad.start()     
        }

        testdatalitenlike.close();

        try{
            lesLatch.await();
        }
        catch(InterruptedException e){
            System.out.println("Interrupted!");
            System.exit(-1);
        }
        
        for(int i =0 ; i < ANTALL_TRAADER ; i++){
            Thread traad = new Thread(new FletteTrad(monitor2, flettLatch));
            traad.start();
        }
    
        try{
            lesLatch.await();
            flettLatch.await();
        }
        catch(InterruptedException e){
            System.out.println("AVBRUTT....");
            System.exit(-1);
        }

        int maksAntallTestdatalitenlike = 1;
        String stringTestdatalitenlike = "";    

        for(HashMap<String, Subsekvens>  hm : monitor2.hentsubReg().hentHashBeholder()){ 
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
        final int ANTALL_TRAADER2 = 8;
        final int ANTALL_FILER2 = 9;

        SubsekvensRegister subReg2 = new SubsekvensRegister();
        Monitor2 monitor3 = new Monitor2(subReg2, ANTALL_FILER2);
        
        
        CountDownLatch lesLatch2 = new CountDownLatch(ANTALL_FILER2);
        CountDownLatch flettLatch2 = new CountDownLatch(ANTALL_TRAADER2);
        
        Scanner testdatalike = new Scanner(new File("C:\\Users\\paris\\Desktop\\UIO\\IN1010\\Oblig\\Oblig5\\Oblig5Del2B\\testdatalike\\metadata.csv"));    
        
        while(testdatalike.hasNextLine()){      
            Thread traad = new Thread(new LeseTrad(monitor3, "testdatalike" +"/" + testdatalike.nextLine(), lesLatch2));
            traad.start();// lage hashmaper og sette den inn hashbeholder gjøres av run metoden ved traad.start()     
        }

        testdatalike.close();

        try{
            lesLatch2.await();
        }
        catch(InterruptedException e){
            System.out.println("Interrupted!");
            System.exit(-1);
        }
        
        for(int i =0 ; i < ANTALL_TRAADER2 ; i++){
            Thread traad = new Thread(new FletteTrad(monitor3, flettLatch2));
            traad.start();
        }
    
        try{
            lesLatch2.await();
            flettLatch2.await();
        }
        catch(InterruptedException e){
            System.out.println("AVBRUTT....");
            System.exit(-1);
        }

        int maksAntallTestdatalike = 1;
        String stringTestdatalike = "";    

        for(HashMap<String, Subsekvens>  hm : monitor3.hentsubReg().hentHashBeholder()){ 
            for(String s: hm.keySet()){
                Subsekvens verdi = hm.get(s);
                int antaFor = verdi.hentAntallForekomster();
                if(antaFor > maksAntallTestdatalike){
                    maksAntallTestdatalike = antaFor;
                    stringTestdatalike = s;
                }
            }System.out.println("(" + stringTestdatalike + " , " + maksAntallTestdatalike + ")");
        }
    }  
}
