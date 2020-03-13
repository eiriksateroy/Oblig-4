public class MResept extends HResept {
    public MResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    @Override
    public double prisAaBetale() {
        return 0;
    }


    @Override
    public String toString() {
        return String.format("Militaerresept (ID: %s) for: %s, skrevet ut av doktor %s, pasientid: %s, reit: %s", id, legemiddel.hentNavn(), utskrivendeLege.hentNavn(), pasientId, reit);
    }

}
