public class MResept extends HResept {
    public MResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
    }

    @Override
    public double prisAaBetale() {
        return 0;
    }


    @Override
    public String toString() {
        return String.format("Militaerresept (ID: %s) for: %s, skrevet ut av doktor %s, pasient: %s, reit: %s", id, legemiddel.hentNavn(), utskrivendeLege.hentNavn(), pasient, reit);
    }

}
