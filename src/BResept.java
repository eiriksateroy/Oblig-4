public class BResept extends Resept {
    public BResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

    @Override
    public String farge() {
        return "blaa";
    }

    @Override
    public double prisAaBetale() {
        return legemiddel.hentPris() * 0.25;
    }

    @Override
    public String toString() {
        return String.format("Blaa resept (ID: %s) for: %s, skrevet ut av doktor %s, pasient: %s, reit: %s", id, legemiddel.hentNavn(), utskrivendeLege.hentNavn(), pasient, reit);
    }

}
