public class Vanedannende extends Legemiddel {
    protected int styrke;

    public Vanedannende(String navn, int pris, double virkestoff, int styrke){ 
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }
    public int hentStyrke(){
        return this.styrke;
    }
    @Override
    public String toString(){
       
        String string = "-------------Vanedannende-------------";
        string += "\n navn: "+ navn;
        string +="\n pris: "+ pris;
        string +="\n virkestff: "+ virkestoff;
        string +="\n styrke: "+ styrke;

        return string; 
    
    }

    @Override
    public String typeLegemiddel(){
        return "Vanedannende";
    }

}
