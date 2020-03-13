public class Narkotisk extends Legemiddel {

    protected int styrke;

    public Narkotisk(String navn, double pris, double virkestoff, int styrke) {
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    public int hentNarkotiskStyrke() {
        return styrke;
    }

    @Override
    public String toString() {
        return String.format("%s (ID: %s): %s kr, %s mg, styrke: %s", navn, id, pris, virkestoff, styrke);
    }
}
