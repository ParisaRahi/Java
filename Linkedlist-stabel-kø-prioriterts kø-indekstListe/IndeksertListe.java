public class IndeksertListe<T> extends Lenkeliste<T>{

    public void leggTil(int pos, T x) throws UgyldigListeindeks{

        if(pos < 0 || pos > stoerrelse()){
            throw new UgyldigListeindeks(pos);
        }
        Node nyNode = new Node(x);

        if (pos == 0 && stoerrelse() == 0){
            super.leggTil(x);
            return;
        }
        else if (pos == stoerrelse()){
            super.leggTil(x);
            return;
        }

        else if (pos == 0){
            Node tmp = start;
            tmp.forrige = nyNode;
            nyNode.neste = tmp;
            nyNode.forrige = null;
            start = nyNode;          
        }

        else if(pos!= 0){
            Node tmp = start;
            int teller = 0;
            while(tmp!= null && teller < pos ){
                tmp = tmp.neste;
                teller ++;
            }  
            tmp.forrige.neste = nyNode;  
            nyNode.forrige = tmp.forrige;
            nyNode.neste = tmp;
            tmp.forrige = nyNode; 
        }
        stoerrelse++;
        
    }

    public void sett(int pos, T x) throws UgyldigListeindeks{

        if (pos < 0 || pos >= stoerrelse){
            throw new UgyldigListeindeks(pos);
        }
        Node tmp = start;
        int teller = 0;
        while(tmp!= null && teller < pos){
            tmp = tmp.neste;
            teller++;
        }
        tmp.data = x;
        
    }

    public T hent(int pos) throws UgyldigListeindeks{
        if (pos < 0 || pos >= stoerrelse()){
            throw new UgyldigListeindeks(pos);
        }
        Node tmp = start;
        int teller = 0;
        while (teller < pos){
            tmp = tmp.neste;
            teller ++;
        }
        return tmp.data;
    }
    // vi må sjekke tre tilstander: pos == 0, pos == størrelse, pos i midten
    public T fjern(int pos)throws UgyldigListeindeks{

        if(pos < 0 || pos >= stoerrelse()){
            throw new UgyldigListeindeks(pos);
        }

        Node tmp = start;
        if(pos == 0 ){
            return super.fjern();       
        }

        else{
            int teller = 0;
            while(tmp!= null && teller < pos){
                tmp = tmp.neste;
                teller ++;
            }
            T tmpData = tmp.data;
            if (tmp.neste != null) {
                tmp.neste.forrige = tmp.forrige;
            }
            else {
                slutt = tmp.forrige;
            }
            
            tmp.forrige.neste = tmp.neste;
            stoerrelse --;
            return tmpData;
        }    
    }
}