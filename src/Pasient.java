public class Pasient {


    private String navn;


    private String foedselsnr;
    private Stabel<Resept> resepter = new Stabel<>();
    private static int counter;
    private int id;

    public Pasient(String navn, String foedselsnr) {
        this.navn = navn;
        this.foedselsnr = foedselsnr;
        this.id = counter++;
    }

    public int hentId() {
        return id;
    }

    public String hentNavn() {
        return navn;
    }

    public void settNavn(String navn) {
        this.navn = navn;
    }

    public String hentFoedselsnr() {
        return foedselsnr;
    }

    public void settFoedselsnr(String foedselsnr) {
        this.foedselsnr = foedselsnr;
    }

    public void leggTilResept(Resept resept) {
        resepter.leggPaa(resept);
    }

    public Stabel<Resept> hentResepter() {
        return resepter;
    }

}
