public class HResept extends Resept {

    public HResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
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
        return String.format("Hvit resept (ID: %s) for: %s, skrevet ut av doktor %s, pasientid: %s, reit: %s", id, legemiddel.hentNavn(), utskrivendeLege.hentNavn(), pasientId, reit);
    }
}
