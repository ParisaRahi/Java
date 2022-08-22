public class Vanedannende extends Legemiddel{

    private int vanedannendeStyrke;
    private int ID;

    public Vanedannende(String navn, int pris, double virkestoff, int styrke){
        super(navn, pris, virkestoff);
        this.vanedannendeStyrke = styrke;
        ID++;
    }

    @Override
    public String typeLegemiddel(){
        return "Vanedannede";
    }

    public int hentVanedannendeStyrke(){
        return vanedannendeStyrke;
    }

    @Override
    public String toString(){
        String string = super.toString();
        string += "\nID: " + ID;
        string += "\nType legemiddel: "+ typeLegemiddel();
        string += "\nNavn: " + navn;
        string += "\nPris: " + pris +" kr ";
        string += "\nVirketoff: " + virkestoff +" mg ";
        string += "\nVanedannende styrke: " + vanedannendeStyrke;
        return string;

    }




    
}
