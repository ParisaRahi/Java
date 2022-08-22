public abstract class Resept {
    static int nesteId = 1;
    protected int id;
    protected Legemiddel legemiddel;
    protected Lege utskrivendeLege;
    protected Pasient pasient;
    protected int reit;

    public Resept(Legemiddel legemiddel,Lege utskrivendeLege, Pasient pasient, int reit){
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasient = pasient;
        this.reit = reit;
        this.id=nesteId;
        nesteId ++;
    }
    public int hentId(){
        return id;
    }
    public Legemiddel hentLegemiddel(){
        return legemiddel;
    }
    public Lege hentLege(){
        return utskrivendeLege;
    }
    public Pasient hentPasient(){
        return pasient;
    }
    public int hentReit(){
        return reit;
    }
    public boolean bruk(){
        if (reit > 0){
            reit --;
            return true;
        }   
       
        return true;
    }
    
   
    abstract public String farge();
    abstract public int prisAaBetale();
 
}
