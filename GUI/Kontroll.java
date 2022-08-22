public class Kontroll{
    private GUI gui;
    private Model model;
    private int dimensjon = 12;
    private Thread traad;
    private Rettning rettning = Rettning.HOYRE;

    public Kontroll(){
        gui = new GUI(this, dimensjon,dimensjon);
        model = new Model(gui, dimensjon,dimensjon);
        traad = new Thread(new Teller());
        traad.start();
    }
    public Rettning hentRettning(){
        return rettning;
    }


    class Teller implements Runnable{
        @Override
        public void run(){
            while(true){
                try{
                    Thread.sleep(2000);
                }
                catch(Exception e){
                    return;
                }
                flytt();
            }
        }
    }
    public void flytt(){
        model.flytt(rettning);
        //gui.oppdater(model);
    }

    public void endreRettning(Rettning rettning){
        this.rettning = rettning;
    }
 

    public void avslutt(){
        System.exit(0);
    }   
}