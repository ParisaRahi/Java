public class Subsekvens{

    public final String SUBSEKVENS ;
    private int antallForekomster ; 

    public Subsekvens(String sub, int ant){
        SUBSEKVENS = sub;
        antallForekomster = ant;
    }

    public void leggTillAntallForekomster(int tall){
        antallForekomster += tall;
    }

    public int hentAntallForekomster(){
        return antallForekomster;
    }

    @Override
    public String toString(){
        String str = "(" + SUBSEKVENS + "," + antallForekomster +")";
        return str;    
    }


}