public abstract class Resept {

    protected int reseptID;
    protected Legemiddel legemiddel;
    protected Lege utskrivedeLege;
    protected int pasientID;
    protected int reit; // hvis reit blir 0, da resepten er ugyldig

    public Resept( Legemiddel legemid, Lege utSkrLege, int pID, int reit ){
        
        legemiddel = legemid;
        utskrivedeLege = utSkrLege;
        pasientID = pID;
        this.reit = reit;
        reseptID ++;
    }

    public int hentID(){
        return reseptID;
    }

    public Legemiddel hentLegemiddel(){
        return legemiddel;
    }

    public Lege hentLege(){
        return utskrivedeLege;
    }

    public int hentPasientID(){
        return pasientID;
    }

    public int hentReit(){
        return reit;
    }

    public boolean bruk(){
        reit --;
        if (hentReit() == 0){
            return false;
        }
        return true;
    }

    public abstract String farge();

    public abstract int prisAaBetale();




    
}
