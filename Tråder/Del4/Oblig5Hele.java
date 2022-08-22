import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.HashMap;
public class Oblig5Hele {

    public static void main(String[] args) throws FileNotFoundException {

        //Testdataliten
        final int ANTALL_TRAADER = 8;
        final int ANTALL_FILER = 3;

        SubsekvensRegister subregIkkeSmittet = new SubsekvensRegister();
        SubsekvensRegister subregSmittet = new SubsekvensRegister();
        Monitor2 smittet = new Monitor2(subregSmittet);
        Monitor2 ikkeSmittet = new Monitor2(subregIkkeSmittet);

        CountDownLatch lesLatch = new CountDownLatch(ANTALL_FILER);
        CountDownLatch flettLatch = new CountDownLatch(ANTALL_TRAADER * 2);

        //String mappe = args[0];
        //Scanner testdataliten = new Scanner(new File(mappe + "/metadata.csv"));

        Scanner testdataliten = new Scanner(new File("C:\\Users\\paris\\Desktop\\UIO\\IN1010\\Oblig\\Oblig5\\Oblig5Hele\\testdataliten\\metadata.csv")); 
        

        
        while(testdataliten.hasNextLine()){
            String[] data = testdataliten.nextLine().split(","); 
            String filNavn = data[0];
            String verdi = data[1];
            if(verdi.equals("True")){
                Thread traad = new Thread(new LeseTrad(smittet, "testdataliten"+ "/" + filNavn, lesLatch));
                traad.start();
            }
            else {
                Thread traad = new Thread(new LeseTrad(ikkeSmittet, "testdataliten" +"/" + filNavn, lesLatch));
                traad.start();

            }
        }
        testdataliten.close();
       
        try{
            lesLatch.await();
        }
        catch(InterruptedException e){
            System.out.println("Interrupted!");
            System.exit(-1);
        }
       

        for(int i =0; i < ANTALL_TRAADER ; i++){
            Thread traad = new Thread(new FletteTrad(ikkeSmittet, flettLatch));
            traad.start();
           
        }

        for(int i = 0; i< ANTALL_TRAADER; i++){
            new Thread(new FletteTrad(smittet, flettLatch)).start();
        }

        try{
            flettLatch.await();
        }
        catch(InterruptedException e){
            System.out.println("AVBRUTT....");
            System.exit(-1);
        }

        for(HashMap<String, Subsekvens>  hmS : smittet.hentsubReg().hentHashBeholder()){ 
            for(String s: hmS.keySet()){
                Subsekvens smittetVerdi = hmS.get(s);

                Subsekvens ikkeSmittetVerdi = ikkeSmittet.hentsubReg().hentHashBeholder().get(0).get(s);

                int antallIkkeSmittet = 0;
                if(ikkeSmittetVerdi != null){
                    antallIkkeSmittet = ikkeSmittetVerdi.hentAntallForekomster();
                }

                int diff = smittetVerdi.hentAntallForekomster() - antallIkkeSmittet;
                if(diff > 1){
                    //System.out.println(diff);
                    System.out.println(smittetVerdi);
                }

            }
        }

        //Testdata
        /*final int ANTALL_TRAADER = 8;
        final int ANTALL_FILER = 3;

        SubsekvensRegister subregIkkeSmittet = new SubsekvensRegister();
        SubsekvensRegister subregSmittet = new SubsekvensRegister();
        Monitor2 smittet = new Monitor2(subregSmittet);
        Monitor2 ikkeSmittet = new Monitor2(subregIkkeSmittet);

        CountDownLatch lesLatch = new CountDownLatch(ANTALL_FILER);
        CountDownLatch flettLatch = new CountDownLatch(ANTALL_TRAADER * 2);

        //String mappe = args[0];
        //Scanner testdataliten = new Scanner(new File(mappe + "/metadata.csv"));

        Scanner testdataliten = new Scanner(new File("C:\\Users\\paris\\Desktop\\UIO\\IN1010\\Oblig\\Oblig5\\Oblig5Hele\\testdata\\metadata.csv")); 
        

        
        while(testdataliten.hasNextLine()){
            String[] data = testdataliten.nextLine().split(","); 
            String filNavn = data[0];
            String verdi = data[1];
            if(verdi.equals("True")){
                Thread traad = new Thread(new LeseTrad(smittet, "testdata"+ "/" + filNavn, lesLatch));
                traad.start();
            }
            else {
                Thread traad = new Thread(new LeseTrad(ikkeSmittet, "testdata" +"/" + filNavn, lesLatch));
                traad.start();

            }
        }
        testdataliten.close();
       
        try{
            lesLatch.await();
        }
        catch(InterruptedException e){
            System.out.println("Interrupted!");
            System.exit(-1);
        }
       

        for(int i =0; i < ANTALL_TRAADER ; i++){
            Thread traad = new Thread(new FletteTrad(ikkeSmittet, flettLatch));
            traad.start();
           
        }

        for(int i = 0; i< ANTALL_TRAADER; i++){
            new Thread(new FletteTrad(smittet, flettLatch)).start();
        }

        try{
            flettLatch.await();
        }
        catch(InterruptedException e){
            System.out.println("AVBRUTT....");
            System.exit(-1);
        }

        for(HashMap<String, Subsekvens>  hmS : smittet.hentsubReg().hentHashBeholder()){ 
            for(String s: hmS.keySet()){
                Subsekvens smittetVerdi = hmS.get(s);

                Subsekvens ikkeSmittetVerdi = ikkeSmittet.hentsubReg().hentHashBeholder().get(0).get(s);

                int antallIkkeSmittet = 0;
                if(ikkeSmittetVerdi != null){
                    antallIkkeSmittet = ikkeSmittetVerdi.hentAntallForekomster();
                }

                int diff = smittetVerdi.hentAntallForekomster() - antallIkkeSmittet;
                if(diff > 4){
                    //System.out.println(diff);
                    System.out.println(smittetVerdi);
                }

            }
        }*/

        //data
        /*final int ANTALL_TRAADER = 8;
        final int ANTALL_FILER = 120;

        SubsekvensRegister subregIkkeSmittet = new SubsekvensRegister();
        SubsekvensRegister subregSmittet = new SubsekvensRegister();
        Monitor2 smittet = new Monitor2(subregSmittet);
        Monitor2 ikkeSmittet = new Monitor2(subregIkkeSmittet);

        CountDownLatch lesLatch = new CountDownLatch(ANTALL_FILER);
        CountDownLatch flettLatch = new CountDownLatch(ANTALL_TRAADER * 2);

        //String mappe = args[0];
        //Scanner testdataliten = new Scanner(new File(mappe + "/metadata.csv"));

        Scanner testdataliten = new Scanner(new File("C:\\Users\\paris\\Desktop\\UIO\\IN1010\\Oblig\\Oblig5\\Oblig5Hele\\data\\metadata.csv")); 
        

        
        while(testdataliten.hasNextLine()){
            testdataliten.nextLine();
            String[] data = testdataliten.nextLine().split(","); 
            String filNavn = data[0];
            String verdi = data[1];
            if(verdi.equals("True")){
                Thread traad = new Thread(new LeseTrad(smittet, "data"+ "/" + filNavn, lesLatch));
                traad.start();
            }
            else {
                Thread traad = new Thread(new LeseTrad(ikkeSmittet, "data" +"/" + filNavn, lesLatch));
                traad.start();

            }
        }
        testdataliten.close();
       
        try{
            lesLatch.await();
        }
        catch(InterruptedException e){
            System.out.println("Interrupted!");
            System.exit(-1);
        }
       

        for(int i =0; i < ANTALL_TRAADER ; i++){
            Thread traad = new Thread(new FletteTrad(ikkeSmittet, flettLatch));
            traad.start();
           
        }

        for(int i = 0; i< ANTALL_TRAADER; i++){
            new Thread(new FletteTrad(smittet, flettLatch)).start();
        }

        try{
            flettLatch.await();
        }
        catch(InterruptedException e){
            System.out.println("AVBRUTT....");
            System.exit(-1);
        }

        for(HashMap<String, Subsekvens>  hmS : smittet.hentsubReg().hentHashBeholder()){ 
            for(String s: hmS.keySet()){
                Subsekvens smittetVerdi = hmS.get(s);

                Subsekvens ikkeSmittetVerdi = ikkeSmittet.hentsubReg().hentHashBeholder().get(0).get(s);

                int antallIkkeSmittet = 0;
                if(ikkeSmittetVerdi != null){
                    antallIkkeSmittet = ikkeSmittetVerdi.hentAntallForekomster();
                }

                int diff = smittetVerdi.hentAntallForekomster() - antallIkkeSmittet;
                if(diff > 7){
                    //System.out.println(diff);
                    System.out.println(smittetVerdi);
                }

            }
        }*/

    }
    
}
