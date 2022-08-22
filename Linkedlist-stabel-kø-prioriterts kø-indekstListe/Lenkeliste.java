public abstract class Lenkeliste<T> implements Liste<T>{
    
    protected Node start ;
    protected Node slutt ;
    protected int stoerrelse = 0 ;

    // opprette indre hjelpe klassen Node
    protected class Node{
        Node neste ;
        Node forrige ;
        T data;

        public Node(T d){
            data = d;
        }

        public void settNeste(Node n){
            neste = n;
        }

        public void settForrige(Node f){
            forrige = f;
        }


    }
    //sjekker om Lenkelisten inneholder noe node
    public boolean erTom(){
        return stoerrelse == 0;
    }

    @Override
    public int stoerrelse(){
        return stoerrelse;
    }

    // settInn metode-> nye noder settes på slutten av lenkelista.
    @Override
    public void leggTil(T x){

        Node nyNode = new Node(x);
        stoerrelse ++;
        //sjekke om start er null, betyr at finnes ikke noe node i Lenkeliste
        if(slutt == null){
            start = nyNode;
            slutt = nyNode;
            return;
            
        }
        //hvis start ikke er null, så setter nyNoden i slutten av Lenkelisten
        slutt.neste = nyNode;
        // før vi flytter sluttpekeren til nyNode, må nyNode sin forrige kobles til noden som slutt peker.
        nyNode.forrige = slutt;
        slutt = nyNode;      
    }

    @Override
    public T hent(){
        //current peker på samme node som start
        Node current = start;
        //hvis current peker på null, betyr at det ikke finnes noe node
        if (current == null) return null;

        //hvis curren ikke peker på null, så henter vi ut verdien denne noden(første noden) som curren peker på.
        T elem = current.data;
        return elem;
    }


    // fjern metode -> det som ble satt inn først, må tas ut først. FIFO.
    @Override
    public T fjern() throws UgyldigListeindeks{

        // sjekke om LenkeListen er tom, så peker på UgyldigListeindeks klassen som inneholder Exception.
        if(erTom()){
            throw new UgyldigListeindeks(0);
            
        }
        Node tmp = start;
        T data = tmp.data;
        //hvis første og siste peker på samme node, så fjerner pekeren ved å sette dem til null.
        if(start == slutt){
            slutt = null;
            start = null;
            
        }
        //hvis føsrte og siste peker på forskjellige noder, fjerne pekeren fra første noden og sette det på null
        else{
            start.neste.forrige = null;
            start = start.neste;
            
        }   
        stoerrelse--;
        return data;

    }

    @Override
    public String toString(){
        String svarstreng = " ";
        int nodeNr = 0;
        Node tmp = start;
        while(tmp != null){
            svarstreng += "(Data i Node nummer:"+ nodeNr + " er " + tmp.data + ") -->";
            tmp = tmp.neste;
            nodeNr ++;
        }
        return svarstreng;
    }
}