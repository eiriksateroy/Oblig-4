public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {


    private void swap(Node<T> node1, Node<T> node2) {
        //Node 1 starter mot starten av lista

        boolean node2erslutt = node2 == slutt;

        node1.settNeste(node2.hentNeste());
        if (node2.hentNeste() != null) node2.hentNeste().settForrige(node1);
        node2.settNeste(node1);

        node2.settForrige(node1.hentForrige());
        if (node2.hentForrige() != null) node1.hentForrige().settNeste(node2);
        node1.settForrige(node2);

        if (node2erslutt) slutt = node1;
    }

    private void sort(Node<T> node1) {
        Node<T> node2 = start;

        if (node1.hentData().compareTo(node2.hentData()) == 0) {
            boolean ernode2start = node2 == start;

            node1.settNeste(node2);
            node1.settForrige(node2.hentForrige());
            node2.settForrige(node1);

            if (ernode2start) start = node1;
        }

        while (node1.hentData().compareTo(node2.hentData()) > 0) {
            boolean ernode2slutt = node2 == slutt;
            swap(node1, node2);
            if (ernode2slutt) slutt = node1;
            node2 = node1.hentNeste();
            if (node2 == null) break;
        }
    }

    @Override
    public void leggTil(T x) {

        Node<T> nyNode = new Node<>(x);
        if (stoerrelse() == 0) {
            start = slutt = nyNode;
            return;
        }

        if (nyNode.hentData().compareTo(start.hentData()) < 0) {
            start.settForrige(nyNode);
            nyNode.settNeste(start);
            start = nyNode;
        } else {
            sort(nyNode);
        }


        slutt = hentNode(stoerrelse() - 1);

    }

    @Override
    public T fjern() {
        return super.fjern(stoerrelse() - 1);
    }

    @Override
    public void leggTil(int pos, T x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sett(int pos, T x) {
        throw new UnsupportedOperationException();
    }
}
