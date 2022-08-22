
public abstract class Rute {

    protected int radNr;
    protected int kolonneNr;
    protected Labyrint lab;

    public Rute nord ;
    public Rute syd ;
    public Rute oest ;
    public Rute vest ;

    public Rute(int r, int k, Labyrint l){
        radNr = r;
        kolonneNr = k;
        lab = l; 
    }

    public void setNord(Rute n){
        nord = n;
    }

    public void setSyd(Rute s){
        syd = s;
    }

    public void setOest(Rute o){
        oest = o;
    }

    public void setVest(Rute v){
        vest = v;
    }

    public void finn(Rute fra){
        //base casen er enten en åpning rute eller en sort rute.
       
    }
}
