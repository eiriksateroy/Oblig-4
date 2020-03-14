public class Lege implements Comparable<Lege> {

    protected String navn;
    private Lenkeliste<Resept> utskrevedeResepter;

    public Lege(String navn) {
        this.navn = navn;
        utskrevedeResepter = new Lenkeliste<>();
    }


    public Lenkeliste<Resept> hentResepter() {
        return utskrevedeResepter;
    }

    public String hentNavn() {
        return navn;
    }

    private boolean erUlovlig(Legemiddel legemiddel) {
        return (!(this instanceof Spesialist) && legemiddel instanceof Narkotisk);
    }

    public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (erUlovlig(legemiddel)) throw new UlovligUtskrift(this, legemiddel);
        HvitResept resept = new HvitResept(legemiddel, this, pasient, reit);
        utskrevedeResepter.leggTil(resept);
        return resept;
    }

    public MilitaerResept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (erUlovlig(legemiddel)) throw new UlovligUtskrift(this, legemiddel);
        MilitaerResept resept = new MilitaerResept(legemiddel, this, pasient, reit);
        utskrevedeResepter.leggTil(resept);
        return resept;
    }

    public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
        if (erUlovlig(legemiddel)) throw new UlovligUtskrift(this, legemiddel);
        PResept resept = new PResept(legemiddel, this, pasient);
        utskrevedeResepter.leggTil(resept);
        return resept;
    }

    public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (erUlovlig(legemiddel)) throw new UlovligUtskrift(this, legemiddel);
        BlaaResept resept = new BlaaResept(legemiddel, this, pasient, reit);
        utskrevedeResepter.leggTil(resept);
        return resept;
    }


    @Override
    public String toString() {
        return String.format("Doktor %s", navn);
    }

    @Override
    public int compareTo(Lege o) {
        return navn.compareTo(o.navn);
    }
}
