package block_15_List.myList;

import java.util.*;

public class MyList<T> implements Iterable<T> {
    Node<T> first;
    Node<T> last;
    int size;

    public boolean add(T o) {
        Node<T> newNode;
        if(size==0){
            linkFirst(o);
        } else{
            newNode = new Node<>(last, o, null);
            last.next = newNode;
            last = newNode;
        }
        size++;
        return true;
    }

    public void add(int index, T element) {
        Node<T> currentNode = getNode(index);
        if(index==size){
            add(element);
        } else if(index == 0){
            linkFirst(element);
        }
        else{
            Node<T> prevNode = currentNode.prev;
            Node<T> newNode = new Node<>(prevNode, element, currentNode);
            currentNode.prev = newNode;
            prevNode.next = newNode;
        }
        size++;
    }
    private void linkFirst(T o){
        Node<T> firstNode = first;
        Node<T> newNode = new Node<>(null, o, null);
        if(firstNode!=null){
            newNode.next = firstNode;
        } else{
            last = newNode;
        }
        first = newNode;
    }
    public int size() {
        return size;
    }
    private boolean checkIndex(int index){
        return index >= 0 && index < size;
    }
    public Node<T> getNode(int index){
        if(!checkIndex(index)){
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = first;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }
    public Node<T> getNode(Object o){
        for(Node<T> node = first; node!=null; node = node.next){
            if(node.value.equals(o))
                return node;
        }
        return null;
    }

    public T get(int index) {
        Node<T> node = getNode(index);
        return node.value;
    }


    public T set(int index, T element) {
        Node<T> node = getNode(index);
        T value = node.value;
        node.value = element;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return getNode(o) != null;
    }
    public int indexOf(Object o) {
        int index = 0;
        for(Node<T> node = first; node!=null; node = node.next){
            if(node.value.equals(o))
                return index;
            index++;
        }
        return -1;
    }
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for(Node<T> node = first; node!=null; node = node.next){
            array[i++] = node.value;
        }
        return array;
    }

    private void unlinkNode(Node<T> node){
        Node<T> nextNode = node.next;
        Node<T> prevNode = node.prev;
        if(size==1)
            clear();
        else if(nextNode==null){
            last = prevNode;
            prevNode.next = null;
        }
        else if(prevNode==null){
            first = nextNode;
            nextNode.prev = null;
        }
        else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
    }
    public boolean remove(Object o) {
        Node<T> node = getNode(o);
        if(node!=null){
            unlinkNode(node);
            size--;
            return true;
        }
        return false;
    }
    public T remove(int index) {
        Node<T> node = getNode(index);
        unlinkNode(node);
        size--;
        return node.value;
    }



    public void clear() {
        first = null;
        last = null;
    }


    @Override
    public Iterator<T> iterator() {
        return new MyListIterator<T>(first);
    }
}
