import java.util.*;
import java.io.*;

public class Labyrint {

    private Rute [][] lab; // skal ta vare på rutene
    private int antallRader;
    private int antallKolonner;

    public Labyrint(String filnavn){
        lab = lesFraFil(filnavn);
    }

    public Rute[][] lesFraFil(String filNavn){
        Scanner sc = null;
        try{
            sc = new Scanner(new File(filNavn));
        }
        catch(FileNotFoundException e){
            System.out.println("Finner ikke filen");
            System.exit(-1);
        }

        String[] rute = sc.nextLine().split(" ");
        antallRader = Integer.parseInt(rute[0]);
        antallKolonner = Integer.parseInt(rute[1]);

        // lage labyrinten
        Rute [][] labyrint = new Rute[antallRader][antallKolonner];

        //fylle labyrinten
        for(int rad = 0; rad < antallRader; rad++){
            String linje = sc.nextLine();
            for(int kolonne = 0 ; kolonne < antallKolonner; kolonne++){
                if(linje.charAt(kolonne) == '.'){

                    if(    (rad == 0 && (kolonne != 0 || kolonne != antallKolonner-1 ))
                        || (rad == antallRader-1 && (kolonne != 0 || kolonne != antallKolonner-1 ))
                        || (kolonne == 0 && (rad!= 0 || rad != antallRader-1))
                        || (kolonne == antallKolonner-1 && (rad != 0 || rad == antallRader-1))){

                            Aapning aapningRute = new Aapning(rad, kolonne, this);
                            labyrint[rad][kolonne] = aapningRute;
                        }

                    else{
                        Rute hvitRute = new HvitRute(rad, kolonne, this);
                        labyrint[rad][kolonne] = hvitRute;
                    }    
                }
                if(linje.charAt(kolonne) == '#'){
                    Rute sortRute = new SortRute(rad, kolonne, this);
                    labyrint[rad][kolonne] = sortRute;
                }
            }
        }
        //finne naboer og legge dem til i naboListe{nord, syd, oest, vest}
        for(int rad = 0; rad < labyrint.length; rad++ ){
            for(int kolonne = 0 ; kolonne <labyrint[rad].length; kolonne ++ ){

                //sjekke første raden i 3 tilstander
                if(rad == 0 ){
                    if(kolonne == 0){
                        labyrint[rad][kolonne].setOest(labyrint[rad][kolonne +1]);//oest
                        labyrint[rad][kolonne].setSyd(labyrint[rad+1][kolonne]); //syd
                    }
                    else if(kolonne == antallKolonner -1){
                        labyrint[rad][kolonne].setVest(labyrint[rad][kolonne-1]); //vest
                        labyrint[rad][kolonne].setSyd(labyrint[rad+1][kolonne]); //syd
                    }

                    else{
                        labyrint[rad][kolonne].setVest(labyrint[rad][kolonne-1]); //vest
                        labyrint[rad][kolonne].setOest(labyrint[rad][kolonne +1]); //oest
                        labyrint[rad][kolonne].setSyd(labyrint[rad+1][kolonne]); //syd
                    }
                }
                //sjekke siste raden i 3 tilstander
                else if(rad == antallRader-1){
                    if(kolonne == 0){
                        labyrint[rad][kolonne].setOest(labyrint[rad][kolonne +1]); //oest
                        labyrint[rad][kolonne].setNord(labyrint[rad-1][kolonne]); //nord
                    }
                    else if(kolonne == antallKolonner -1){
                        labyrint[rad][kolonne].setVest(labyrint[rad][kolonne-1]); //vest
                        labyrint[rad][kolonne].setNord(labyrint[rad-1][kolonne]); //nord
                    }
                    else{
                        labyrint[rad][kolonne].setVest(labyrint[rad][kolonne-1]); //vest
                        labyrint[rad][kolonne].setOest(labyrint[rad][kolonne +1]); //oest
                        labyrint[rad][kolonne].setNord(labyrint[rad-1][kolonne]); //nord
                    }
                }
                //sjekke føsrte kolonnen
                else if(kolonne == 0){
                    labyrint[rad][kolonne].setNord(labyrint[rad-1][kolonne]);//nord
                    labyrint[rad][kolonne].setSyd(labyrint[rad+1][kolonne]);//syd
                    labyrint[rad][kolonne].setOest(labyrint[rad][kolonne + 1]);//oest
                }
                //sjekke siste kolonnen
                else if(kolonne == antallKolonner -1){
                    labyrint[rad][kolonne].setNord(labyrint[rad-1][kolonne]);//nord
                    labyrint[rad][kolonne].setSyd(labyrint[rad+1][kolonne]);//syd
                    labyrint[rad][kolonne].setVest(labyrint[rad][kolonne -1]);//vest
                }
                //sjekke rutene som ligger på mideten
                else{
                    labyrint[rad][kolonne].setNord(labyrint[rad-1][kolonne]); //nord
                    labyrint[rad][kolonne].setSyd(labyrint[rad+1][kolonne]); //syd
                    labyrint[rad][kolonne].setOest(labyrint[rad][kolonne + 1]); //oest
                    labyrint[rad][kolonne].setVest(labyrint[rad][kolonne -1]); //vest
                }              
            }
        }
        return labyrint;
    }

    public void finnUtveiFra(int rad, int kolonne){
        lab[rad][kolonne].finn(null);
        
    }

    @Override
    public String toString(){
        String str = "";
        for(Rute[] rad: lab){
            for(Object kolonne : rad){
                    str += kolonne.toString();   
            }   
            str += "\n" ;      
        }
        return str;
    }
}