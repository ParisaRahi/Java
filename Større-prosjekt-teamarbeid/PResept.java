public class PResept extends HviteResept{
    protected int pris;

    public PResept (Legemiddel legemiddel,Lege utskrivendeLege, Pasient pasient, int reit){
        super(legemiddel, utskrivendeLege, pasient, reit);   
    }
    public int prisAaBetale(){
        
       if (pris >=108) {
           pris = pris -108;
        }
        return 0;  
    } 
    @Override
    public String toString(){   
        String string = "------------P-Resept--------------";
        string += "\n legemiddel: "+ legemiddel;
        string +="\n UtskrivendeLege: "+utskrivendeLege;
        string +="\n pasient: "+ pasient;
        string +="\n reit: "+reit;

        return string; 
         
    }            
}
