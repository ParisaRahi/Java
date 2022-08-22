
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Oblig5Del1 {

    public static void main(String[] args) throws FileNotFoundException {

        //Test testdatalike
        SubsekvensRegister subreg = new SubsekvensRegister();
        Scanner testdatalike = new Scanner(new File("C:\\Users\\paris\\Desktop\\UIO\\IN1010\\Oblig\\Oblig5\\testdatalike\\metadata.csv"));

        while(testdatalike.hasNextLine()){
            HashMap<String, Subsekvens> hashmap = subreg.lesFraFil("testdatalike"+ "/" + testdatalike.nextLine());
            subreg.settInn(hashmap);
            
        }
        testdatalike.close();

        while(subreg.stoerrelse() > 1){
            HashMap<String, Subsekvens> hashMap1 = subreg.TaUt();
            HashMap<String, Subsekvens> hashMap2 = subreg.TaUt();
            HashMap<String, Subsekvens> flettetHashMap = subreg.slaaSammen(hashMap1, hashMap2);
            subreg.settInn(flettetHashMap);
        }

        int maksAntallTestdatalike = 1;
        String stringTestdatalike = "";
        
        for(HashMap<String, Subsekvens> h: subreg.hentHashBeholder()){
           
            for(String s: h.keySet()){
                Subsekvens verdi = h.get(s);
                int antaFor = verdi.hentAntallForekomster();
                if(antaFor > maksAntallTestdatalike){
                    maksAntallTestdatalike = antaFor;
                    stringTestdatalike = s;
                }

            }
        }

        System.out.println("(" + stringTestdatalike + "," + maksAntallTestdatalike + ")");

        //Teste testdatalitenlike
        SubsekvensRegister subreg2 = new SubsekvensRegister();

        Scanner testdatalitenlike = new Scanner(new File("C:\\Users\\paris\\Desktop\\UIO\\IN1010\\Oblig\\Oblig5\\testdatalitenlike\\metadata.csv"));

        while(testdatalitenlike.hasNextLine()){
            HashMap<String, Subsekvens> hashmap = subreg2.lesFraFil("testdatalitenlike"+ "/" + testdatalitenlike.nextLine());
            subreg2.settInn(hashmap);
            
              
        }
        testdatalitenlike.close();

        while(subreg2.stoerrelse() > 1){
            HashMap<String, Subsekvens> hashMap1 = subreg2.TaUt();
            HashMap<String, Subsekvens> hashMap2 = subreg2.TaUt();
            HashMap<String, Subsekvens> flettetHashMap = subreg2.slaaSammen(hashMap1, hashMap2);
            subreg2.settInn(flettetHashMap);
        }

        int maksAntallTestdatalitenlike = 1;
        String stringTestdatalitenlike = "";
        
        for(HashMap<String, Subsekvens> h: subreg2.hentHashBeholder()){
           
            for(String s: h.keySet()){
                Subsekvens verdi = h.get(s);
                int antaFor = verdi.hentAntallForekomster();
                if(antaFor > maksAntallTestdatalitenlike){
                    maksAntallTestdatalitenlike = antaFor;
                    stringTestdatalitenlike = s;
                }

            }
        }
        System.out.println("(" + stringTestdatalitenlike + "," + maksAntallTestdatalitenlike + ")");
        
    }    
        
}
