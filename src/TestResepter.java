public class TestResepter {

    private static void testResept(Resept resept) {
        System.out.println("Legemiddel: " + resept.hentLegemiddel().hentNavn());
        System.out.println("ID: " + resept.hentId());
        System.out.println("Lege: " + resept.hentLege().hentNavn());
        System.out.println("PasientID: " + resept.hentPasientId());
        System.out.println("Reit: " + resept.hentReit());
        System.out.println("Pris å betale: " + resept.prisAaBetale());
        System.out.println("Farge: " + resept.farge());
    }


    public static void main(String[] args) {

        Lege lege = new Lege("Gunnar");
        Vanedannende nikotin = new Vanedannende("Nikotin", 50, 2, 2);
        Vanlig progesteron = new Vanlig("Progesteron", 10, 10);
        Narkotisk opium = new Narkotisk("Opium", 200, 1, 5);

        System.out.println("Test av PResept");
        PResept pResept = new PResept(progesteron, lege, 1);
        testResept(pResept);

        System.out.println("\nTest av Militærresept");
        MResept mResept = new MResept(nikotin, lege, 2, 10);
        testResept(mResept);

        System.out.println("\nTest av hvit resept");
        HResept hResept = new HResept(nikotin, lege, 3, 5);
        testResept(hResept);

        System.out.println("\nTest av blå resept");
        BResept bResept = new BResept(opium, lege, 4, 3);
        testResept(bResept);


    }

}
