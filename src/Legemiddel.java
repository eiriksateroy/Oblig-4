abstract class Legemiddel {

    private static int count = 0;
    protected String navn;
    protected int id;
    protected double pris;
    protected double virkestoff;

    public Legemiddel(String navn, double pris, double virkestoff) {
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        this.id = count;
        count += 1;
    }

    public int hentId() {
        return id;
    }

    public String hentNavn() {
        return navn;
    }

    public double hentPris() {
        return pris;
    }

    public double hentVirkestoff() {
        return virkestoff;
    }

    public void settNyPris(double pris) {
        this.pris = pris;
    }

    @Override
    public String toString() {
        return String.format("%s (ID: %s): %s kr, %s mg", navn, id, pris, virkestoff);
    }
}
