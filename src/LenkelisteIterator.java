import java.util.Iterator;

public class LenkelisteIterator<T> implements Iterator<T> {

    private Lenkeliste<T> lenkeliste;
    private int index;

    public LenkelisteIterator(Lenkeliste<T> lenkeliste) {
        this.lenkeliste = lenkeliste;
    }

    @Override
    public boolean hasNext() {
        return (index < lenkeliste.stoerrelse());
    }

    @Override
    public T next() {
        return lenkeliste.hent(index++);
    }
}
