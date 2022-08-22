import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class FletteTrad implements Runnable{

    private Monitor2 monitor2 ;
    private CountDownLatch latch;
    
    public FletteTrad(Monitor2 m2, CountDownLatch lat){
        monitor2 = m2;
        latch = lat;
    }
    
    @Override
    public void run(){

        ArrayList<HashMap<String,Subsekvens>> tohashMap = monitor2.hentUtTo();

        while(tohashMap!= null){
            HashMap<String, Subsekvens> nyHashmap = monitor2.slaaSammen(tohashMap.get(0), tohashMap.get(1));
            monitor2.settInn(nyHashmap);
            tohashMap = monitor2.hentUtTo();     
        }
        latch.countDown();
        
    }
}
