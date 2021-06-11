package block_15_List.myList;

public class Node<T> {
    Node<T> prev;
    Node<T> next;
    T value;

    public Node(Node<T> prev, T value, Node<T> next) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }
}
