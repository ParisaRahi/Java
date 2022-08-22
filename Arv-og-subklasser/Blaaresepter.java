import java.lang.Math;
public class Blaaresepter extends Resept{

    private int reseptID;
    private static final double rabatt = 0.75;
    public Blaaresepter(Legemiddel legemid, Lege utSkrLege, int pID, int reit ){
        super(legemid, utSkrLege, pID, reit);
        reseptID++;

    }

    public double hentRabatt(){
        return rabatt;
    }

    @Override
    public String farge(){
        return "Blaa";
    }

    @Override
    public int prisAaBetale(){
        int betalingspris = 0;
        double pris = legemiddel.hentPris() * rabatt;
        betalingspris = ((int)Math.round(pris));
        return betalingspris;
    }
    @Override
    public String toString(){
        String string = "----Resept----";
        string +="\nPasientID: " + hentPasientID();
        string += "\nType resept: " + farge();
        string += "\nType av legemiddel:" + legemiddel.typeLegemiddel();
        string += "\nLege: "+ utskrivedeLege.hentNavn();
        string += "\nantall reit igjen: " + hentReit();
        string += "\nRabat: " + (int)(hentRabatt() * 100) + "%";
        string += "\nPrisen til å betale: " + prisAaBetale() +" kr";
        return string;
    }

}
