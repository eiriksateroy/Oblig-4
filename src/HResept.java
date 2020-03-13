public class HResept extends Resept {

    public HResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

    @Override
    public String farge() {
        return "hvit";
    }

    @Override
    public double prisAaBetale() {
        return legemiddel.hentPris();
    }

    @Override
    public String toString() {
        return String.format("Hvit resept (ID: %s) for: %s, skrevet ut av doktor %s, pasient: %s, reit: %s", id, legemiddel.hentNavn(), utskrivendeLege.hentNavn(), pasient, reit);
    }
}
