abstract class Resept {

    protected static int total;
    protected int id;
    protected Legemiddel legemiddel;
    protected Lege utskrivendeLege;
    protected Pasient pasient;
    protected int reit;

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasient = pasient;
        this.reit = reit;

        this.id = total;
        total++;

    }

    public int hentId() {
        return id;
    }

    public Legemiddel hentLegemiddel() {
        return legemiddel;
    }

    public Lege hentLege() {
        return utskrivendeLege;
    }

    public Pasient hentPasientId() {
        return pasient;
    }

    public int hentReit() {
        return reit;
    }

    public boolean bruk() {
        if (reit <= 0) return false;

        reit--;
        return true;
    }

    abstract public String farge();

    abstract public double prisAaBetale();

}
