public abstract class Hviteresepter extends Resept {

    protected int reseptID;
  
    public Hviteresepter(Legemiddel legemid, Lege utSkrLege, int pID, int reit ){
        super(legemid, utSkrLege, pID, reit);
        reseptID++;
    }

    @Override
    public String farge(){
        return "Hvit";
    }

   
    
}
