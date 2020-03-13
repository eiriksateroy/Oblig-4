public class IntegrasjonsTest {


    public static void main(String[] args) {

        int pasientId = 2;

        Lege lege = new Lege("Ole");
        Spesialist spesialist = new Spesialist("Knut", 1);

        Narkotisk narkotisk = new Narkotisk("Morfin", 400, 0.05D, 10);
        Vanedannende vanedannende = new Vanedannende("Nikotin", 100, 0.1, 5);
        Vanlig vanlig = new Vanlig("Progesteron", 200, 1);


        BResept bResept = new BResept(vanedannende, lege, pasientId, 4);
        HResept hResept = new HResept(vanlig, lege, pasientId, 10);
        MResept mResept = new MResept(narkotisk, spesialist, pasientId, 5);
        PResept pResept = new PResept(vanlig, lege, pasientId);


        System.out.println(lege.toString());
        System.out.println(spesialist.toString());
        System.out.println(narkotisk.toString());
        System.out.println(vanedannende.toString());
        System.out.println(vanlig);
        System.out.println(bResept.toString());
        System.out.println(hResept.toString());
        System.out.println(mResept.toString());
        System.out.println(pResept.toString());

    }


}
