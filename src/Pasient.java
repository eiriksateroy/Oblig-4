public class Pasient {


    private String navn;
    private String foedselsnr;
    private Stabel<Resept> resepter;

    public Pasient(String navn, String foedselsnr) {
        this.navn = navn;
        this.foedselsnr = foedselsnr;
    }

    void leggTilResept(Resept resept) {
        resepter.leggPaa(resept);
    }

    Stabel<Resept> hentResepter() {
        return resepter;
    }

}
