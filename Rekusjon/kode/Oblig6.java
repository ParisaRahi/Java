import java.util.*;

public class Oblig6 {
    public static void main(String[] args) {

        String filnavn = args[0];
        Labyrint lab = new Labyrint(filnavn);

        System.out.println();
        System.out.println("Slik ser labyrinten ut:");
        System.out.println(lab);

        Scanner bruker = new Scanner(System.in);
        System.out.println("Skriv inn koordinater <rad> <kolonne> ('-1' for aa avslutte)");
        int inn = 0;
        while(inn!= -1){ 
            String[] koordinaten = bruker.nextLine().split(" ");
            if(koordinaten.length == 1){
                inn = Integer.parseInt(koordinaten[0]);
            }   
            else{
                int rad = Integer.parseInt(koordinaten[0]);
                int kolonne = Integer.parseInt(koordinaten[1]);
                lab.finnUtveiFra(rad, kolonne);
                System.out.println("Skriv inn nye koordinater ('-1' for aa avslutte)");
            } 
            
        }
    }
    
}
