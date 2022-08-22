
import java.util.LinkedList;
import java.util.Random;


public class Model {

    private GUI gui;
    
    private int antaRader;
    private int antaKolonner;
    private int slangePosRad;
    private int slangePosKolonne;
    private String[][] brett;  // viser at hvor i bretten er gyldig å gå
    public LinkedList<Koordinat> skatter = new LinkedList<>();
    private int antalltreff = 1;
    public LinkedList<Koordinat> slangeLista = new LinkedList<>();
    

    public Model(GUI g, int r, int k){
        gui = g;
        
        antaRader = r;
        antaKolonner = k;
        brett = new String[antaRader][antaKolonner];
        fylleInnBrett();
        plasserSkattStart();
        plasserSlangeStart();

    }

    public void fylleInnBrett(){
        for(int i = 0; i < antaRader; i++){
            for(int j= 0; j < antaKolonner ; j++){
                brett[i][j] = gui.ruter[i][j].getText();
            }
        }
    }

    public void flytt(Rettning rettning){
        int midSlangePosRad = slangePosRad;
        int midSlangePosKolonne = slangePosKolonne;

        if(Rettning.OPP == rettning ) midSlangePosRad--;
        if(Rettning.NED == rettning ) midSlangePosRad ++;
        if(Rettning.HOYRE == rettning ) midSlangePosKolonne++;
        if(Rettning.VENSTRE == rettning ) midSlangePosKolonne--;

        if(slangeGyldigPosisjon(midSlangePosRad, midSlangePosKolonne)){// && !truffetSkatt() 
            besokRute(midSlangePosRad, midSlangePosKolonne);          
        }  
    }

    private boolean truffetSkatt(){
        for(Koordinat s: skatter){
            if(s != null && s.likKordinat(slangePosRad, slangePosKolonne)){
                return true;
            }
        }
        return false;
    }


    private boolean slangeGyldigPosisjon(int posRad, int posKolonne){
        if(posRad < 0 || posRad >= antaRader) return false;
        if(posKolonne < 0 || posKolonne >= antaKolonner) return false;
        return true;
    }

    public void plasserSlangeStart(){
        Random r = new Random();
        slangePosRad = r.nextInt(antaRader);
        slangePosKolonne = r.nextInt(antaKolonner);
        
        while(!slangeGyldigPosisjon(slangePosRad, slangePosKolonne) ){
            slangePosRad = r.nextInt(antaRader);
            slangePosKolonne = r.nextInt(antaKolonner);
        }
        slangeLista.add(new Koordinat(slangePosRad, slangePosKolonne));
        besokRute(slangePosRad, slangePosKolonne);

    }

    public void besokRute(int rad, int kolonne){
        if(!slangeLista.isEmpty()){
           
            gui.slangeHarBesoktRute(slangeLista.get(0).hentRad(),slangeLista.get(0).hentKolonne());//fjerne forrige koordinaten
        }
        slangePosRad = rad;
        slangePosKolonne = kolonne;
        slangeLista.add(new Koordinat(slangePosRad, slangePosKolonne));
        
        if( !truffetSkatt() && slangeLista.size()>= 1){
            slangeLista.removeFirst();
                  
        }
        
        for(Koordinat e: slangeLista){
            gui.tegnSlange(e.hentRad(), e.hentKolonne());
            
        }
        if(truffetSkatt()){
            slangeLista.add(new Koordinat(slangePosRad, slangePosKolonne));
            antalltreff++;
            gui.setLengde(antalltreff);
            Koordinat fjern = slangeLista.removeFirst();
            gui.slangeHarBesoktRute(fjern.hentRad(), fjern.hentKolonne());
            gui.leggTilSlange(slangePosRad, slangePosKolonne);
            
        }
    }  

    public boolean skattGyldigPossjon(int rad, int kolonne){
        if(slangePosRad == rad && slangePosKolonne == kolonne) return true;
        for(Koordinat s: skatter){
            if(s!= null && s.likKordinat(rad, kolonne)) return true;
        }
        return false;
        
    }
    
    //lage skatter
    public Koordinat plasserSkatt(){
        Random r = new Random();
        int skattRad = r.nextInt(antaRader);
        int skattKolonne = r.nextInt(antaKolonner);
        while(!slangeGyldigPosisjon(skattRad, skattKolonne) || skattGyldigPossjon(skattRad, skattKolonne)){
            skattRad = r.nextInt(antaRader);
            skattKolonne = r.nextInt(antaKolonner);
        } 
        return new Koordinat(skattRad, skattKolonne);
    }

    public void plasserSkattStart(){
        for(int i = 0 ; i < 10; i++ ){
            skatter.add(plasserSkatt());
        }

        for(Koordinat s: skatter){
            gui.tegnSkatt(s.hentRad(), s.hentKolonne());
        }
    }
}
