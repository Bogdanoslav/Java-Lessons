package block_15_List.myList;

import java.util.Iterator;

public class MyListIterator<T> implements Iterator<T> {
    private Node<T> current;
    public MyListIterator(Node<T> first) {
        this.current = first;
    }

    @Override
    public boolean hasNext() {
        return current!=null;
    }

    @Override
    public T next() {
        Node<T> prev = current;
        current = current.next;
        return prev.value;
    }
}
