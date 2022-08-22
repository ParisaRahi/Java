import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class LeseTrad implements Runnable {
    
    private Monitor1 monitorBeholder;
    private String filnavn;
    private CountDownLatch latch;

    public LeseTrad(Monitor1 m, String fil, CountDownLatch lat){
        monitorBeholder = m;
        filnavn = fil;
        latch = lat;
    }

    @Override
    public void run(){
        HashMap<String, Subsekvens> nyHashMap =monitorBeholder.lesFraFil(filnavn);
        monitorBeholder.settInn(nyHashMap);
        latch.countDown();
    }
}
