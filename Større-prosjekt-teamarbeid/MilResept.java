public class MilResept extends HviteResept { 
    
    public MilResept (Legemiddel legemiddel,Lege utskrivendeLege, Pasient pasient){
        super(legemiddel, utskrivendeLege, pasient, 3);   
    }
    public int prisAaBetale(){
        return 0;
    } 
    @Override
    public String toString(){    
        String string = "------------MilResept--------------";
        string += "\n legemiddel: "+ legemiddel;
        string +="\n UtskrivendeLege: "+utskrivendeLege;
        string +="\n pasient: "+ pasient;
        string +="\n reit: "+ reit;

        return string;

         
    }              
}       
    

