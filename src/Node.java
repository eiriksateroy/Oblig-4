public class Node<T> {

    private Node<T> neste;
    private Node<T> forrige;
    private T data;

    Node(T data) {
        this.data = data;
    }

    T hentData() {
        return data;
    }

    void settData(T data) {
        this.data = data;
    }

    Node<T> hentNeste() {
        return neste;
    }

    void settNeste(Node<T> neste) {
        this.neste = neste;
    }

    Node<T> hentForrige() {
        return forrige;
    }

    void settForrige(Node<T> forrige) {
        this.forrige = forrige;
    }

}
