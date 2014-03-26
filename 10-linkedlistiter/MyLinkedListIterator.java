import java.util.*;

public class MyLinkedListIterator<T> implements Iterator {
    private Node<T> cur;

    public MyLinkedListIterator(Node<T> n) {
        cur = n;
    }
    public boolean hasNext() {
	return cur.getNext()!=null;
    }
    public T next() {
	cur = cur.getNext();
	return cur.getData();
    }
    public void remove() {
	throw new Error("remove() is not implemented");
	//return;
    }
}
