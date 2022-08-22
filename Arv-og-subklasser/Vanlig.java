public class Vanlig extends Legemiddel{

    private int ID;
    public Vanlig(String navn, int pris, double virkestoff){
        super(navn, pris, virkestoff);
        ID++;

    }

    @Override
    public String typeLegemiddel(){
        return"Vanlig";
    }

    @Override
    public String toString(){
        String string = super.toString();
        string += "\nID: " + ID;
        string += "\nType legemiddel: "+ typeLegemiddel();
        string += "\nNavn: " + navn;
        string += "\nPris: " + pris +" kr ";
        string += "\nVirketoff: " + virkestoff +" mg ";
        return string;

    }
    
}
