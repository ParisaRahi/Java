public class Koordinat {
    
    private int rad;
    private int kolonne;

    public Koordinat(int r,int k ){
        rad = r;
        kolonne = k;
    }

    public int hentRad(){
        return rad;
    }

    public int hentKolonne(){
        return kolonne;
    }

    public boolean likKordinat(int rad, int kolonne){
        return(this.rad == rad && this.kolonne == kolonne);
    }

    public String toString(){
        String str= " ";
        return str;
    }
}
