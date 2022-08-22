public class MilResept extends Hviteresepter {

    private int reseptID;
    private static final int rabatt = 1;

    public MilResept( Legemiddel legemid, Lege utSkrLege, int pID ){
        super(legemid, utSkrLege, pID, 3);
        reseptID++;
    }
    
    public int hentRabatt(){
        return rabatt;
    }

    @Override
    public int prisAaBetale(){
        int betalingspris = 0;
        betalingspris = legemiddel.hentPris() - (legemiddel.hentPris()*rabatt);
        return betalingspris;
    }

    @Override
    public String toString(){
        String string = "----Resept----";
        string +="\nPasientID: " + hentPasientID();
        string += "\nType resept: " + super.farge();
        string += "\nType av legemiddel:" + legemiddel.typeLegemiddel();
        string += "\nLege: "+ utskrivedeLege.hentNavn();
        string += "\nRabat: " + (hentRabatt() * 100) + " %";
        string += "\nPrisen til å betale: " + prisAaBetale() + " kr";
        return string;
    }




    
}
