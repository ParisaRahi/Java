public abstract class Legemiddel{

    protected String navn;
    protected int pris;
    protected double virkestoff;
    private int ID = 0;

    public Legemiddel(String navn, int pris, double virkestoff){
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        ID++;
    }

    public abstract String typeLegemiddel();

    public int hentId(){
        return ID;
    }

    public String hentNavn(){
        return navn;
    }

    public int hentPris(){
        return pris;
    }

    public double hentVirkestoff(){
        return virkestoff;
    }

    public void settNyPris(int nypris){
        pris = nypris;
    }

    public String toString(){
        String string = "\n------Legemiddel------";
        return string;

    }

} 
