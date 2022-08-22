public class HviteResept extends Resept {

    public HviteResept (Legemiddel legemiddel,Lege utskrivendeLege, Pasient pasient, int reit){
        super(legemiddel, utskrivendeLege, pasient, reit);   
    }
    public String farge(){
        return "Hvit";
    }
    public int prisAaBetale(){
        return legemiddel.hentPris();
    } 
    @Override
    public String toString(){
        String string = "------------HviteResept--------------";
        string += "\n legemiddel: "+ legemiddel;
        string +="\n UtskrivendeLege: "+utskrivendeLege;
        string +="\n pasient: "+ pasient;
        string +="\n reit: "+reit;

        return string;
    
         
    }    
}
