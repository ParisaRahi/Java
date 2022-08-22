public class Prioritetskoe <T extends Comparable<T>> extends Lenkeliste<T> {
    
    @Override
    public int stoerrelse(){    
        return stoerrelse;  
    }
    
    public void leggTil(T verdi){

        //case1: Hvis listen er tom, så leggtil den verdi med en gang 
        if (start ==null){
            super.leggTil(verdi);      
            return;
        }

        Node nyNode = new Node(verdi);
        stoerrelse++;
        //case2: Hvis den nyNoden element er minste
        Node tmp = start;
        if(tmp !=null && tmp.verdi.compareTo(verdi) > 0){
        nyNode.neste = tmp;
        start = nyNode;   
        return;
        }
        //case3: Hvis den nyNoden element er mellomst
        while(tmp.neste != null && tmp.neste.verdi.compareTo(verdi) < 0 ) {
            tmp = tmp.neste;
        }
        Node nesteNode = tmp.neste;
        tmp.neste = nyNode;
        nyNode.neste = nesteNode;            
     
    }
}


   
 
  
