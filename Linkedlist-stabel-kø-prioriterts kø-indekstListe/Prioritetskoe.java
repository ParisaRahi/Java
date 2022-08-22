public class Prioritetskoe<T extends Comparable <T>> extends Lenkeliste<T>{

    //skal sette inn elementer i sortert rekkefølge fra minst til størst.
    @Override
    public void leggTil(T x){
        
        //hvis lenkeListen har ingen Node eller ooverdien t
        if (erTom() || x.compareTo(slutt.data) > 0){
            super.leggTil(x);
            return;
        }

        //hvis oppgitte verdein er mindre enn start sin verdi.
        Node nyNode = new Node(x);
        stoerrelse++;
        if(x.compareTo(start.data) < 0){
            nyNode.neste = start;
            start.forrige = nyNode;
            start = nyNode;
            return;
        }

        Node tmp = start;
        while(tmp.data.compareTo(x) < 0){
            tmp = tmp.neste;
        }
        tmp.forrige.neste = nyNode;
        nyNode.forrige = tmp.forrige;
        nyNode.neste = tmp;
    }

    @Override 
    public T hent(){
        T data = super.hent();
        return data;
    }
    
    @Override
    public T fjern(){
        T data = super.fjern();
        return data;
    }    
}
