public class Vanlig extends Legemiddel {
    public Vanlig(String navn, double pris, double virkestoff) {
        super(navn, pris, virkestoff);
    }

    @Override
    public String toString() {
        return String.format("%s (ID: %s): %s kr, %s mg", navn, id, pris, virkestoff);
    }
}
