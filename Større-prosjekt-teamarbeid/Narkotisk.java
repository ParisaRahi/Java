public class Narkotisk extends Legemiddel{
        
    protected int styrke;
    public Narkotisk(String navn, int pris, double virkestoff,int styrke){
            super(navn, pris, virkestoff);
            this.styrke = styrke;
    }   
    @Override
    public int hentStyrke(){
   
        return styrke;
    }
    @Override
    public String toString(){
        
        String string = "-------------Narkotisk-------------";
        string += "\n navn: "+ navn;
        string +="\n pris: "+ pris;
        string +="\n virkestff: "+ virkestoff;
        string +="\n styrke: "+ styrke;

        return string; 
    
    }
    @Override
    public String typeLegemiddel(){
        return "Narkotisk";
    }


}


    

        
    

