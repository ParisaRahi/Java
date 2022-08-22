public class HvitRute extends Rute{

    public HvitRute(int r, int k, Labyrint l){
        super(r, k, l);
    }

    public int hentRadNr(){
        return radNr;
    }

    public int kolonneNr(){
        return kolonneNr;
    }

    public Labyrint henLabyrint(){
        return lab;
    }

    @Override
    public void finn(Rute fra){
        
        //hvis fra sin retning ikke er nord, så finn nord for den oppgitte ruteren(fra)
        if(fra != nord){
            nord.finn(this);
        }
        if(fra != syd){
            syd.finn(this);
        }
        if(fra != oest){
            oest.finn(this);
        }
        if(fra != vest){
            vest.finn(this);
        }
    }


    @Override
    public String toString(){
        String str = ".";
        return str;
    }


    
}
