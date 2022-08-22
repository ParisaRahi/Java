public class Hovedprogram {
    public static void main(String[] args) {
        Narkotisk narkotisk = new Narkotisk("Oxynorm", 299, 5, 100);
        //String navn, int pris, double virkestoff,int styrke
        Vanedannende vanedannende = new Vanedannende("Sobril", 199, 15, 70);
        Vanlig vanlig = new Vanlig("Paracet", 79, 30);
        System.out.println(narkotisk);
        System.out.println(vanedannende);
        System.out.println(vanlig);
    
        Lege lege = new Lege("Mikael");
        Pasient pasient1 = new Pasient("Simon", "11019823456");
        HviteResept hviteResept = new HviteResept(vanlig, lege,pasient1,1);
        System.out.println(hviteResept);

        Lege lege1 = new Lege("Clara");
        Pasient pasient2 = new Pasient("Sarah", "11019023456");
        //  public Pasient(String navn, String fodselsnummer, int pasientID
        BlaaResept blaaResept = new BlaaResept(narkotisk, lege1,pasient2,2);
        //BlaaResept(Legemiddel legemiddel,Lege utskrivendeLege, Pasient pasient, int reit
        System.out.println(blaaResept);

        Lege lege2 = new Lege("Eva");
        Pasient pasient3 = new Pasient("Karsen", "11119012345");
        MilResept milResept = new MilResept(vanedannende, lege2, pasient3);
        System.out.println(milResept);

        Vanlig vanlig1 = new Vanlig("Desogelstrel", 99, 75);
        Lege lege3 = new Lege("David");
        Pasient pasient4 = new Pasient("Harah", "11019023457");
        PResept pResept = new PResept(vanlig1,lege3,pasient4,3);
        System.out.println(pResept);

        Spesialist spesialist = new  Spesialist("Monika", "84011112345");
        System.out.println(spesialist);

        

    
    }
    
}

