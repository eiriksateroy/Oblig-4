public class Lenkeliste<T> implements Liste<T> {

    Node<T> start;
    Node<T> slutt;


    private void sjekkIndeks(int pos) {
        if (pos > stoerrelse() - 1) throw new UgyldigListeIndeks(pos);
        if (pos < 0) throw new UgyldigListeIndeks(pos);
    }

    Node<T> hentNode(int pos) {

        sjekkIndeks(pos);

        Node<T> node = start;

        for (int i = 0; i < pos; i++) node = node.hentNeste();

        return node;
    }

    @Override
    public int stoerrelse() {
        int s = 0;
        Node<T> node = start;

        while (node != null) {
            s += 1;
            node = node.hentNeste();
        }
        return s;
    }

    @Override
    public void leggTil(int pos, T x) {

        if (pos == stoerrelse()) {
            leggTil(x);
            return;
        }

        sjekkIndeks(pos);

        Node<T> nyNode = new Node<>(x);
        Node<T> nesteNode = hentNode(pos);

        //Sann hvis lenke er tom
        if (nesteNode == null) {
            start = slutt = nyNode;
            return;
        }

        Node<T> forrigeNode = nesteNode.hentForrige();
        if (forrigeNode == null) {
            start = nyNode;
        } else {
            nyNode.settForrige(forrigeNode);
            forrigeNode.settNeste(nyNode);
        }

        nyNode.settNeste(nesteNode);
        nesteNode.settForrige(nyNode);


    }

    @Override
    public void leggTil(T x) {

        Node<T> nyNode = new Node<>(x);

        if (start == null || slutt == null) {
            start = slutt = nyNode;
        } else {
            slutt.settNeste(nyNode);
            nyNode.settForrige(slutt);
            slutt = slutt.hentNeste();
        }

    }

    @Override
    public void sett(int pos, T x) {
        sjekkIndeks(pos);
        Node<T> node = hentNode(pos);
        node.settData(x);
    }

    @Override
    public T hent(int pos) {
        Node<T> node = hentNode(pos);
        return node.hentData();
    }

    @Override
    public T fjern(int pos) {

        sjekkIndeks(pos);

        Node<T> node = hentNode(pos);
        Node<T> forrigeNode = node.hentForrige();
        Node<T> nesteNode = node.hentNeste();

        boolean erStart = node == start;
        boolean erSlutt = node == slutt;

        if (forrigeNode != null) {
            forrigeNode.settNeste(nesteNode);

        }

        if (erSlutt) slutt = forrigeNode;

        if (nesteNode != null) {
            nesteNode.settForrige(forrigeNode);

        }

        if (erStart) start = nesteNode;

        return node.hentData();
    }

    @Override
    public T fjern() {

        if (start == null) {
            throw new UgyldigListeIndeks(-1);
        }

        Node<T> node = start;
        Node<T> nesteNode = node.hentNeste();

        boolean erSlutt = start == slutt;

        if (erSlutt) {
            start = slutt = null;
        } else {
            nesteNode.settForrige(null);
            start = nesteNode;
        }

        return node.hentData();
    }
}
