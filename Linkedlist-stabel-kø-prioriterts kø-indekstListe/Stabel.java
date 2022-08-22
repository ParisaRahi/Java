public class Stabel<T> extends Lenkeliste<T> {

    //det som er lagt inn sist, tas ut først.

    @Override
    public void leggTil(T x){
        Node nyNode = new Node(x);
        
        if(start == null){
            slutt = nyNode;
            start = nyNode;
        }       
        else{
            start.forrige = nyNode;
            nyNode.neste = start;
            start = nyNode;
        }
        stoerrelse++;
    }   
}
