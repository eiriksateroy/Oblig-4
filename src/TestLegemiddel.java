public class TestLegemiddel {

    static void testLegemiddel(Legemiddel legemiddel) {
        System.out.println(legemiddel.hentNavn());
        System.out.println(legemiddel.hentId());
        System.out.println(legemiddel.hentPris());
        System.out.println(legemiddel.hentVirkestoff());
    }


    static void testNarkotisk(Narkotisk narkotisk) {
        testLegemiddel(narkotisk);
        System.out.println(narkotisk.hentNarkotiskStyrke());
    }

    static void testVanedannende(Vanedannende vanedannende) {
        testLegemiddel(vanedannende);
        System.out.println(vanedannende.hentVanedannendeStyrke());
    }

    static void testVanlig(Vanlig vanlig) {
        testLegemiddel(vanlig);
    }


    public static void main(String[] args) {

        Narkotisk narkotisk = new Narkotisk("Morfin", 2000, 0.1D, 20);
        Vanedannende vanedannende = new Vanedannende("Nikotin", 50, 10, 2);
        Vanlig vanlig = new Vanlig("Ibumetin", 10, 5);

        testNarkotisk(narkotisk);
        testVanedannende(vanedannende);
        testVanlig(vanlig);

        System.out.println(narkotisk.toString());
        System.out.println(vanedannende.toString());
        System.out.println(vanlig.toString());

    }


}
