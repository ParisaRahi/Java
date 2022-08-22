public class BlaaResept extends Resept {

    public BlaaResept(Legemiddel legemiddel,Lege utskrivendeLege, Pasient pasient, int reit){
        super(legemiddel,utskrivendeLege,pasient,reit);
    }

    public String farge(){
        return "Blaa";
    }
    public int prisAaBetale(){
        double pris = legemiddel.hentPris()*0.25 ;
        int price = (int)Math.round(pris);
        return price;
    } 
    @Override
    public String toString(){   
        String string = "------------BlaaResept--------------";
        string += "\n legemiddel: "+ legemiddel;
        string +="\n UtskrivendeLege: "+utskrivendeLege;
        string +="\n pasient: "+ pasient;
        string +="\n reit: "+reit;

        return string; 
         
    }              

}