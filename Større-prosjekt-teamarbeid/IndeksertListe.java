public class IndeksertListe<T> extends Lenkeliste<T>{

    @Override
    public int stoerrelse(){    
        return stoerrelse;  
    }
    
    public void leggTil(int pos,T verdi){
	    System.out.println(this);
        Node nyNode = new Node(verdi);
        Node tmp = start;
        int currentPos = 0;
        //leggTil i pos ==0
        if (pos==0) {
            Node oldStart = start;
            start = nyNode;
            nyNode.neste = oldStart;
            stoerrelse ++;
            return;
        }
        while (tmp !=null && currentPos != pos-1){//for å sette in verdi på den riktig pos, må stoppes pos-1
            tmp = tmp.neste;
            currentPos ++;

        }
        if (tmp !=null && currentPos == pos -1){
            Node nesteNode = tmp.neste;
            tmp.neste = nyNode;
            nyNode.neste = nesteNode;
            stoerrelse ++;
        }
        else{
            throw new UgyldigListeindeks (pos);
        }
    }

    public void sett(int pos, T x){//erstatte element i posisjon pos med x
        int currentPos = 0;
        Node tmp = start;
        //case 1: hvis pos ==0
        if (pos ==0){
            tmp.verdi = x;
            return;
        }
        while ( tmp!=null && currentPos !=pos){
            tmp =tmp.neste;
            currentPos ++;
        }
        if( tmp!=null&& currentPos == pos){
            tmp.verdi = x;
        }
        else{
            throw new UgyldigListeindeks (pos);
        }
    }

    public T hent (int pos){
        
        int currentPos = 0;
        Node tmp = start;
        //case 1: hvis pos er 0
        if (pos == 0){
            return tmp.verdi;
        }
        //case 2: pos er ikke null og der er allerede noder
        while ( tmp!=null && currentPos !=pos){
            tmp = tmp.neste;
            currentPos ++;
        }
        if(tmp!=null&& currentPos == pos) {
            return tmp.verdi;
        }
        else{
            throw new UgyldigListeindeks (pos);
        }  
      }

    public T fjern(int pos){
        Node tmp = start;
        int currentPos = 0;
        if (pos == 0){
            T verdi = tmp.verdi;
            Node nesteNode = tmp.neste;
            start = nesteNode;
            stoerrelse --;
            return verdi;
        }
        while(tmp !=null && currentPos != pos-1){
            tmp = tmp.neste;
            currentPos ++;
        }
        if(tmp!=null && tmp.neste !=null && currentPos == pos-1 ){
            T verdi = tmp.neste.verdi;
            Node nesteNode = tmp.neste;
            tmp.neste = null;
            tmp.neste = nesteNode.neste;
            stoerrelse --;
            return verdi;
        }
        else{
            throw new UgyldigListeindeks (pos);
        }       
    }
}
