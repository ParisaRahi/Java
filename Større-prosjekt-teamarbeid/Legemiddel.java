public abstract class Legemiddel{

    static int nesteId = 1;
    protected String navn;
    protected int id; // resept og legemiddel kan ha samme ID. det automatisk
    protected int pris;
    protected double virkestoff;//for alle legemidler kan vite hvor mye virkestoff

    public Legemiddel(String navn, int pris, double virkestoff){
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        this.id = nesteId;
        nesteId++;
    }
    
    public int hentId(){
        return id;
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

    public void settNypris(int nyttpris){
        pris = nyttpris; // med type variable opprette en ny lokale variabel
    }

    public abstract String typeLegemiddel();

    public abstract int hentStyrke();
       
    @Override
    public String toString(){
        return "ID: "+ id + "Navn: " + navn + "Pris:" + pris + "Virkestoff" + virkestoff ;
    }
}

