public class TestLenkelisteiter {

    public static void main(String[] args) {

        Lenkeliste<String> lenkeliste = new Lenkeliste<>();

        lenkeliste.leggTil("Hei");
        lenkeliste.leggTil("På");
        lenkeliste.leggTil("Deg");

        for (String string : lenkeliste
        ) {
            System.out.println(string);
        }

    }

}
