public class Lege {
    
    protected String navn;

    public Lege(String n){
        navn = n;
    }

    public String hentNavn(){
        return navn;
    }

    public String toString(){
        String string = "----Lege----";
        string +="\nLege: " + hentNavn();
        return string;
    }
}
