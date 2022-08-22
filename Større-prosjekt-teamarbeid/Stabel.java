public class Stabel<T> extends Lenkeliste<T> {
    
    
@Override
public void leggTil(T verdi){
    //case1 : Hvis det er tom i liste, legge til nye elementer med en gang
    Node nyNode = new Node(verdi);
    stoerrelse ++;
    if (start == null){
        start = nyNode;
        return;
    }
    //case2: Hvis det er mange noder allerede
    Node tmp = start;
    start = nyNode;
    start.neste = tmp;
    }    
}
