import java.util.*;

public class MyLinkedList<T> implements Iterable {
    private Node<T> head;
    private Node<T> tail;
    
    public MyLinkedList() {
	head = new Node<T>();
	tail = head;
    }

    public Iterator<T> iterator() {
	return new MyLinkedListIterator<T>(head);
    }

    public int size() {
	int s = 0;
	Node<T> cur = head;
	while(cur!=tail) {
	    s++;
	    cur = cur.getNext();
	}
	return s;
    }
    
    public Node<T> nodeAt(int index) {
	if(index<-1) {
	    throw new IndexOutOfBoundsException(Integer.toString(index));
	}
	
        Node<T> cur = head;
	for(int i=0; i<=index; i++) {
	    cur = cur.getNext();
	    if(cur==null) {
		throw new IndexOutOfBoundsException
		    (Integer.toString(index));
	    }
	}
	return cur;
    }
    public T get(int index) {
	return nodeAt(index).getData();
    }

    public T set(int index, T s) {
	Node<T> n = nodeAt(index);
	T last = n.getData();
        n.setData(s);
	return last;
    }

    public void add(T n) {
	Node<T> next = new Node<T>(n,tail);
	tail.setNext(next);
	tail = next;
    }
    public void add(int index, T n) {
	if(index<0) {
	    throw new IndexOutOfBoundsException(Integer.toString(index));
	}

	Node<T> cur = nodeAt(index-1);
	Node<T> toadd = new Node<T>(n,cur);
	Node<T> after = cur.getNext();
	cur.setNext(toadd);
	if(cur==tail) {
	    tail=toadd;
	} else {
	    toadd.setNext(after);
	    after.setPrev(toadd);
	}
    }

    public T remove(int index) {
	if(index<0) {
	    throw new IndexOutOfBoundsException(Integer.toString(index));
	}
        
	Node<T> cur = nodeAt(index-1);
	Node<T> toremove = cur.getNext();
	if(toremove.getNext()==null) {
	    tail = cur;
	} else {
	    toremove.getNext().setPrev(cur);
	}
	cur.setNext(nodeAt(index+1));
	return toremove.getData();
    }

    public int find(T s) {
	Node<T> cur = head.getNext();
	int i = 0;
	while(cur!=null) {
	    if(cur.getData().equals(s)) {
		return i;
	    }
	    cur = cur.getNext();
	    i++;
	}
	return -1;
    }

    public String toString() {
	String r = "[";
	Node<T> cur = head;
	while(cur!=tail) {
	    cur = cur.getNext();
	    r+=cur.toString();
	    if(cur!=tail) {r+=",";}
	}
	return r+"]  ("+size()+")";
    }

    public String toStringBackward() {
	String r = "[";
	Node<T> cur = tail;
	Node<T> first = head.getNext();
	while(cur!=head) {
	    r+=cur.toString();
	    if(cur!=first) {r+=",";}
	    cur = cur.getPrev();
	}
	return r+"]  ("+size()+")";
    }
}
