public class Pasient {
    static int nesteID = 1;
    protected String navn;
    protected String fodselsnummer;
    protected int pasientID;

    protected IndeksertListe<Resept> resepList = new IndeksertListe<Resept>();
    
    public Pasient(String navn, String fodselsnummer){
        this.navn = navn;
        this.fodselsnummer = fodselsnummer;
        this.pasientID = nesteID;
        nesteID ++;
   

    }   
    public int hentId(){
        return pasientID;
    }
    public String hentNavn(){
        return navn;
    }
    public String hentfNr() {
        return fodselsnummer;
    }
    public IndeksertListe<Resept> hentReseptliste(){
        return resepList;

    }
    public void leggTil(Resept nyResept){
        resepList.leggTil(nyResept);

    }
    @Override
    public String toString(){
        return "navn:" + navn + ", fNr:" + fodselsnummer;
    }

}
