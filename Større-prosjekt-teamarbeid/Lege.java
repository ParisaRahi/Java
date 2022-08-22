public class Lege implements Comparable<Lege> {
    protected String navn;
    protected IndeksertListe<Resept> utskrevneResept = new IndeksertListe<>();
   
    public Lege(String navn) {
        this.navn = navn;
    }

    public String hentNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return "Dr. " + navn;
    }

    // D1
    @Override
    public int compareTo(Lege andreLege) {
        return this.navn.compareTo(andreLege.hentNavn());
    }

    // D2
    public IndeksertListe<Resept> hentResept() {
        return utskrevneResept;
    }

    // D3
    HviteResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {

        HviteResept hviteResept = new HviteResept(legemiddel, this, pasient, reit);
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this, legemiddel);
        }

        utskrevneResept.leggTil(hviteResept);
        pasient.leggTil(hviteResept);

        return hviteResept;
    }

    MilResept skrivMilResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {

        MilResept milResept = new MilResept(legemiddel, this, pasient);
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this, legemiddel);
        }
        utskrevneResept.leggTil(milResept);
        pasient.leggTil(milResept);
        return milResept;

    }

    PResept skrivPResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        PResept pResept = new PResept(legemiddel, this, pasient, reit);
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this, legemiddel);
        }
        utskrevneResept.leggTil(pResept);
        pasient.leggTil(pResept);
        return pResept;

    }

    BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        BlaaResept blaaResept = new BlaaResept(legemiddel, this, pasient, reit);
        if (legemiddel instanceof Narkotisk && !(this instanceof Spesialist)) {
            throw new UlovligUtskrift(this, legemiddel);
        }
        utskrevneResept.leggTil(blaaResept);
        pasient.leggTil(blaaResept);
        return blaaResept;

    }

    

}
