public class Narkotisk extends Legemiddel{

    private int narkotiskStyrke;
    private int ID;

    public Narkotisk(String navn, int pris, double virkestoff, int styrke){
        super(navn,pris,virkestoff);
        narkotiskStyrke = styrke;
        ID++;
    }

    @Override
    public String typeLegemiddel(){
        return "Narkotisk";
    }

    public int hentNarkotiskStyrke(){
        return narkotiskStyrke;
    }

    @Override
    public String toString(){
        String string = super.toString();
        string += "\nID: " + ID;
        string += "\nType legemiddel: "+ typeLegemiddel();
        string += "\nNavn: " + navn;
        string += "\nPris: " + pris +" kr ";
        string += "\nVirketoff: " + virkestoff +" mg ";
        string += "\nnarkotisk styrke: " + narkotiskStyrke;
        return string;
    }    

    
}