import static java.lang.Math.max;

public class PResept extends HResept {
    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId) {
        super(legemiddel, utskrivendeLege, pasientId, 3);
    }

    @Override
    public double prisAaBetale() {
        return max(0, legemiddel.hentPris() - 108);
    }

    @Override
    public String toString() {
        return String.format("Prevensjonsresept (ID: %s) for: %s, skrevet ut av doktor %s, pasientid: %s, reit: %s", id, legemiddel.hentNavn(), utskrivendeLege.hentNavn(), pasientId, reit);
    }
}
