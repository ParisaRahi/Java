public class Aapning extends HvitRute{

    public Aapning(int r, int k, Labyrint  l){
        super(r, k, l);
    }

    @Override
    public void finn(Rute fra){
        // base casen(åpning med tre naboer)
        System.out.println("Aapninger:");
        System.out.println("(" + radNr + ", " + kolonneNr +")");
                
    }
    
}
