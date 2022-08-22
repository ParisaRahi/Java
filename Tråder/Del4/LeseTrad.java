import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class LeseTrad implements Runnable {
    
    private Monitor2 monitor2;
    private String filnavn;
    private CountDownLatch latch;

    public LeseTrad(Monitor2 m, String fil, CountDownLatch lat){
        monitor2= m;
        filnavn = fil;
        latch = lat;
    }

    @Override
    public void run(){
        HashMap<String, Subsekvens> nyHashMap = Monitor2.lesFraFil(filnavn);
        monitor2.settInn(nyHashMap);
       
        latch.countDown();
    }
}
