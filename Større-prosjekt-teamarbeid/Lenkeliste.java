import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class Lenkeliste<T> implements Liste<T> {

    protected Node start;
    protected int stoerrelse = 0;   
   
    protected class Node{
        Node neste;
        T verdi;

        public Node(T verdi){
            this.verdi = verdi;
        } 
    }
    
    @Override
    public int stoerrelse(){    
        return stoerrelse;  
    }

    @Override
    //det skal legges sist i listen
    public void leggTil(T verdi){   
	    // System.out.println(this);

        //case1: Hvis listen er tom, så leggtil den verdi med en gang
        Node nyNode = new Node(verdi);
        stoerrelse++;
        if (start ==null){
            start= nyNode;
            return;
        }
        //case2: Hvis det er mange Noder allerede
        Node tmp = start;
        while (tmp.neste != null){
            tmp = tmp.neste;
        }
            tmp.neste = nyNode;   
    }
    @Override
    public T hent(){//skal return det første element i liste. 
        if(start == null) return null;
        return start.verdi;
    }
    @Override
    public T fjern(){//skal fjerne det første element og return verdi
        
        if(start ==null){
            throw new UgyldigListeindeks (-1);
        
        }  
        T verdi = start.verdi;
        start = start.neste;
        stoerrelse--;
        
        return verdi;   
      
    }
    @Override
    public String toString() {
        String string = " Størrelse: " + stoerrelse + " ";
        
        Node tmp = start;
        while(tmp != null){
            string +="verdi: " + tmp.verdi + " --> ";
            tmp = tmp.neste;
        }
        return string;
    }

    @Override
    public Iterator<T> iterator(){
        return new LenkelisteIterator();
    }
    
    private class LenkelisteIterator implements Iterator<T> {
        Node denne = start;

        @Override
        public boolean hasNext(){
            return denne !=null;
        }

        @Override
        public T next() {
            if(denne == null){
                throw new NoSuchElementException();
            }
            Node peker = denne;
            denne = denne.neste;

            return peker.verdi;

        }
    }

}

  







    

