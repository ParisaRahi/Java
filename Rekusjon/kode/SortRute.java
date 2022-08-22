public class SortRute extends Rute {

    public SortRute(int r, int k, Labyrint l){
        super(r, k, l);
    }

    public int hentRadNr(){
        return radNr;
    }

    public int hentKolonneNr(){
        return kolonneNr;
    }

    public Labyrint henLabyrint(){
        return lab;
    }

    @Override
    public void finn(Rute fra){
        //base casen (ingen utvei)
        //System.out.println("Kan ikke starte i sort rute");
    }

    @Override
    public String toString(){
        String str = "#";
        return str;
    }
    
}
