public class Vanlig extends Legemiddel{
    public Vanlig(String navn, int pris, double virkestoff){
        super(navn, pris, virkestoff);
    }
    @Override
    public String toString(){

        String string = "-------------Vanlig-------------";
        string += "\n navn: "+ navn;
        string +="\n pris: "+ pris;
        string +="\n virkestff: "+ virkestoff;       

        return string;   
   }
    @Override
    public int hentStyrke(){
        return 0;
    }
    @Override
    public String typeLegemiddel(){
        return "Vanlig";
    }   
}
