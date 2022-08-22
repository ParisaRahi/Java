public class Spesialist extends Lege implements Godkjenningsfritak {
    //Spesialister har fått godkjenningsfritak til å skrive ut resept på narkotiske legemidler

    private String kontrollID;

    public Spesialist(String navn, String kID ){
        super(navn);
        kontrollID = kID;
    }


    @Override
    public String hentKontrollID(){
        return kontrollID;
    }

    @Override
    public String toString(){
        String string = super.toString();
        string += "\nkontrollID: " + hentKontrollID();
        return string;
    }



    
}
