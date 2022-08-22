public class PResept extends Hviteresepter{

    private int reseptID;
    private static final int rabatt = 108;

    public PResept(Legemiddel legemid, Lege utSkrLege, int pID, int reit ){
        super(legemid, utSkrLege, pID, reit);
        reseptID ++;
    }

    public int hentRabatt(){
        return rabatt;
    }

    @Override
    public int prisAaBetale(){
        int betalingspris = 0;

        if (legemiddel.hentPris() > rabatt){
            betalingspris = legemiddel.hentPris() - rabatt;
        }
        else{
            betalingspris = 0;
        }
        return betalingspris;
    }
    @Override
    public String toString(){
        String string = "----Resept----";
        string +="\nPasientID: " + hentPasientID();
        string += "\nType resept: " + super.farge();
        string += "\nType av legemiddel:" + legemiddel.typeLegemiddel();
        string += "\nLege: "+ utskrivedeLege.hentNavn();
        string += "\nantall reit igjen: " + hentReit();
        string += "\nRabat: " + hentRabatt() + "kr";
        string += "\nPrisen til å betale: " + prisAaBetale()+ " kr";
        return string;
    }


    
}
